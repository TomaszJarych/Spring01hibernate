package pl.coderslab.Validator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = IsAdultValidator.class)
@Target({ ElementType.FIELD, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
public @interface IsAdult {

    String message() default "Author have to be an Adult!";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
