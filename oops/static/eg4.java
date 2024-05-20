package com.thinking.machines;

class Test
{
    static String name;

    public Test(String name)
    {
        Test.name=name;
    }
}
public class InnerClassExample
{


    public static void main(String[] args)
    {
        Test t1=new Test("Rahul");
        Test t2=new Test("Ajay");
        System.out.println(t1.name);
        System.out.println(t2.name);
    }
}
