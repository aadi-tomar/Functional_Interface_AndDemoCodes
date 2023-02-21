package CollectorsDemo;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class MapUsingStreams {


    public static void main(String[] args) {
        List < String> stringList = List.of("AAA", "B", "CCC", "DDDDDD", "AAA");

        Map<String, Integer> treeMap = stringList
                .stream()
                .collect(Collectors.toMap(
                        key -> key,                  //key mapper
                        value -> value.length(),     // value mapper
                        (a, b) -> a + b,             // what to do if duplicate key
                        () -> new TreeMap<>()        // collect to TreeMap;
                ));

        System.out.println(treeMap);

    }
}
