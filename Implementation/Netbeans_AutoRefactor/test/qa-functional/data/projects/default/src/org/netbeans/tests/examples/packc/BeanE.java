/*
 * BeanE.java
 *
 * Created on July 23, 2004, 2:22 PM
 */

package org.netbeans.tests.examples.packc;

import org.netbeans.tests.examples.Test;

/**
 *
 * @author  eh103527
 */
public class BeanE {
    
    /** Creates a new instance of BeanE */
    public BeanE() {
        
    }
    
    public void run() {
        Test t1=new Test("1");
        t1.runTest();
        Test.makeTest();
        t1.test1();
    }
    
    public double count(double[] v1, double[] v2) {
        if (v1.length != v2.length) {
            throw new IllegalArgumentException();
        }
        double len1, len2, pow;
        len1=0.0;
        len2=0.0;
        pow=0.0;
        for (int i=0;i < v1.length;i++) {
            len1+=v1[i]*v1[i];
            len2+=v2[i]*v2[i];
            pow+=v1[i]*v2[i];
        }
        for (int i=0;i < v1.length;i++) {
            v1[i]=v1[i]/len1;
            v2[i]=v2[i]/len2;
        }
        len1=Math.sqrt(len1);
        len2=Math.sqrt(len2);
        return pow/(len1*len2);
    }
}
