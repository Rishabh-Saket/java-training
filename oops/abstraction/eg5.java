abstract class Animal
{
    public int getAge()
    {
        return 10;
    }
}

class Donkey extends Animal
{
    public int getAge()
    {
        return 20;
    }
}

class Monkey extends Animal
{
    public int getage()
    {
        return 100;
    }
}

class aaa
{
    public int getAge()
    {
        return 75;
    }
}

class Lion
{
    public void eat(Animal a) // it can accept the variables of type Animal or its children class Monkey and Donkey
    {
        int x=a.getAge();
        System.out.println(x);
    }
}

class zoo
{
    public static Lion l=new Lion();
}

class psp
{
    public static void main(String[] args) 
    {
        Donkey d=new Donkey();
        Monkey m=new Monkey();
        aaa a=new aaa();
        zoo.l.eat(d);  // zoo is a class and l is a pointer/ instance variable of Lion class and it is static
        // hence can be directly accessed by zoo class name itself
        zoo.l.eat(m); // this is similar to System.out.println(something)
    }
}