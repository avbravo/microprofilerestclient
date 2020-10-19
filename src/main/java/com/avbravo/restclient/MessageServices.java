/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avbravo.restclient;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import org.eclipse.microprofile.rest.client.inject.RestClient;

/**
 *
 * @author avbravo
 */
@Path("/message")
@ApplicationScoped
public class MessageServices {
    
    @Inject
    @RestClient
    MessageClient service;

    @GET
    @Path("/text")
    public String getHello() {
        return service.getHello();
    }


}
