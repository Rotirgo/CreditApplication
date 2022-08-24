package com.company.practice.security;

import com.company.practice.entity.Client;
import com.company.practice.entity.Credit;
import com.company.practice.entity.CreditPosition;
import com.company.practice.entity.User;
import io.jmix.core.security.CurrentAuthentication;
import io.jmix.security.model.EntityAttributePolicyAction;
import io.jmix.security.model.EntityPolicyAction;
import io.jmix.security.role.annotation.EntityAttributePolicy;
import io.jmix.security.role.annotation.EntityPolicy;
import io.jmix.security.role.annotation.ResourceRole;
import io.jmix.securityui.role.UiMinimalRole;
import io.jmix.securityui.role.annotation.MenuPolicy;
import io.jmix.securityui.role.annotation.ScreenPolicy;
import org.springframework.context.ApplicationContext;
import org.springframework.security.core.userdetails.UserDetails;

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

//    @EntityPolicy(
//            entityClass = Credit.class,
//            actions = EntityPolicyAction.READ)
//    @EntityAttributePolicy(
//            entityClass = Credit.class,
//            attributes = {"limitOfCredit", "percent"},
//            action = EntityAttributePolicyAction.VIEW)
//    @ScreenPolicy(
//            screenIds = {"Credit.browse", "Credit.edit"})
//    @MenuPolicy(
//            menuIds = {"Credit.browse"})
//    void credit();
//
//    @EntityPolicy(
//            entityClass = Client.class,
//            actions = {EntityPolicyAction.READ,
//                    EntityPolicyAction.UPDATE,
//                    EntityPolicyAction.CREATE})
//    @EntityAttributePolicy(
//            entityClass = Client.class,
//            attributes = {"fullName", "user","phoneNumber", "mail", "passportNumber"},
//            action = EntityAttributePolicyAction.MODIFY)
//    @EntityAttributePolicy(
//            entityClass = Client.class,
//            attributes = {"creditInfo"},
//            action = EntityAttributePolicyAction.VIEW)
//    @ScreenPolicy(
//            screenIds = {"Client.browse", "Client.edit"})
//    @MenuPolicy(
//            menuIds = {"Client.browse"})
//    void client();
//
//    @EntityPolicy(
//            entityClass = User.class,
//            actions = {EntityPolicyAction.READ})
//    @EntityAttributePolicy(
//            entityClass = User.class,
//            attributes = "*",
//            action = EntityAttributePolicyAction.VIEW)
//    @ScreenPolicy(
//            screenIds = {"User.browse", "User.edit"})
//    @MenuPolicy(
//            menuIds = {"User.browse"})
    void user();


    @MenuPolicy(
            menuIds = {"application"})
    void commonMenus();
}