package com.company.practice.screen.creditposition;

import io.jmix.ui.screen.*;
import com.company.practice.entity.CreditPosition;

@UiController("CreditPosition.edit")
@UiDescriptor("credit-position-edit.xml")
@EditedEntityContainer("creditPositionDc")
public class CreditPositionEdit extends StandardEditor<CreditPosition> {
}