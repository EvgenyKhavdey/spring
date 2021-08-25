package gb.spring.lesson4.annotation;

import gb.spring.lesson4.config.ProducerValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(
        validatedBy = ProducerValidator.class
)
public @interface Company {
    String message() default "Invalid producer";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
