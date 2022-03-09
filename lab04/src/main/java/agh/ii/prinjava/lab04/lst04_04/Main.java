package agh.ii.prinjava.lab04.lst04_04;

/**
 * A series of auxiliary definitions (interfaces and classes)
 */
interface IA {
    void mA();
}

interface IB extends IA {
    void mB();
}

interface IC extends IB {
    void mC();
}

interface I10 {
    void m10();
}

class CA implements IA {
    @Override
    public void mA() {
        System.out.println("A.mA");
    }
}

class CB implements IB {
    @Override
    public void mA() {
        System.out.println("B.mA");
    }

    @Override
    public void mB() {
        System.out.println("B.mB");
    }
}

class CC implements IC {
    @Override
    public void mA() {
        System.out.println("C.mA");
    }

    @Override
    public void mB() {
        System.out.println("C.mB");
    }

    @Override
    public void mC() {
        System.out.println("C.mC");
    }
}

class A10 implements IA, I10 {
    @Override
    public void mA() {
        System.out.println("A10.mA");
    }

    @Override
    public void m10() {
        System.out.println("A10.m10");
    }
}

/**
 * <i>Unconstrained parametric polymorphism</i>
 * <p>{@code GenClass0<T>} - the "T" represents all reference types
 */
class GenClass0<T> {
    void m1(T p) {
        // p is treated as having type Object -> only methods defined in the Object are available
    }
}

/**
 * You can require a type parameter to be a subtype of one or more types (<i>constrained parametric polymorphism</i>)
 * <p>{@code GenClassA<T extends IA>} - the T represents all types that extend/implement {@code IA}
 */
class GenClassA<T extends IA> {
    void m1(T p) {
        p.mA(); // OK, p is treated as of type A
    }
}

/**
 * <p>{@code GenClassB<T extends IB>} - the T represents all types that extend/implement {@code IB}
 */
class GenClassB<T extends IB> {
    void m1(T p) {
        p.mA(); // OK, p is treated as of type B
        p.mB(); // OK, as above
    }
}

/**
 * <p>{@code GenClassC<T extends IC>} - the T represents all types that extend/implement {@code IC}
 */
class GenClassC<T extends IC> {
    void m1(T p) {
        p.mA(); // OK, p is treated as of type C
        p.mB(); // OK, as above
        p.mC(); // OK, as above
    }
}

/**
 * A multiple-bound type parameter, T (being a subtype of two types, here they are interfaces)
 */
class GenClassA10<T extends IA & I10> {
    void m1(T p) {
        p.mA(); // OK, p is treated as having type IA
        p.m10(); // OK, p is treated as having type I10
    }
}

public class Main {
    private static void demo0() {
        System.out.println("demo0...");

        GenClass0<Double> gc1 = new GenClass0<>();
        gc1.m1(Double.valueOf(4.5));

        GenClass0<String> gc2 = new GenClass0<>();
        gc2.m1("ABC");

        GenClass0<CA> gc3 = new GenClass0<>();
        gc3.m1(new CA());

        GenClass0<CB> gc4 = new GenClass0<>();
        gc4.m1(new CB());

        GenClass0<CC> gc5 = new GenClass0<>();
        gc5.m1(new CC());
    }

    private static void demoA() {
        System.out.println("\ndemoA...");

        // Type parameter 'Double' is not within its bound; should implement 'IA'
        // GenClassA<Double> gcA1 = new GenClassA<>();

        GenClassA<CA> gcA = new GenClassA<>(); // OK, CA implements IA, class GenClassA<T extends IA>
        gcA.m1(new CA());
        // gcA.m1(new CB()); // Requires type CA, provided with CB
        System.out.println("---");

        GenClassA<CB> gcB = new GenClassA<>();
        gcB.m1(new CB());
        System.out.println("---");

        GenClassA<CC> gcC = new GenClassA<>();
        gcC.m1(new CC());
    }

    private static void demoB() {
        System.out.println("\ndemoB...");

        // Type parameter 'CA' is not within its bound; should implement 'IB'
        //GenClassB<CA> gcA = new GenClassB<>();

        GenClassB<CB> gcB = new GenClassB<>(); // OK, class GenClassB<T extends IB>
        gcB.m1(new CB());
        System.out.println("---");

        GenClassB<CC> gcC = new GenClassB<>(); // OK
        gcC.m1(new CC());
    }

    private static void demoC() {
        System.out.println("\ndemoC...");

        // Type parameter 'CA' is not within its bound; should implement 'IC'
        //GenClassC<CA> gcA = new GenClassC<>();

        // Type parameter 'CB' is not within its bound; should implement 'IC'
        //GenClassC<CB> gcA = new GenClassC<>();

        GenClassC<CC> gcC = new GenClassC<>(); // OK
        gcC.m1(new CC());
    }

    private static void demoA10() {
        System.out.println("\ndemoA10...");
        GenClassA10<A10> gcA10 = new GenClassA10<>(); // OK, A10 implements both IA and I10
        gcA10.m1(new A10());
    }

    public static void main(String[] args) {
        demo0();
        demoA();
        demoB();
        demoC();
        demoA10();
    }
}
