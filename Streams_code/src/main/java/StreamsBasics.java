import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamsBasics {

    public static void main(String[] args) {

        List< String> names = List.of("John", "aadi", "tomar", "aadi", "aaditya", "tomar", "ashu", "John");
        List<Integer> numbers = List.of(1, 2, 3 , 4, 5);
        // groupingBy in streams

        Map<String, Long> map = names.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        //map.forEach((k,v) -> System.out.println(k + " " + v));


        Optional<Object> empty= Optional.empty();
        System.out.println(empty.isPresent());

        Optional<String> hello= Optional.of("hello");
        System.out.println(hello.isEmpty());

        Optional<Object> world= Optional.ofNullable("world");
        System.out.println(hello.isPresent());

        System.out.println(empty.orElse("I'm present"));

        Optional<Object> optional = Optional.
                ofNullable(null);
        System.out.println(optional.isPresent());
        System.out.println(optional.isEmpty());

        String orElse = hello.map(String::toUpperCase)
                .orElseGet(() -> {return "world";}
                );

        hello.ifPresentOrElse(w -> System.out.println(w) , () -> System.out.println("world"));



    }
}
