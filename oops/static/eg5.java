package com.thinking.machines;

public class InnerClassExample {

    public static void main(String[] args) {
        // Create an instance of the inner class to access its member variables
        InnerClassExample.Test test = new InnerClassExample.Test("Inner Class Object");

        System.out.println(test.name); // Output: Inner Class Object
    }

    // Inner class declaration with proper access modifier
    public class Test {
        public String name;

        public Test(String name) {
            this.name = name; // Use 'this' to avoid shadowing
        }
    }
}
