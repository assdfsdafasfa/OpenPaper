package refactoring.model;

public interface IRefactoringSaveModes {
	/**
	 * Save mode to save all dirty editors (always ask).
	 */
	public static final int SAVE_ALL_ALWAYS_ASK= 1;

	/**
	 * Save mode to save all dirty editors.
	 */
	public static final int SAVE_ALL= 2;

	/**
	 * Save mode to not save any editors.
	 */
	public static final int SAVE_NOTHING= 3;

	/**
	 * Save mode to save all editors that are known to cause trouble for Java refactorings, e.g.
	 * editors on compilation units that are not in working copy mode.
	 */
	public static final int SAVE_REFACTORING= 4;
}
