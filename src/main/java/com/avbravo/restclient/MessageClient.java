/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avbravo.restclient;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

/**
 *
 * @author avbravo
 */
@RegisterRestClient(baseUri = "http://localhost:8080/microprofilerestclientserver/resources")
@Path("/message")
public interface MessageClient {
	@GET
	@Path("/text")
	public String getHello();

	

}