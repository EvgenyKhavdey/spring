package gb.spring.lesson4.config;


import gb.spring.lesson4.annotation.Company;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ProducerValidator implements
        ConstraintValidator<Company, String> {

    @Override
    public void initialize(Company producer) {
    }

    @Override
    public boolean isValid(String producer, ConstraintValidatorContext constraintValidatorContext) {
        return producer != null && (producer.equals("мираторг") || producer.equals("микоян") || producer.equals("агрохолдинг"));
    }



}
