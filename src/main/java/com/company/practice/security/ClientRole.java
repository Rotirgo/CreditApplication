package com.company.practice.security;

import com.company.practice.entity.CreditPosition;
import io.jmix.security.model.EntityAttributePolicyAction;
import io.jmix.security.model.EntityPolicyAction;
import io.jmix.security.role.annotation.EntityAttributePolicy;
import io.jmix.security.role.annotation.EntityPolicy;
import io.jmix.security.role.annotation.ResourceRole;
import io.jmix.securityui.role.UiMinimalRole;
import io.jmix.securityui.role.annotation.MenuPolicy;
import io.jmix.securityui.role.annotation.ScreenPolicy;

@ResourceRole(name = "client", code = "client-role")
public interface ClientRole extends UiMinimalRole {


    @EntityPolicy(
            entityClass = CreditPosition.class,
            actions = EntityPolicyAction.READ)
    @EntityAttributePolicy(
            entityClass = CreditPosition.class,
            attributes = {"creditSum", "period", "credit", "client"},
            action = EntityAttributePolicyAction.VIEW)
    @ScreenPolicy(
            screenIds = {"CreditPosition.browse", "CreditPosition.edit"})
    @MenuPolicy(
            menuIds = {"CreditPosition.browse"})
    void creditPosition();

    @MenuPolicy(
            menuIds = {"application"})
    void commonMenus();
}