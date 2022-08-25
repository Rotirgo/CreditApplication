package com.company.practice.app;

import com.company.practice.entity.User;
import io.jmix.core.DataManager;
import io.jmix.core.security.Authenticated;
import io.jmix.core.security.CurrentAuthentication;
import io.jmix.core.security.SystemAuthenticator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ClientService {

    @Autowired
    private DataManager dataManager;

    @Autowired
    private ApplicationContext applicationContext;

    public User getCurrentUser() {
        CurrentAuthentication currentAuthentication = applicationContext.getBean(CurrentAuthentication.class);
        User user = (User) currentAuthentication.getUser();
        if(user.getClient() == null) return user;
        else return null;
    }
}

