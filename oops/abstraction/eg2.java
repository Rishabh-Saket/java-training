

abstract class EmailService // parent class
{
    abstract public boolean sendEmail(String reciepintEmailAdrress,String senderEmailAddress,String subject);

    // this is a non-abstract method because it doesn't contains abstarct keyword
    // EmaiSErvice emailService--> sendEmail, getEmail
    public void getEmail()
    {

    }
}

// this class/object/instance variables they will know only sendEmail and getEmail

abstract class EmailServiceImplementation extends EmailService // child class
{
    abstract public void createConnection(String sender,String reciever);

}

/*
 * conclusion
 * 1. if we inherit the abstract class
 * then we have to implement the abstract method
 * we are bound to implement the abstract method but we are not bound for the non-abstract methods
 * if we are extending the abstarct classes and we are not implementing the abstract methods then 
 * then the class which is bound to implement the methods can also declare as abstract
 * we can have a abstraction chaining 
 */

 class aaa
 {
    public void fun()
    {

    }

    public void gun()
    {

    }
 }
// the class aaa will know that i ahve a method fun, gun also
// object of this same class