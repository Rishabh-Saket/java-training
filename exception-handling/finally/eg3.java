public class eg3
{
    public static void main(String[] args) {
        int x=10,y=0;
        int z;
        try {
            z=x/y; // it is bound to throw the error because of idiotic logic
            System.out.println(z);
            System.out.println("printing outside of inner try-catch block");
        }finally
        {
            System.out.println("the end of the program");
        }

    }    
}
// parsing exception when we want to convert the string to a data 
// 12/04/24  sdfsdfdsffs->