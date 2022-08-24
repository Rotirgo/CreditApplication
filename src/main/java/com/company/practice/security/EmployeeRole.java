package com.company.practice.security;

import com.company.practice.entity.Client;
import com.company.practice.entity.Credit;
import com.company.practice.entity.CreditPosition;
import com.company.practice.entity.User;
import io.jmix.core.security.CurrentAuthentication;
import io.jmix.core.security.SystemAuthenticator;
import io.jmix.security.model.EntityAttributePolicyAction;
import io.jmix.security.model.EntityPolicyAction;
import io.jmix.security.model.RowLevelBiPredicate;
import io.jmix.security.model.RowLevelPolicyAction;
import io.jmix.security.role.annotation.EntityAttributePolicy;
import io.jmix.security.role.annotation.EntityPolicy;
import io.jmix.security.role.annotation.ResourceRole;
import io.jmix.securityui.role.UiMinimalRole;
import io.jmix.securityui.role.annotation.MenuPolicy;
import io.jmix.securityui.role.annotation.ScreenPolicy;
import org.springframework.context.ApplicationContext;

@ResourceRole(name = "employee", code = "employee-role")
public interface EmployeeRole extends UiMinimalRole {

    @EntityPolicy(
            entityClass = CreditPosition.class,
            actions = {EntityPolicyAction.READ,
                    EntityPolicyAction.CREATE,
                    EntityPolicyAction.UPDATE,
                    EntityPolicyAction.DELETE})
    @EntityAttributePolicy(
            entityClass = CreditPosition.class,
            attributes = "*",
            action = EntityAttributePolicyAction.MODIFY)
    @ScreenPolicy(
            screenIds = {"CreditPosition.browse", "CreditPosition.edit"})
    @MenuPolicy(
            menuIds = {"CreditPosition.browse"})
    void creditPosition();

    @EntityPolicy(
            entityClass = Credit.class,
            actions = EntityPolicyAction.ALL)
    @EntityAttributePolicy(
            entityClass = Credit.class,
            attributes = "*",
            action = EntityAttributePolicyAction.MODIFY)
    @ScreenPolicy(
            screenIds = {"Credit.browse", "Credit.edit"})
    @MenuPolicy(
            menuIds = {"Credit.browse"})
    void credit();

    @EntityPolicy(
            entityClass = Client.class,
            actions = EntityPolicyAction.ALL)
    @EntityAttributePolicy(
            entityClass = Client.class,
            attributes = "*",
            action = EntityAttributePolicyAction.MODIFY)
    @ScreenPolicy(
            screenIds = {"Client.browse", "Client.edit"})
    @MenuPolicy(
            menuIds = {"Client.browse"})
    void client();

    @EntityPolicy(
            entityClass = User.class,
            actions = {EntityPolicyAction.READ})
    @EntityAttributePolicy(
            entityClass = User.class,
            attributes = "*",
            action = EntityAttributePolicyAction.VIEW)
    @ScreenPolicy(
            screenIds = {"User.browse"}) //, "User.edit"})
//    @MenuPolicy(
//            menuIds = {"User.browse"})
//    void user();

    @MenuPolicy(
            menuIds = {"application"})
    void commonMenus();
}