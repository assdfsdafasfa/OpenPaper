package refactoring.model;

import org.eclipse.jdt.internal.corext.refactoring.CuCollectingSearchRequestor;
import org.eclipse.core.runtime.CoreException;

import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IMethod;
import org.eclipse.jdt.core.compiler.IScanner;
import org.eclipse.jdt.core.compiler.ITerminalSymbols;
import org.eclipse.jdt.core.compiler.InvalidInputException;
import org.eclipse.jdt.core.search.MethodDeclarationMatch;
import org.eclipse.jdt.core.search.MethodReferenceMatch;
import org.eclipse.jdt.core.search.SearchMatch;

import org.eclipse.jdt.internal.corext.refactoring.CuCollectingSearchRequestor;
import org.eclipse.jdt.internal.corext.refactoring.base.ReferencesInBinaryContext;
public class MethodOccurenceCollector  extends CuCollectingSearchRequestor {
	/**
	 * Warning-free alias for <code>ITerminalSymbols.TokenNameIdentifier</code>.
	 * Should ideally use this only when you are sure it's not module-info.java
	 */
	@SuppressWarnings("deprecation")
	private static final int InternalTokenNameIdentifier= ITerminalSymbols.TokenNameIdentifier;

	private final String fName;

	public MethodOccurenceCollector(String methodName) {
		this(methodName, null);
	}

	public MethodOccurenceCollector(String methodName, ReferencesInBinaryContext binaryRefs) {
		super(binaryRefs);
		fName= methodName;
	}

	@Override
	public void acceptSearchMatch(ICompilationUnit unit, SearchMatch match) throws CoreException {
		if (match instanceof MethodReferenceMatch
				&& ((MethodReferenceMatch) match).isSuperInvocation()
				&& match.getAccuracy() == SearchMatch.A_INACCURATE) {
			return; // see https://bugs.eclipse.org/bugs/show_bug.cgi?id=156491
		}

		if (match.isImplicit()) { // see bug 94062
			collectMatch(match);
			return;
		}

		int start= match.getOffset();
		int length= match.getLength();
		String matchText= unit.getBuffer().getText(start, length);

		//direct match:
		if (fName.equals(matchText)) {
			collectMatch(match);
			return;
		}

		// lambda expression
		if (match instanceof MethodDeclarationMatch
				&& match.getElement() instanceof IMethod
				&& ((IMethod) match.getElement()).isLambdaMethod()) {
			// don't touch the lambda
			return;
		}

		//Not a standard reference -- use scanner to find last identifier token before left parenthesis:
		IScanner scanner= getScanner(unit);
		scanner.setSource(matchText.toCharArray());
		int simpleNameStart= -1;
		int simpleNameEnd= -1;
		try {
			int token = scanner.getNextToken();
			while (token != ITerminalSymbols.TokenNameEOF && token != ITerminalSymbols.TokenNameLPAREN) { // reference in code includes arguments in parentheses
				if (token == InternalTokenNameIdentifier) {
					simpleNameStart= scanner.getCurrentTokenStartPosition();
					simpleNameEnd= scanner.getCurrentTokenEndPosition();
				}
				token = scanner.getNextToken();
			}
		} catch (InvalidInputException e){
			//ignore
		}
		if (simpleNameStart != -1) {
			match.setOffset(start + simpleNameStart);
			match.setLength(simpleNameEnd + 1 - simpleNameStart);
		}
		collectMatch(match);
	}
}
