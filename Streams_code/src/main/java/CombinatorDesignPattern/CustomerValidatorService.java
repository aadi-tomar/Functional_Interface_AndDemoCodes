package CombinatorDesignPattern;

import java.time.LocalDate;
import java.time.Period;

/*

This class does its work but not a good design pattern
 */
public class CustomerValidatorService {

    private boolean isEmailValid(String email){
        return email.contains("@");
    }

    private boolean isPhoneValid(String phone){
        return phone.startsWith("+91");
    }

    private boolean isAdult(LocalDate dob){
        return Period.between(dob, LocalDate.now()).getYears() >= 18 ;
    }

    public boolean isValid(Customer customer){
        return isEmailValid(customer.getEmail()) && isPhoneValid(customer.getPhoneNumber())
                && isAdult(customer.getDob());
    }
}
