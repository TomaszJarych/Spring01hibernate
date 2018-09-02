package pl.coderslab.Validator;

import java.time.LocalDateTime;
import java.util.Objects;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class IsAdultValidator implements ConstraintValidator<IsAdult, Integer> {

    @Override
    public void initialize(IsAdult constraintAnnotation) {
    }

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
	Integer now = LocalDateTime.now().getYear();
	if (Objects.isNull(value)) {
	    return false;
	}
	return now - value >= 18;
    }

}
