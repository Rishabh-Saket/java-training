package com.thinking.machines;


public class InnerClassExample
{

    static class Test
    {
        String name;

        public Test(String name)
        {
            this.name=name;
        }
    }

    public static void main(String[] args)
    {
        Test t1=new Test("Rahul");
        Test t2=new Test("Ajay");
        System.out.println(t1.name);
        System.out.println(t2.name);
    }
}
