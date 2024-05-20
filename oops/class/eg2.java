package com.thinking.machines;


public class eg2
{
    public static void main(String[] args)
    {
        Student s2=new Student(2,"Rishabh",234);
        System.out.println(s2);
        System.out.println(s2.rno);
        System.out.println(s2.name);
        System.out.println(s2.marks);

        Student ss;
        for(int i=0;i<100000000;i++)
        {
            ss=new Student();
        }
    }
}
