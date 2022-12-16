import java.util.Date;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class PredicateInterfaceDemo {

    public static void main(String[] args) {

        Predicate<Integer> isTrue = value -> (value >= 10);
        System.out.println("Predicate Its value is " + isTrue.test(12));

        Function< Integer, Integer> returnValue = value -> (value*value);
        Function< Integer, Integer> returnValue2 = val -> (val + val);
        System.out.println("Function Return value is " + returnValue.apply(3));


        System.out.println("Functional " + returnValue.andThen(returnValue2).apply(5));

        Consumer< Integer> consumer = value -> System.out.println("Taking an input and performing operations " + value* value);
        consumer.accept(5);
        consumer.andThen(consumer).accept(6);

        Supplier < Date > supplier = () -> new Date();
        System.out.println(" Current date is " + supplier.get());

    }
}
