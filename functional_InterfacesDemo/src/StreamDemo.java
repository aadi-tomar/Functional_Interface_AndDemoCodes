import java.util.List;
import java.util.stream.Collectors;

public class StreamDemo {
    public static void main(String[] args) {

        List< Integer> bulkList = List.of(2, 4, 23, 45, 12, 10, 20, 30);

        List< Integer > sortedList = bulkList.stream().filter( x -> x>=10).sorted((p1, p2) -> (p2 - p1)).collect(Collectors.toList());
        List< Integer > squaredNumber = bulkList.stream().map( x -> x*x).sorted().collect(Collectors.toList());
        System.out.println(" Sorted list through Stream is " + sortedList);

        System.out.println(" SquaredNumber through Stream api is "+ squaredNumber);


    }
}
