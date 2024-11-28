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
 * Signature1User2.java
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
public class Signature1User2 {

    static String resultText;

    static final String[] names = new String[] {
        "Marketa",
        "Lenka",
        "Petra",
        "Katka",
        "Zdenka",
        "Gabina",
        "Hanka",
        "Karla",
        "Martina",
        "Daniela",
        "Kristina",
        "Kristyna"
    };

    static int num = (int) Math.random() * 10;
    
    static Object niceGirl = null;
    
    // method usage in field init value test
    static String niceGirlText = new Signature1Owner().signatureMethod(Arrays.asList(names), niceGirl, num);
    
    // method usage in static initializer
    static {
        Object girl = null;
        List l = Arrays.asList(names);
        Signature1Owner owner = new Signature1Owner();
        resultText = owner.signatureMethod(l, girl, 7);
    }

    /** Creates a new instance of Signature1User2 */
    public Signature1User2() {
    }
    
}
