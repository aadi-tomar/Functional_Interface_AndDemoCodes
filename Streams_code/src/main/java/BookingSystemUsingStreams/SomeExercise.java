package BookingSystemUsingStreams;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Stream;

public class SomeExercise {

    public static void main(String[] args) {

        Client c1 = new Client();
        LocalDate date = LocalDate.of(2020,5, 2);
        Ticket t1 = new Ticket();
        t1.setDate(date);
        t1.setDestination("Paris");
        Ticket t2 = new Ticket();
        t2.setDestination("Amsterdam");
        t2.setDate(date);
        Ticket t3 = new Ticket();
        t3.setDate(LocalDate.of(2019, 5 , 6));
        t3.setDestination("Paris");


        List<Ticket> ticketList = List.of(t1,t2,t3);


        long count = ticketList.stream()
                .filter(t -> t.getDestination().equals("Paris")).count();
        System.out.println(count);

        ticketList.stream().filter(t -> t.getDate().equals(date)).forEach( d -> System.out.println(d));


    }
}
