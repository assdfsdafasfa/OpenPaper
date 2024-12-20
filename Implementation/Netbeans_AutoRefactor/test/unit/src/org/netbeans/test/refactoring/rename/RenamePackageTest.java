/*
 * The contents of this file are subject to the terms of the Common Development
 * and Distribution License (the License). You may not use this file except in
 * compliance with the License.
 *
 * You can obtain a copy of the License at http://www.netbeans.org/cddl.html
 * or http://www.netbeans.org/cddl.txt.
 *
 * When distributing Covered Code, include this CDDL Header Notice in each file
 * and include the License file at http://www.netbeans.org/cddl.txt.
 * If applicable, add the following below the CDDL Header, with the fields
 * enclosed by brackets [] replaced by your own identifying information:
 * "Portions Copyrighted [year] [name of copyright owner]"
 *
 * The Original Software is NetBeans. The Initial Developer of the Original
 * Software is Sun Microsystems, Inc. Portions Copyright 1997-2006 Sun
 * Microsystems, Inc. All Rights Reserved.
 */
package org.netbeans.test.refactoring.rename;
import java.io.IOException;
import junit.textui.TestRunner;
import org.netbeans.modules.refactoring.api.MoveClassRefactoring;
import org.netbeans.modules.refactoring.api.RefactoringSession;
import org.netbeans.jmi.javamodel.JavaClass;
import org.netbeans.junit.NbTestCase;
import org.netbeans.junit.NbTestSuite;
import org.netbeans.test.refactoring.Utility;
import org.openide.filesystems.FileObject;
import org.openide.filesystems.FileStateInvalidException;
import org.openide.filesystems.FileUtil;


/**
 * @author  Jan Becicka
 */
public class RenamePackageTest extends NbTestCase {
    
    /** Need to be defined because of JUnit */
    public RenamePackageTest(String name) {
        super(name);
    }
    
    public static NbTestSuite suite() {
        NbTestSuite suite = new NbTestSuite();
        suite.addTest(new RenamePackageTest("testRename"));
        suite.addTest(new RenamePackageTest("testCheckTestClass"));
        suite.addTest(new RenamePackageTest("testCheckTestException"));
        suite.addTest(new RenamePackageTest("testCheckTestInterface"));
        suite.addTest(new RenamePackageTest("testCheckTestPackages"));

        JavaClass jc = Utility.findClass("org.netbeans.test.rename.testpackage.TestClass");
        
        return suite;
    }
    
    private static FileObject pckg;

    private static final String newName = "test2";
    
    public void testRename() throws FileStateInvalidException {
        
        pckg = FileUtil.toFileObject(Utility.getFile(getDataDir(), "org/netbeans/test/rename/testpackage"));
        MoveClassRefactoring refactoring = new MoveClassRefactoring(pckg, false);
        refactoring.setTargetClassPathRoot(FileUtil.toFileObject(getDataDir()));
        refactoring.setTargetPackageName(newName);
        refactoring.checkParameters();
        RefactoringSession result = RefactoringSession.create("rename package");
        refactoring.prepare(result);
        assertNull(result.doRefactoring(true));
    }
    
    public void testCheckTestClass() throws IOException {
        assertFile("TestClass.java is not correct", Utility.getFile(getDataDir(), "org/netbeans/test/rename/test2/TestClass.java"), getGoldenFile(), getWorkDir()) ; 
    }
    
    public void testCheckTestException() throws IOException {
        assertFile("TestException.java is not correct", Utility.getFile(getDataDir(), "org/netbeans/test/rename/test2/TestException.java"), getGoldenFile(), getWorkDir()) ; 
    }

    public void testCheckTestInterface() throws IOException {
        assertFile("TestInterface.java is not correct", Utility.getFile(getDataDir(), "org/netbeans/test/rename/test2/TestInterface.java"), getGoldenFile(), getWorkDir()) ; 
    }
    
    public void testCheckTestPackages() throws IOException {
        assertFile("TestPackages.java is not correct", Utility.getFile(getDataDir(), "org/netbeans/test/rename/test2/TestPackages.java"), getGoldenFile(), getWorkDir()) ; 
    }
    
}
