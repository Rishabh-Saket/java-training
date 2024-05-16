class aaa extends RuntimeException
{
    public void sam()
    {
        throw new  aaa();
    }
}

class psp
{
    public static void main(String[] args)
    {
        aaa a=new aaa();
            
        a.sam();
    }
}
