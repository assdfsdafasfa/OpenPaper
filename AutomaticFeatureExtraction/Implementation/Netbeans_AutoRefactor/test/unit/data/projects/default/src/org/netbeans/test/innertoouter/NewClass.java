package org.netbeans.test.innertoouter;

public class NewClass {
    
    private int test;
    
    public void foo() {
        Inner inner = new Inner();
    }
    
    public class Inner {
        
    }
}