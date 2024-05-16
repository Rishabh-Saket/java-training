class aaa{
    public int fun(int a, int b)
    {
        return a/b;
    }
}
public class eg6 
{
    public static void main(String[] args) {
        int x=10,y=0;
        int z;
        aaa a=new aaa();
        try {
            z=a.fun(x, y);
            System.out.println(z);
        } catch (Exception e) {
            if(e instanceof ArithmeticException)
            {
                System.out.println("can't divide by zero");
            }
        }

    }    
}
// there is no infinity can'
