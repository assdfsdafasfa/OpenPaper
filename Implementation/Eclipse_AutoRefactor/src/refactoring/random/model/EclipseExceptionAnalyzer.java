package refactoring.random.model;

import java.util.List;

import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.ClassInstanceCreation;
import org.eclipse.jdt.core.dom.IMethodBinding;
import org.eclipse.jdt.core.dom.ITypeBinding;
import org.eclipse.jdt.core.dom.MethodInvocation;
import org.eclipse.jdt.core.dom.SuperMethodInvocation;
import org.eclipse.jdt.core.dom.ThrowStatement;
import org.eclipse.jdt.internal.corext.refactoring.util.AbstractExceptionAnalyzer;

public class EclipseExceptionAnalyzer extends AbstractExceptionAnalyzer {

	public static ITypeBinding[] perform(ASTNode[] statements) {
		EclipseExceptionAnalyzer analyzer = new EclipseExceptionAnalyzer();
		for (ASTNode statement : statements) {
			statement.accept(analyzer);
		}
		List<ITypeBinding> exceptions = analyzer.getCurrentExceptions();
		return exceptions.toArray(new ITypeBinding[exceptions.size()]);
	}

	@Override
	public boolean visit(ThrowStatement node) {
		ITypeBinding exception = node.getExpression().resolveTypeBinding();
		if (exception == null) // Safety net for null bindings when compiling fails.
			return true;

		addException(exception, node.getAST());
		return true;
	}

	@Override
	public boolean visit(MethodInvocation node) {
		return handleExceptions((IMethodBinding) node.getName().resolveBinding(), node);
	}

	@Override
	public boolean visit(SuperMethodInvocation node) {
		return handleExceptions((IMethodBinding) node.getName().resolveBinding(), node);
	}

	@Override
	public boolean visit(ClassInstanceCreation node) {
		return handleExceptions(node.resolveConstructorBinding(), node);
	}

	private boolean handleExceptions(IMethodBinding binding, ASTNode node) {
		if (binding == null)
			return true;
		addExceptions(binding.getExceptionTypes(), node.getAST());
		return true;
	}
}
