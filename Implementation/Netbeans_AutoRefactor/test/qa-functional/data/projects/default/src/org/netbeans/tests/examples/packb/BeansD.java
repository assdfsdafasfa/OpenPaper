/*
 * BeansD.java
 *
 * Created on May 20, 2004, 2:19 PM
 */

package org.netbeans.tests.examples.packb;

import org.netbeans.tests.examples.packa.Bean;
import org.netbeans.tests.examples.packa.Testable;
import org.netbeans.tests.examples.packc.Makable;

/**
 *
 * @author  eh103527
 */
public class BeansD implements org.netbeans.tests.examples.packc.Makable {
    
    static {
        new BeansD(new BeanD());
    }
    
    BeanA bb;
    
    Bean[] beans;
    
    /** Creates a new instance of BeansD */
    public BeansD() {
        bb=new BeanDA("text");
    }
    
    public BeansD(BeanA bb) {
        this.bb=bb;
        
    }
    
    public static class BeanDA extends BeanA {
        int number=CODE;
        
        public BeanDA(java.lang.String text) {
            super();
            this.abc().abc().abc();
            BeanA copy=new BeanA();
            setProtectedProperty(copy.getProtectedProperty()+copy.getProtectedProperty()+copy.getProtectedProperty());
            protectedProperty=copy.protectedProperty+copy.protectedProperty;
            publicProperty=protectedProperty;
        }
        
        /**
         * Getter for property number.
         * @return Value of property number.
         */
        public int getNumber() {
            return number;
        }
        
        /**
         * Setter for property number.
         * @param number New value of property number.
         */
        public void setNumber(int number) {
            this.number = number*BeanB.CODE;
            System.out.println(getProtectedProperty());
        }
        
        public Bean abc() {
            return this;
        }
    }
    
    public class BeanDC extends BeanC {
        
        public String getProtectedProperty() {
            return super.getProtectedProperty()+"aaa";
        }
        
        public void make(int index, java.lang.String s, Bean bean) {
            System.out.println("testinner "+protectedProperty+publicProperty);
        }
        
        public Bean abc() {
            System.out.println("abc");
            protectedProperty="abc";
            publicProperty="def";
            return super.abc();
        }
    }
    
    protected Bean[] getBeans() {
        return beans;
    }
    
    public void setBeans(Bean[] bss) {
        beans=bss;
    }
    
    public Object[] finish() {
        System.out.println("text "+bb.getProtectedProperty()+" "+((Bean)bb).abc());
        
        return null;
    }
    
    public void prepare(Object[] data) {
        ((Testable)bb).test();
        ((BeanD)bb).getProtectedProperty();
    }
    
    public org.netbeans.tests.examples.packc.Makable prepare() {
        ((Makable)new BeanDD("ttt")).make(10, "", bb);
        System.out.println("message");
        System.out.println();
        return new BeanDD("ttt");
    }
    
    public void make(int index, java.lang.String s, Bean bean) {
        System.out.println("test1");
    }
    
}


class BeanD extends BeanC {
    
    int counter=0;
    
    /**
     * Getter for property counter.
     * @return Value of property counter.
     */
    public int getCounter() {
        return counter;
    }
    
    /**
     * Setter for property counter.
     * @param counter New value of property counter.
     */
    public void setCounter(int counter) {
        this.counter = counter;
        String[] s=new String[] {
            "sss",
            protectedProperty,
            "qqqqq",
            publicProperty
        };
    }
    
    public java.lang.String getProtectedProperty() {
        java.lang.String retValue;
        System.out.println("getProtectedProperty");
        retValue = super.getProtectedProperty();
        return (protectedProperty+retValue).substring(1);
    }
    
}

class BeanDD extends BeanB {
    long length;
    
    public BeanDD(String text) {
        super();
        Bean b=new BeanB();
    }
    
    /**
     * Getter for property length.
     * @return Value of property length.
     */
    public long getLength() {
        return length;
    }
    
    /**
     * Setter for property length.
     * @param length New value of property length.
     */
    public void setLength(long length) {
        this.length = length*Makable.CODE;
    }
    
    public void make(int a, String s, Bean b) {
        refID=a;
    }
    
    public Bean abc() {
        return this;
    }
}