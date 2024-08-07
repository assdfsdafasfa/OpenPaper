package refactoring.random.model;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jdt.core.dom.ITypeBinding;
import org.eclipse.jdt.core.dom.Modifier;
import org.eclipse.jdt.core.dom.SimpleName;
import org.eclipse.jdt.core.dom.SingleVariableDeclaration;
import org.eclipse.jdt.internal.corext.refactoring.code.flow.FlowInfo;

public class ParameterData {

	public static final String PROPERTY = ParameterData.class.getName();

	private SingleVariableDeclaration fDeclaration;
	private int fAccessMode;
	private List<SimpleName> fReferences;
	private int fOperatorPrecedence;

	public ParameterData(SingleVariableDeclaration decl) {
		super();
		fDeclaration = decl;
		fAccessMode = FlowInfo.UNUSED;
		fReferences = new ArrayList<>(2);
		fOperatorPrecedence = -1;
	}

	public String getName() {
		return fDeclaration.getName().getIdentifier();
	}

	public ITypeBinding getTypeBinding() {
		return fDeclaration.resolveBinding().getType();
	}

	public void addReference(SimpleName node) {
		fReferences.add(node);
	}

	public List<SimpleName> references() {
		return fReferences;
	}

	public void setAccessMode(int mode) {
		fAccessMode = mode;
	}

	public boolean isUnused() {
		return fAccessMode == FlowInfo.UNUSED;
	}

	public boolean isFinal() {
		return Modifier.isFinal(fDeclaration.getModifiers());
	}

	public boolean isReadOnly() {
		return (fAccessMode & (FlowInfo.READ | FlowInfo.READ_POTENTIAL)) != 0;
	}

	public boolean isWrite() {
		return (fAccessMode & (FlowInfo.WRITE | FlowInfo.WRITE_POTENTIAL | FlowInfo.UNKNOWN)) != 0;
	}

	public int getSimplifiedAccessMode() {
		if (isWrite())
			return FlowInfo.WRITE;
		if (isReadOnly())
			return FlowInfo.READ;
		return FlowInfo.UNUSED;
	}

	public int getNumberOfAccesses() {
		return fReferences.size();
	}

	public boolean needsEvaluation() {
		if (fReferences.size() <= 1)
			return false;
		return true;
	}

	public void setOperatorPrecedence(int newValue) {
		if (newValue == -1 || fOperatorPrecedence == -1) {
			fOperatorPrecedence = newValue;
		} else {
			fOperatorPrecedence = Math.min(fOperatorPrecedence, newValue);
		}
	}

	public int getOperatorPrecedence() {
		return fOperatorPrecedence;
	}
}
