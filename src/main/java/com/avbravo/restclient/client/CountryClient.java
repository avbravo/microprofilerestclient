/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avbravo.restclient.client;

;
import com.avbravo.restclient.domains.Country;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

/**
 *
 * @author avbravo
 */
@RegisterRestClient(baseUri = "http://localhost:8080/microprofilerestclientserver/resources")
@Path("/message")
public interface CountryClient {

    @GET
    @Path("/text")
    public String getHello();

    @GET
    @Path("/first")
    @Produces(MediaType.APPLICATION_JSON)
    public Country first();  

  
    

    @GET
    @Path("/findall")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Country> findAll();

    
    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response add(Country  country );
}
