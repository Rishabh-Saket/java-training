
public class eg7 
{
    public static void main(String[] args) {
        int x=10,y=2;
        int z;
        int m[]=new int[5];
        try {
            z=x/y; // it is bound to throw the error because of idiotic logic
            try {
                m[30]=300;
                System.out.println(m[z]);
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("hello there is an error");
            }
            System.out.println("printing outside of inner try-catch block");
        } catch (ArithmeticException e) {
                System.out.println("can't divide by zero");
        }

    }    
}
// there is no infinity can'
// if we look at the chaining of exception occuring or population
// firstly thr first occuring exception is handled and then rest is resolved
// autoclosable
// in finally we write the piece of code that we want to happen either the exception is handled gracefulyy or not
