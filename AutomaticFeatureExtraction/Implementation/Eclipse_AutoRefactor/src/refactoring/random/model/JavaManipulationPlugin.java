package refactoring.random.model;

import org.eclipse.core.runtime.Plugin;
import org.eclipse.jdt.core.manipulation.JavaManipulation;
import org.eclipse.jdt.internal.core.manipulation.MembersOrderPreferenceCacheCommon;
import org.eclipse.osgi.service.debug.DebugOptions;
import org.eclipse.osgi.service.debug.DebugOptionsListener;
import org.osgi.framework.BundleContext;

public class JavaManipulationPlugin extends Plugin implements DebugOptionsListener {

	public static final boolean CODEASSIST_SUBSTRING_MATCH_ENABLED = //
			Boolean.parseBoolean(System.getProperty("jdt.codeCompleteSubstringMatch", "true")); //$NON-NLS-1$//$NON-NLS-2$

	/**
	 * A named preference that holds the favorite static members.
	 * <p>
	 * Value is of type <code>String</code>: semicolon separated list of favorites.
	 * </p>
	 */
	public final static String CODEASSIST_FAVORITE_STATIC_MEMBERS = "content_assist_favorite_static_members"; //$NON-NLS-1$

	public static boolean DEBUG_AST_PROVIDER;

	public static boolean DEBUG_TYPE_CONSTRAINTS;

	// The shared instance.
	private static JavaManipulationPlugin fgDefault;

	private MembersOrderPreferenceCacheCommon fMembersOrderPreferenceCacheCommon;

	/**
	 * The constructor.
	 */
	public JavaManipulationPlugin() {
		fgDefault = this;
	}

	@Override
	public void start(BundleContext context) throws Exception {
		super.start(context);
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		super.stop(context);
		fgDefault = null;
	}

	/**
	 * Returns the shared instance.
	 *
	 * @return the shared instance.
	 */
	public static JavaManipulationPlugin getDefault() {
		return fgDefault;
	}

	/**
	 * Returns the shared Members Order Preference Common Cache
	 *
	 * @return the shared cache
	 */
	public MembersOrderPreferenceCacheCommon getMembersOrderPreferenceCacheCommon() {
		if (fMembersOrderPreferenceCacheCommon == null) {
			fMembersOrderPreferenceCacheCommon = new MembersOrderPreferenceCacheCommon();
		}
		return fMembersOrderPreferenceCacheCommon;
	}

	/**
	 * Set the default Members Order Preference Cache Common
	 *
	 * @param mpcc - MembersOrderPreferenceCacheCommon default
	 */
	public void setMembersOrderPreferenceCacheCommon(MembersOrderPreferenceCacheCommon mpcc) {
		fMembersOrderPreferenceCacheCommon = mpcc;
	}

	public static String getPluginId() {
		return JavaManipulation.ID_PLUGIN;
	}

	@Override
	public void optionsChanged(DebugOptions options) {
		DEBUG_AST_PROVIDER = options.getBooleanOption("org.eclipse.jdt.core.manipulation/debug/ASTProvider", false); //$NON-NLS-1$
		DEBUG_TYPE_CONSTRAINTS = options.getBooleanOption("org.eclipse.jdt.core.manipulation/debug/TypeConstraints", //$NON-NLS-1$
				false);
	}
}
