package oops.inheritance;

public class eg1 extends Box 
{
    double weight;

    public eg1()
    {
        this.weight=-1;
    }

    public eg1(double l,double h, double w, double weight)
    {
        super(l, h, w);
        this.weight=weight;
    }
}
