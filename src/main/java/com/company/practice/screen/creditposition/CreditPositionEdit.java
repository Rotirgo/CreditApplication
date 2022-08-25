package com.company.practice.screen.creditposition;

import io.jmix.ui.component.Button;
import io.jmix.ui.component.TextField;
import io.jmix.ui.component.validation.DoubleMaxValidator;
import io.jmix.ui.screen.*;
import com.company.practice.entity.CreditPosition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

@UiController("CreditPosition.edit")
@UiDescriptor("credit-position-edit.xml")
@EditedEntityContainer("creditPositionDc")
public class CreditPositionEdit extends StandardEditor<CreditPosition> {

}