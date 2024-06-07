interface Common
{
    public boolean show();
    public boolean display();

}

interface Unique extends Common
{
    public boolean fun();

}

class A implements Unique
{

}
