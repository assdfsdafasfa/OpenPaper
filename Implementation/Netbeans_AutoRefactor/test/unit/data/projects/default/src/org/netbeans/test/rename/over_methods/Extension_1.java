/*
 * Extension_1.java
 *
 * Created on 12 February 2004, 11:44
 */

package org.netbeans.test.rename.over_methods;

/**
 *
 * @author  Dan
 */
public class Extension_1 extends BaseClass implements Interface {
    
    /** Creates a new instance of Extension_1 */
    public Extension_1() {
    }
    
    public int generateNumber(int x, int y) {
        return x * y % 100;
    }
    
    public int sumNumbers(int x, int y) {
        return x + y;
    }
    
    private void waitAMinute() {
        generateNumber(9,9);
        sumNumbers(2,2);
    }
    
    protected final void jump() {
    }
    
     public void beep() {
    }
    
}
