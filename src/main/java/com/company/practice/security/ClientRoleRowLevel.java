package com.company.practice.security;

import com.company.practice.entity.Client;
import com.company.practice.entity.CreditPosition;
import io.jmix.core.security.CurrentAuthentication;
import io.jmix.security.model.RowLevelBiPredicate;
import io.jmix.security.model.RowLevelPolicyAction;
import io.jmix.security.role.annotation.PredicateRowLevelPolicy;
import io.jmix.security.role.annotation.RowLevelRole;
import org.springframework.context.ApplicationContext;

@RowLevelRole(name = "clientRowLevel", code = "row-level-client-role")
public interface ClientRoleRowLevel {

    @PredicateRowLevelPolicy(
            entityClass = CreditPosition.class,
            actions = { RowLevelPolicyAction.READ})
    default RowLevelBiPredicate<CreditPosition, ApplicationContext> readMyCreditPos() {
        return (creditPosition, applicationContext) -> {
            CurrentAuthentication currentAuthentication = applicationContext.getBean(CurrentAuthentication.class);
            return creditPosition.getClient().getUser().equals(currentAuthentication.getUser());
        };
    }

    @PredicateRowLevelPolicy(
            entityClass = Client.class,
            actions = { RowLevelPolicyAction.READ})
    default RowLevelBiPredicate<Client, ApplicationContext> readMyClientOnly() {
        return (client, applicationContext) -> {
            CurrentAuthentication currentAuthentication = applicationContext.getBean(CurrentAuthentication.class);
            return client.getUser().equals(currentAuthentication.getUser());
        };
    }
}