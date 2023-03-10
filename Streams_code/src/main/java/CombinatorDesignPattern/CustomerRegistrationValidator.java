package CombinatorDesignPattern;

import java.time.LocalDate;
import java.time.Period;
import java.util.function.Function;

public interface CustomerRegistrationValidator extends Function<Customer, ValidationResult> {


    static CustomerRegistrationValidator isEmailValid(){
        return customer -> customer.getEmail().contains("@") ?
                ValidationResult.SUCCESS : ValidationResult.EMAIL_NOT_VALID;
    }

    static CustomerRegistrationValidator isPhoneValid(){
        return customer -> customer.getPhoneNumber().startsWith("+91") ?
                ValidationResult.SUCCESS : ValidationResult.PHONE_NUMBER_NOT_VALID;
    }

    static CustomerRegistrationValidator isDobValid(){
        return customer -> Period.between(customer.getDob(), LocalDate.now()).getYears() >= 18 ?
                ValidationResult.SUCCESS : ValidationResult.IS_NOT_AN_ADULT;
    }


    default CustomerRegistrationValidator and(CustomerRegistrationValidator o){
        return customer -> {
            ValidationResult result = this.apply(customer);
            return result.equals(ValidationResult.SUCCESS) ? o.apply(customer) : result;

        };
    }
}
