package com.company.practice.security;

import com.company.practice.entity.CreditPosition;
import io.jmix.core.security.CurrentAuthentication;
import io.jmix.security.model.RowLevelPolicyAction;
import io.jmix.security.model.RowLevelBiPredicate;
import io.jmix.security.model.RowLevelPredicate;
import io.jmix.security.role.annotation.PredicateRowLevelPolicy;
import io.jmix.security.role.annotation.RowLevelRole;
import org.springframework.context.ApplicationContext;


@RowLevelRole(name = "employeeRowLevel", code = "row-level-employee-role")
public interface EmployeeRoleRowLevel {

    @PredicateRowLevelPolicy(
            entityClass = CreditPosition.class,
            actions = { RowLevelPolicyAction.UPDATE})
    default RowLevelBiPredicate<CreditPosition, ApplicationContext> updateMyCreatedCreditPos() {
        return (creditPosition, applicationContext) -> {
            CurrentAuthentication currentAuthentication = applicationContext.getBean(CurrentAuthentication.class);
            return creditPosition.getCreatedBy().equals(currentAuthentication.getUser().getUsername());
        };
    }

    @PredicateRowLevelPolicy(
            entityClass = CreditPosition.class,
            actions = { RowLevelPolicyAction.DELETE})
    default RowLevelBiPredicate<CreditPosition, ApplicationContext> deleteMyCreatedCreditPos() {
        return (creditPosition, applicationContext) -> {
            CurrentAuthentication currentAuthentication = applicationContext.getBean(CurrentAuthentication.class);
            return creditPosition.getCreatedBy().equals(currentAuthentication.getUser().getUsername());
        };
    }

    @PredicateRowLevelPolicy(
            entityClass = CreditPosition.class,
            actions = { RowLevelPolicyAction.CREATE})
    default RowLevelPredicate<CreditPosition> createCreditPosCondition() {
        return creditPosition -> (creditPosition.getCreditSum() <= creditPosition.getCredit().getLimitOfCredit());
    }
}