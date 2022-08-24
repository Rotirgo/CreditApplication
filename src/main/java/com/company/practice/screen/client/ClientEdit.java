package com.company.practice.screen.client;

import com.company.practice.app.ClientService;
import io.jmix.ui.screen.*;
import com.company.practice.entity.Client;
import org.springframework.beans.factory.annotation.Autowired;

@UiController("Client.edit")
@UiDescriptor("client-edit.xml")
@EditedEntityContainer("clientDc")
public class ClientEdit extends StandardEditor<Client> {

    @Autowired
    private ClientService clientService;

    @Subscribe
    public void onInitEntity(InitEntityEvent<Client> event) {
        event.getEntity().setUser(clientService.getCurrentUser());
    }


    
    
}