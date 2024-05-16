class eg3 
{
    public static void main(String[] args) 
    {
        
        int x=10,y=5,z;
        int m[]=new int[5];
        try 
        {
            z=x/y;
            System.out.println(m[x]);
        } catch (ArithmeticException e) {
            System.out.println("can't divide by zero");
        }catch(ArrayIndexOutOfBoundsException a)
        {
            System.out.println("hey you are trying to fetch the resources/ element of an array out of its limit please check the limit");
        }
    }
}


// ArrayIndexOutOf---> a non programnner will ever undersatnd 
// e==java.lang.Arith