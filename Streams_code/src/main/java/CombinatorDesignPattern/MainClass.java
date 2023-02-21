package CombinatorDesignPattern;

import java.time.LocalDate;

public class MainClass {

    public static void main(String[] args) {
        Customer customer = new Customer("aadi", "aadi@gmail.com","+91928749723" ,
                LocalDate.of(2000, 01, 02));


        System.out.println(new CustomerValidatorService().isValid(customer)); // basic method


        //Using combinator Pattern
        ValidationResult result = CustomerRegistrationValidator.isEmailValid()
                .and(CustomerRegistrationValidator.isPhoneValid())
                .and(CustomerRegistrationValidator.isDobValid()).apply(customer);

        System.out.println(result);


    }
}
