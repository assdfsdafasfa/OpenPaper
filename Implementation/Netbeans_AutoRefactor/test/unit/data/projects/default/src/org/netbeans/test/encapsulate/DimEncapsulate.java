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

package org.netbeans.test.encapsulate;

/**
 *
 * @author  Tomas Hurka
 */
public class DimEncapsulate {
    float b[];
    int[] a;
    double[] c[];
    short[] d,e[];

    public DimEncapsulate() {
    }

    class GGG {

    }

    void ff() {
        float f;
        b[0]=1;
        f=b[0];
    }

    void dd() {
        a[0]=0;
    }

    void ggg() {
        c[0][0]=0;
    }

    void ddd() {
        d[0]=0;
    }

    void eeee() {
        e[0][0]=0;
    }
}