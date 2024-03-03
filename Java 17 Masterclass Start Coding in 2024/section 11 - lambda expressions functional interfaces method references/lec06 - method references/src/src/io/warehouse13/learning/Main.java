package src.io.warehouse13.learning;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.*;

public class Main {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>(
                List.of("Anna", "Bob", "Charles", "Dana", "Elric"));
        // we can use method reference here
        names.forEach(name -> System.out.println(name));
        // we use method reference here
        names.forEach(System.out::println);
        // we can't use it here
        names.forEach(name -> System.out.println("Name " + name));

        // we can use method reference here: use static method from Integer
        calculator((a, b) -> (a + b), 10, 20);
        calculator(Integer::sum, 10, 20);

        calculator((a, b) -> (a + b), 10.6, 20.2);
        calculator(Double::sum, 10.6, 20.2);

        // constructor reference
        Supplier<PlainOld> reference1a= () -> new PlainOld();
        Supplier<PlainOld> reference1b = PlainOld::new;

        // deferred method invocation
        // why doing so ? we could simply call new PlainOld ...
        PlainOld plainOld1 = reference1a.get();
        PlainOld plainOld2 = reference1b.get();
        System.out.println("*****************");
        System.out.println("Getting array ");
        PlainOld[] plainOlds = seedArray(PlainOld::new, 10);

        System.out.println("*****************");
        // this is not a sum we operate, we concatenate
        calculator((s1, s2) -> s1 + s2, "Hello ", "World");
        calculator((s1, s2) -> s1.concat(s2), "Hello ", "World");
        calculator(String::concat, "Hello ", "World");
        UnaryOperator<String> unaryOperator = s1 -> s1.toUpperCase();
        BinaryOperator<String> binaryOperator = (s1, s2) -> s1.concat(s2);
        BiFunction<String, String, String> biFunction = (s1, s2) -> s1.concat(s2);

        // we can use here method reference...
        UnaryOperator<String> unaryOperatorMethodReference = String::toUpperCase;
        BinaryOperator<String> binaryOperatorMethodReference = String::concat;
        BiFunction<String, String, String> biFunctionMethodReference = String::concat;

        // we can also do apply
        System.out.println("unaryOperator: " + unaryOperator.apply("Hello"));
        System.out.println("binaryOperator: " + binaryOperator.apply("Hello ", "World!"));
        System.out.println("biFunction: " + biFunction.apply("Hello ", "World!"));

        System.out.println("unaryOperatorMethodReference: " + unaryOperatorMethodReference.apply("Hello"));
        System.out.println("binaryOperatorMethodReference: " + binaryOperatorMethodReference.apply("Hello ", "World!"));
        System.out.println("biFunctionMethodReference: " + biFunctionMethodReference.apply("Hello ", "World!"));

        String result = "Hello World";
        System.out.println("Using transform with unary operator   : " + result.transform(unaryOperator));
        System.out.println("Using transform with method reference : " + result.transform(String::toLowerCase));

        Function<String, Boolean> fun = String::isEmpty;
        boolean resultBoolean =  result.transform(fun);
        System.out.println("Result: " + resultBoolean);

    }

    private static <T> void calculator(BinaryOperator<T> function, T value1, T value2) {
        T result = function.apply(value1, value2);
        System.out.println(result);
    }

    private static PlainOld[] seedArray(Supplier<PlainOld> reference, int count) {
        PlainOld[] arr = new PlainOld[count];
        Arrays.setAll(arr, i -> reference.get());
        return arr;
    }
}

class PlainOld {
    private static int lastId = 1;
    private int id;

    public PlainOld() {
        id = PlainOld.lastId++;
        System.out.println("PlainOld constructor with id: " + id);
    }
}