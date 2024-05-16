
class InvalidFamilyMemeberException extends Exception
{
    InvalidFamilyMemeberException(String message)
    {
        super(message);
    }
}

class FinanceCalculator
{
    int amt;

    public int calculateEligibility(int nof, int sal) throws InvalidFamilyMemeberException
    {
        if(nof<=0) throw new InvalidFamilyMemeberException("No. of family members can't be negative");
        if(nof==0) throw new InvalidFamilyMemeberException("No. of family members can't also be zero");
        return (sal*10)/nof;
    }
}

class psp
{
    public static void main(String[] args) {
        int n=5;
        int sal=23242434;
        FinanceCalculator f=new FinanceCalculator();
        try {
            int amt=f.calculateEligibility(n, sal);
            System.out.println(amt);
        } catch (InvalidFamilyMemeberException e) {
            System.out.println(e);
        }catch(Exception e)
        {
            System.out.println(e.getMessage());
        }

    }
}

/*
 * lets supose you know about arithmetic instantiation illegalacessexception
 * you are working with AKTSOFT app and you got AKTSOFTException
 * this is the scenario where we might get an custom exception that too was desgined to ease exception
 * the class extending the Exception class or Throwable then this class can be considered as CustomException class
 * Our main Exception class will be having two types of constructor 
 * 1. Parameterized 
 * 2. Non-Parameterized
 * 
 * class Exception
 * {
 * Exception()
 * {
 * }
 * 
 * Exception(String message)
 * {
 * }
 * }
 * 
 * e(instance of Exception) if we print e direclty it will give Exception class name and message
 * if we do e.getMessage() we will get the thrown message only
 */