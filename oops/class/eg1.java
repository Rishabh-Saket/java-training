package com.thinking.machines;

class Student
{
    int rno;
    String name;
    int marks;

    Student()
    {
        this.rno=0;
        this.name=null;
        this.marks=0;
    }

    Student(int rno,String name,int marks)
    {
        this.rno=rno;
        this.name=name;
        this.marks=marks;
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("Object is destroyed");
    }
}

public class eg1
{
    public static void main(String[] args)
    {
        Student s=new Student();
        System.out.println(s);
        System.out.println(s.rno);
        System.out.println(s.name);
        System.out.println(s.marks);
    }
}

