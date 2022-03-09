package agh.ii.prinjava.lab04.lst04_03;

/**
 * Just like type declarations, method declarations can be generic, i.e., parameterized by one or more type parameters.
 * A <i>generic method</i> is a method that declares one or more type variables.
 * <p>Generic methods allow type parameters to be used to express dependencies among
 * the types of one or more arguments of a method and/or its return type.
 */
class C1 {
    /**
     * Instance generic method
     */
    <T> T m1(T x) {
        return x;
    }

    /**
     * Static generic method
     */
    static <T> T sm1(T y) {
        return y;
    }
}

class C2 {
    /**
     * Static generic method with two type parameters/variables
     */
    static <R, T> R m1(T x, R r) {
        return r;
    }
}

/**
 * Generic class with a generic method
 */
class C3<T> { // This "T"...
    private T x;

    // ... has nothing to do with the "T" below (DO NOT reuse the same name! See the comment below)
    <T> T sm1(T x) {
        return x;
    }
}

/**
 * We use T for type, whenever there is nothing more specific about the type to distinguish it.
 * This is often the case in generic methods.
 * <ul>
 *     <li>If there are multiple type parameters, we might use letters that neighbour the letter T in the alphabet,
 *         such as S</li>
 *     <li>If a generic method appears inside a generic class, it is a good idea to avoid using the same names
 *         for the type parameters of the method and class to avoid confusion.
 *         The same applies to nested generic classes</li>
 * </ul>
 *
 * @see <a href="https://docs.oracle.com/javase/tutorial/extra/generics/methods.html">Generic Methods</a>
 */
class C4<T> { // "T" here refers to a class type parameter
    private T x;

    // "U" stands for a type parameter of the method sm1 (in general it can refer to a different type than "T")
    <U> U sm1(U x) {
        return x;
    }
}

abstract class Shape {
    abstract double area();
}

class Rectangle extends Shape {
    private final double w;
    private final double h;

    public Rectangle(double w, double h) {
        this.w = w;
        this.h = h;
    }

    @Override
    double area() {
        return w * h;
    }
}

class Circle extends Shape {
    private final double r;

    public Circle(double r) {
        this.r = r;
    }

    @Override
    double area() {
        return Math.PI * r * r;
    }
}

public class Main {
    /**
     * Instead of printInts, printStrings, printDoubles, ...
     * <p>"One method to rule them all!"
     * <p>Generic method
     */
    private static <E> void print(E[] elems) {
        for (var e : elems) {
            System.out.print(e + " ");
        }
        System.out.println();
    }

    /**
     * Generic method in which a generic type is specified as a subtype of another type.
     * Such a generic type is called <i>bounded</i>.
     */
    private static <T extends Shape> boolean equalArea(T s1, T s2) {
        return s1.area() == s2.area();
    }

    private static void demo1() {
        System.out.println("demo1...");

        Integer[] integers = {1, 2, 3, 4, 5};
        String[] strings = {"Neo", "Trinity", "Morpheus"};

        // To invoke a generic method, prefix the method name with the actual type in angle brackets
        Main.<Integer>print(integers);
        Main.<String>print(strings);
        System.out.println("-----");

        print(integers); // the type of E is inferred
        print(strings); // as above
    }

    private static void demo2() {
        System.out.println("\ndemo2...");
        Rectangle r = new Rectangle(4, 2);
        Circle c = new Circle(4);
        System.out.println("equalArea(r, c) = " + equalArea(r, c));
    }

    private static void demo3() {
        C1 c1 = new C1();
        c1.<Double>m1(3.14);

        C1.<Integer>sm1(10);
        C1.sm1(10);
    }

    private static void demo4() {
        int x = C2.<Integer, String>m1("abc", 2);
        int y = C2.m1("abc", 2);
    }

    private static void demo5() {
        C3<Double> c3 = new C3<>(); // instance variable x : Double
        final String s1 = c3.sm1("abc");
        final Integer i1 = c3.sm1(1);
    }

    public static void main(String[] args) {
        demo1();
        demo2();
        demo3();
        demo4();
        demo5();
    }
}
