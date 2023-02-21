package CollectorsDemo;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Set;
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

        // it
        String result = stringList
                            .stream()
                            .collect(Collectors.joining());   // it'll join all the input

        System.out.printf(result);

        //join with some prefix and suffix, join the input by comma
        String result1 = stringList.stream().collect(Collectors.joining(",", "[", "]"));
        System.out.println(result1);

        List<?> joiningBothResult = stringList.stream().collect(Collectors.teeing(
                Collectors.counting(),                     // result1
                Collectors.joining(),                       // result2
                (a, b) -> List.of(a, b)                      // how to join both the results
        ));
        System.out.println(joiningBothResult);

        //mapping -> its not same as map
        List<Integer> mapping = stringList.stream().collect(Collectors.mapping(
                s -> s.length(),
                Collectors.toList()));  //downstreaming
        System.out.println(mapping);

        List<Integer> mapAndFilter = stringList.stream().collect(Collectors.mapping(
                s -> s.length(),
                Collectors.filtering(num -> num % 2 == 0, Collectors.toList())));
        System.out.println(mapAndFilter);

        //partitioning the stream

        Map<Boolean, List<String>> partition = stringList.stream()
                .collect(Collectors.partitioningBy(num -> num.length() % 2 == 0));
        System.out.println(partition);

        Map<Boolean, Set<String>> partitionSet = stringList.stream()
                .collect(Collectors.partitioningBy(num -> num.length() % 2 == 0,
                        Collectors.toSet()));  // Collectors.joining. It can be downstreamed again
        System.out.println(partitionSet);
        
        //Grouping By -> it's generalization of partition.

        Map<Integer, List<String>> groupByLength = stringList.stream().collect(Collectors.groupingBy(s -> s.length()));
        System.out.println(groupByLength);

    }
}
