class aaa extends RuntimeException
{
    public void sam()
    {
        throw new  aaa();
    }
}

public class eg4 
{
    public static void main(String[] args) 
    {
        
        int x=10,y=5,z;
        int m[]=new int[5];
        try 
        {
            aaa a=new aaa();
            a.sam();
            z=x/y; // this line can throw ArithmeticException
            System.out.println(m[x]); // this line can throw ArrayIndexOutOfBoundException
        }catch(Exception e)
        {
            if(e instanceof ArithmeticException)
            {
                System.out.println("can't divide by zero");
            }else if(e instanceof ArrayIndexOutOfBoundsException)
            {
                System.out.println("hey you are trying to fetch the resources/ element of an array out of its limit please check the limit");
            }
            if(e instanceof aaa)
            {
                System.out.println("exception is of aaa class type");
            }
        }
    }
}

/*
 * how we can chech the equality between two objects
 * exapmple we have a class aaa
 * another class bbb
 * i want to check if a person give me a objet obj1
 * instanceof
 */