

// Abstration is basically means the act of representing essential features without knowing the background details
// abstraction is basically used for imposing guidelines
// we can't create the object of abstract class

// rule for decalring a class as abstarct is
//1. class should begin with abstract keyword
//2. if you are not decalring a method then method should be abstract as well

abstract class aaa {
    abstract public void func();
}

/**
 * suppose you have are a architect
 * for example you wanted to create a email service
 * so for that there will be sendEmail(String reciepintEmailAdrress,String senderEmailAddress,String subject......)
 */


// example of abstract class containing non-abstract method
abstract class EmailService
{
    abstract public void sendEmail(String reciepintEmailAdrress,String senderEmailAddress,String subject);

    // this is a non-abstract method because it doesn't contains abstarct keyword
    public void getEmail()
    {

    }
}

// does the abstract class contains non-abstract method

class psp
{
    public static void main(String[] args) 
    {
        EmailService emailService=new EmailService(); // we are creating the variable of EmailService
        //System.out.println(emailService);
    }
}