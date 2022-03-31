package agh.ii.prinjava.lab06.lst06_01;

/**
 * A functional interface has exactly one abstract method. Since default methods have an implementation,
 * they are not abstract. If an interface declares an abstract method that overrides one of the public methods
 * of {@link Object}, this also does not count since any implementation of the interface will have
 * an implementation from {@code Object} or elsewhere.
 * <p>Functional interfaces provide target types for / can be created with:
 * <ul>
 *     <li>lambda expressions</li>
 *     <li>method references</li>
 *     <li>constructor references</li>
 * </ul>
 * <i>Note</i>: the only thing that you can do with a lambda expression in Java is to convert it to a functional interface
 * (the lambda expression becomes the implementation of that single abstract method in the functional interface).
 * <p>It is best to think of a lambda expression as a function, not an object, and to accept that it can be passed
 * to a functional interface.
 *
 * <p>Lambda expression limitations:
 * <ul>
 *     <li>if a lambda expression uses a local variable created outside it, this local variable has to be final
 *     or effectively final (not reassigned in the same context)</li>
 *     <li>the {@code this} keyword in a lambda expression refers to the enclosing context,
 *     not the lambda expression itself ("this" inside an anonymous class refers to the instance
 *     of the anonymous class)</li>
 * </ul>
 *
 * <i>Note</i>: Java supports closures over values not closures over variables
 *
 * <p>{@link FunctionalInterface} is not a requirement for the compiler to recognize an interface as a functional
 * interface, but merely an aid to capture design intent and enlist the help of the compiler in identifying accidental
 * violations of design intent.
 *
 * @see <a href="https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/lang/FunctionalInterface.html">FunctionalInterface</a>
 */
@FunctionalInterface
interface Flyable {
    void flyTo(double latitude, double longitude);
}

/**
 * Functional interface is just a specific type of interface, so it can be implemented
 */
class Superman implements Flyable {
    private static final Superman INSTANCE = new Superman();

    private Superman() {
    }

    public static Superman getInstance() {
        return INSTANCE;
    }

    @Override
    public void flyTo(double latitude, double longitude) {
        System.out.println("Superman is flying to (" + latitude + ", " + longitude + ")");
    }
}

public class Main {
    private static void demo1() {
        System.out.println("demo1...");
        Superman.getInstance().flyTo(48.7887337, 2.3637327);
    }

    /**
     * Functional interfaces provide target types for (can be created with) lambda expressions
     */
    private static void demo2() {
        System.out.println("\ndemo2...");
        Flyable f0 = new Flyable() {
            @Override
            public void flyTo(double latitude, double longitude) {
                System.out.println("Flying (with anonymous class) to (" + latitude + ", " + longitude + ")");
            }
        };
        f0.flyTo(10, 20);

        Flyable f1 = (lat, lon) -> System.out.println("Flying (with lambda) to (" + lat + ", " + lon + ")");
        f1.flyTo(10, 20);
    }

    /**
     * Functional interfaces provide target types for (can be created with) method references.
     *
     * <p>A method reference directs the compiler to produce an instance of a functional interface,
     * overriding the single abstract method of the interface to call the given method.
     *
     * <p>Like a lambda expression, a method reference is not an object. It gives rise to an object when assigned
     * to a variable whose type is a functional interface.
     *
     * <p> {@code ::} operator separates the method name from the name of an object or class.
     * There are three variants:
     * <ol>
     *     <li>{@code object::instanceMethod} - the method reference is equivalent to a lambda expression whose parameters
     *     are passed to the method. For instance, in {@code System.out::println}, the object is {@code System.out},
     *     and the method expression is equivalent to {@code x -> System.out.println(x)}</li>
     *
     *     <li>{@code Class::instanceMethod} - the first parameter becomes the implicit parameter of the method.
     *     For instance, {@code String::compareToIgnoreCase} is the same as {@code(x, y) -> x.compareToIgnoreCase(y)}</li>
     *
     *     <li>{@code Class::staticMethod} - all parameters are passed to the static method:
     *     {@code Math::pow} is equivalent to {@code (x, y) -> Math.pow(x, y)}</li>
     * </ol>
     * Method reference examples:
     * <ul>
     *     <li>{@code separator::equals} corresponds to: {@code x -> separator.equals(x)}</li>
     *     <li>{@code String::trim} corresponds to: {@code x -> x.trim()}</li>
     *     <li>{@code String::concat} corresponds to: {@code (x, y) -> x.concat(y)}</li>
     *     <li>{@code Integer.valueOf} corresponds to: {@code x -> Integer.valueOf(x)}</li>
     *     <li>{@code Integer.sum} corresponds to: {@code (x, y) -> Integer.sum(x, y)}</li>
     *     <li>{@code Integer::new} corresponds to: {@code x -> new Integer(x)}</li>
     *     <li>{@code Integer[]::new} corresponds to: {@code n -> new Integer[n]}</li>
     * </ul>
     */
    private static void demo3() {
        System.out.println("\ndemo3...");

        C1 c1 = new C1(1, 2);
//        c1.m2(5);

        I1 i1 = c1::m2;
//        i1.f1(5); // equivalent to c1.m2(5);

        Flyable f1 = c1::m1; // an instance method reference (syntax: objectName::method)
        //Flyable f0 = c1::m2; // m2 does not match to Flyable.flyTo

        c1.m1(45, 7);
        f1.flyTo(45, 7);

        Flyable f2 = C1::sm1; // a static method reference (syntax: className::method)
        f2.flyTo(0, 0);
    }

    /**
     * Functional interfaces provide target types for (can be created with) constructor references
     * <p><i>Note</i>: constructor references are just like method references,
     * except that the name of the method is "{@code new}"
     */
    
    private static void demo4() {
        System.out.println("\ndemo4...");

        IFactory<C1> c1Factory = C1::new; // a constructor reference (syntax: className::new)
//        C1 c11 = new C1(10, 20);
        C1 c12 = c1Factory.create(10, 20);

        IFactory<C2> c2Factory = C2::new;
        C2 c2 = c2Factory.create(1, 2);
    }

    public static void main(String[] args) {
        demo1();
        demo2();
        demo3();
        demo4();
    }
}

/**
 * Auxiliary definitions
 */
class C1 {
    C1(double x, double y) {
        System.out.println("Building C1 with (x = " + x + ", y = " + y + ")...");
    }

    void m1(double x, double y) {
        System.out.println("C1.m1(x=" + x + ", y=" + y + ")");
    }

    void m2(double x) {
        System.out.println("C1.m2(x=" + x + ")");
    }

    static void sm1(double a, double b) {
        System.out.println("C1.sm1(x=" + a + ", b=" + b + ")");
    }
}

class C2 {
    C2(double x, double y) {
        System.out.println("Building C2 with (x = " + x + ", y = " + y + ")...");
    }
}

@FunctionalInterface
interface I1 {
    void f1(double x);
}

@FunctionalInterface
interface IFactory<T> {
    T create(double a, double b);
}

@FunctionalInterface
interface FunIf<T, R>
{
    R apply(T t);
}