// multi-level inheritance
final abstract public class eg3 // parent  class
{
    abstract public void getSomething();
}

abstract class aaa extends eg3 // this is 2nd prior class
{
    abstract public void writeSomething();
}

class bbb extends aaa
{
    public void writeSomething()
    {

    }

    public void getSomething()
    {
        
    }
}