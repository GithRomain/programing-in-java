package agh.ii.prinjava.lab04.lst04_02;

/**
 * <p>A <i>generic type</i> is a generic class or interface that is parameterised over types.
 * A generic type can be considered as a <i>type constructor</i> (vs. data/instance constructor).
 *
 * <p>A <i>generic class</i> is a class that declares one or more type variables
 * <p>A <i>generic method</i> is a method that declares one or more type variables
 *
 * <p><i>Generic programming</i> - programming in terms of a generic type instead of a specific type.
 *
 * <p><i>Parametric polymorphism</i> - parts of the program (methods and/or classes/interfaces)
 * can be parameterised by types.
 *
 * <p>A type is <i>(parametrically) polymorphic</i> if its declaration contains
 * at least one <i>type parameter/variable</i>.
 *
 * <p><i>Type parameter</i> (e.g., the "T" in {@code GenClass<T>}) vs.
 * <i>type argument</i> (e.g., {@code Double} in {@code GenClass<Double> r;})
 *
 * <p>A generic type is compiled into a <i>raw type</i> (type erasure) - at the bytecode level,
 * code that does not use generics looks just like code that does.
 *
 * <p>Semantically, Java generics are defined by erasure, whereas C++ templates are defined by expansion.
 * In C++ templates, each instance of a template for a new type is compiled separately.
 *
 * <p><i>Cast-iron guarantee</i>: the implicit casts added by the compilation of generics never fail
 *
 * <p>-----</p>
 * <p> Note: type variable "T" is ONLY for instance-related members (i.e. NOT for static members)
 * <p> Reason: type erasure (a static member is only one per class -> there is only one GenBox)<br>
 * <pre>{@code
 *  GenBox<Double> bd1 = new GenBox<Double>(1);
 *  GenBox<Double> bd2 = new GenBox<>(1); // <- inference: T ~ Double
 *  var bd2 = new GenBox<Double>(1);
 *  }</pre>
 * </p>
 *
 * @param <T> the type of the element stored in the box
 * @see <a href="https://docs.oracle.com/javase/tutorial/extra/generics/index.html">Java Generics</a>
 */
class GenBox<T> {
    private T x;

    public GenBox() {
    }

    public GenBox(T x) {
        this.x = x;
    }

    public T getX() {
        return x;
    }

    public void setX(T x) {
        this.x = x;
    }

    @Override
    public String toString() {
        return "GenBox{" + "x=" + x + '}';
    }
}

public class Main {
    /**
     * Generics enable you to detect errors at compile time rather than at runtime.
     */
    private static void demo1() {
        System.out.println("demo1...");

        GenBox<Integer> bi1 = new GenBox<Integer>(1); // Autoboxing
        int x = bi1.getX(); // No casting needed (it's added by the compiler)
        System.out.println("x from bi1 = " + x);

        // Explicit type argument Integer can be replaced with <> (the "diamond operator")
        GenBox<Integer> bi2 = new GenBox<>(2);

        x = bi2.getX();
        System.out.println("x from bi2 = " + x);

        var bi3 = new GenBox<>(3); // the type is inferred from the argument type (3 -> Integer)
        x = bi3.getX();
        System.out.println("x from bi3 = " + x);

        var bi4 = new GenBox<>();
        // Not enough information to infer any other type than Object
        //x = (int) bi4.getX();// <- Required type: int. Provided: Object
        // cast is needed, but then NullPointerException:
        // - cannot invoke "java.lang.Integer.intValue()" because the return value of "GenBox.getX()" is null

        GenBox<Integer> bi5 = new agh.ii.prinjava.lab04.lst04_02.GenBox<Integer>();
        bi5.setX(1);
        x = bi5.getX();
        System.out.println("x from bi5 = " + x);

        var bi6 = new GenBox<>();
        bi6.setX(1);
        //x = bi6.getX(); // <- Required type: int. Provided: Object
        x = (int) bi6.getX();
        System.out.println("bi6.x = " + x);
    }

    /**
     * NEVER USE <i>RAW</i> types as were used before Java 5!
     * <p>Warning: Main.java uses unchecked or unsafe operations
     *
     * <p>A <i>raw type</i> - a generic class or interface used without specifying a concrete type
     * (this enables backward compatibility with earlier versions of Java, i.e., pre-Java5).
     */
    private static void demo2() {
        System.out.println("demo2...");

        // Never use raw types!!!
//        GenBox b1 = new GenBox(1); // raw type, compiles, but... (T ~ Object)
//        //int x = b1.getX(); // <- Required type: int. Provided: Object
//        b1.setX("abc");
//        b1.setX(new GenBox(true));
//        var x = b1.getX();
//        System.out.println(x);

        GenBox<Integer> gb2 = new GenBox<>(1);
//        gb2.setX("abc");
//        gb2.setX(new GenBox(true));

        /*
         * String y = (String) b1.getX(); // <- ClassCastException
         * System.out.println("y (as String) from b1 = " + y);
         */
//        String y = b1.getX().toString();
//        System.out.println("y from getX().toString() = " + y);
    }

    public static void main(String[] args) {
        demo1();
        demo2();
    }
}
