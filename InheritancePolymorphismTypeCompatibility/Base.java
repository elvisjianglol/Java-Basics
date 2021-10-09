package InheritancePolymorphismTypeCompatibility;

public class Base
{
    public void methodOne()
    {
        System.out.print("A");
        methodTwo();
    }

    public void methodTwo()
    {
        System.out.print("B");
    }
}

class Derived extends Base
{
    public void methodOne()
    {
        super.methodOne();
        System.out.print("C");
    }

    public void methodTwo()
    {
        super.methodTwo();
        System.out.print("D");
    }
}

class Tester{
    public static void main(String[] args){
        Base b = new Derived();
        b.methodOne(); // ABDC

        System.out.println();
        Base base = new Base();
        base.methodOne(); // AB

        System.out.println();
        b.methodTwo(); // BD



    }
}


