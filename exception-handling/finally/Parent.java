
/*
 * super is a keyword to call the constructor of a parent class 
 * if there is parent class and it has some parameterized or non- parameterized construtor 
 * we can call direclty through child
 * our aim is to check whether we can deliver some message to a parent class constructor
 */

public class Parent {
    public Parent(String message)
    {
        System.out.println(message);
    }
}

class child extends Parent
{
    child(String message)
    {
        super(message); // please deliver this messsage to a parent class constructor
    }
}

class psp
{
    public static void main(String[] args) {
        child c=new child("horrray the parent class got called");
    }
}