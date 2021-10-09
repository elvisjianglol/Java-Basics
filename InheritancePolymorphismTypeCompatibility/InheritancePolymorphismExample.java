package InheritancePolymorphismTypeCompatibility;

class A {
    void f1() { System.out.println ("class A f1()"); }
    void f2() { System.out.println ("class A f2()"); }
    void f3() { System.out.println("class A f3()"); }
    }

class B extends A {
    void f1() { System.out.println ("class B f1()"); }
    void f2() { System.out.println ("class B f2()"); }
}

class C extends B {
    void f1() { System.out.println ("class C f1()"); }
    void f3() { System.out.println ("class C f3()"); }
    void f4() { System.out.println ("class C f4()"); }
}

public class InheritancePolymorphismExample {

    public static void main(String[] args){
        /* The relationship idea:
            Remember that inheritance goes from "broad" to "specialized"
                                               "parent" to "child"
            Not all students are college students
            All college students are students

         */
        /* Main Rules
        // Look at reference's type, it is class A; the instance it is attached to is of Class A as well
        // The left side class type, tells you what functions can be "possibly" called
        // The right (object) side class type, tells what functions actually "exist" there (you might MISS "specialized" methods)
        // Look for 'overlap' between what both classes have
        // methods are inherited from each parent above if any functions are "missing" and can be inherited
        */
        A refA1 = new A();//can access & execute class A functions: f1(), f2(), f(3)

        refA1.f1();// all belong to A class
        refA1.f2();
        refA1.f3();


        System.out.print("\n");


        // f1(), f2(), f3() visible in A reference. The C object actually has implementation for f1() and f3(); but, inherits parent B's f2()
        // & C's f3() is KEPT (Known as Overriding)
        // However, f4() is inaccessible because Class A doesn't have its OWN f4, neither can it inherit from parents
        A refA = new C();
        refA.f1();//C f1() overrides A f1();
        refA.f2();//inherited f2() from B
        refA.f3();// C's f3() OVERRIDES A's f(3)
        //refA.f4(); **Important: f4 is hidden from refA. To be able to access it has to be DOWN-CASTED

        // Down-casting. refA = Class C Object!    Watch out for runtime ERRORS
        // When casting down, make sure the reference that is being casted is originally tied with a matching object type to what you want to go down to
        // In this case, we want to cast refA down to a type of C to access all methods of C
        // refA ---> object C, so this works, otherwise RUNTIME error will occur
        C refC = (C)refA;
        refC.f4();//can access f4 now!


        System.out.print("\n");
        B refB = (B)refA;// can also downcast the Class A reference down to B
        // all you are doing is bringing down what "class type" of the reference is
        // as long as it follows the same basic rules, i.e. A --> A/B/C
        // NOT something like C --> A
        // it is fine
        refB.f1();// C
        refB.f2();// B

        //confusing way to write but a1 points to what refB is pointing to, which is just refA pointing to C object
        //basically just redundant way of writing A --> C
        A a1 = (A) refB;
        a1.f2();// inherit from B
        a1.f3();// C

        //Interesting note: can't override another Method to a weaker access modifier


    }

}
