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
/*
 * Signature1User3.java
 *
 * Created on January 15, 2004, 10:56 AM
 */

package org.netbeans.test.signature;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author  Pavel Flaska
 */
public class Signature1User3 {

    static final String[] names = new String[] {
        "Katerina",
        "Katherine",
        "Cathleen",
        "Kathryn",
        "Katharina",
        "Caterina",
        "Catalina"
    };

    static final List l = Arrays.asList(names);

    // Method usage in constructor test
    public Signature1User3() {
        
    }

    // Method usage in inner class
    static class InnerClass {
        public String callCatalina() {
            Signature1Owner ow = new Signature1Owner();
            Object catalina = null;
            if (Math.random() > 0.2) {
                // in par
                return new StringBuffer(ow.signatureMethod(l, catalina, 7)).toString();
            }
            else {
                // in if
                if (ow.signatureMethod(l, catalina, 3).equals("Kathryn")) {
                    return "Winner is Kathryn!";
                }
                else {
                    Object anybody = null;
                    String s = ow.signatureMethod(l, anybody, 0);
                    for (int i = 0; s.charAt(0) != 'C'; s = ow.signatureMethod(l, anybody, i)) {
                        i++;
                    }
                    return "Winner is " + s + ".";
                }
            }
        }
    }
    
    // Method usage in anonymous class
    public void anon() {
        Object ann = new Object() {
            Object language = null;
            public String caller() {
                String s = new Signature1Owner().signatureMethod(l, language, 3);
                return s;
            }
        };
    }
}
