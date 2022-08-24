package com.company.practice.screen.creditposition;

import io.jmix.ui.screen.*;
import com.company.practice.entity.CreditPosition;

@UiController("CreditPosition.browse")
@UiDescriptor("credit-position-browse.xml")
@LookupComponent("creditPositionsTable")
public class CreditPositionBrowse extends StandardLookup<CreditPosition> {
}