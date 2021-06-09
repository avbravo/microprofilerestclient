/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avbravo.restclient.services;

import com.avbravo.restclient.client.CountryClient;
import com.avbravo.restclient.domains.Country;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.eclipse.microprofile.rest.client.inject.RestClient;

/**
 *
 * @author avbravo
 */
@Path("/message")
@ApplicationScoped
public class CountryServices {

    @Inject
    @RestClient
    CountryClient service;

    @GET
    @Path("/text")
    public String getHello() {
        return service.getHello();
    }

    @GET
    @Path("/first")
    @Produces(MediaType.APPLICATION_JSON)
    public Country first() {
        return service.first();
    }

    

    @GET
    @Path("/findall")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Country> findAll() {
        return service.findAll();
    }
    
    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response add(Country  country ){
        return service.add(country);
    } 
}
