public class eg4 
{
   private eg4(){}
}

class aaa extends eg4
{
    public static void main(String[] args) {
        System.out.println();
        // Systetm class has a private constructor so it  will not compile
        new System();
    }
}
