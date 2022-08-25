package com.company.practice.app;


import com.company.practice.entity.CreditPosition;
import io.jmix.ui.component.Button;
import io.jmix.ui.component.TextField;
import io.jmix.ui.component.ValidationException;
import io.jmix.ui.component.validation.DecimalMaxValidator;
import io.jmix.ui.component.validation.DoubleMaxValidator;
import io.jmix.ui.screen.Subscribe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.math.BigDecimal;

@Component("ui_ZipValidator")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class MaxCreditSumValidator implements ConstraintValidator<MaxCreditSumValid, CreditPosition> {

        public void initialize(MaxCreditSumValid constraint) {
        }

        public boolean isValid(CreditPosition creditPosition, ConstraintValidatorContext context) {
                if (creditPosition.getCreditSum() > creditPosition.getCredit().getLimitOfCredit())
                        return false;
                return true;
        }

}
