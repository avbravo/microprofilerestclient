/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avbravo.restclient;

import com.avbravo.jmoordbutils.JsfUtil;
import java.io.Serializable;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;

/**
 *
 * @author avbravo
 */
@Named(value = "messageController")
@ViewScoped
public class MessageController implements Serializable{

    @Inject
  MessageServices messageServices;
    /**
     * Creates a new instance of SimpleController
     */
    public MessageController() {
    }
    public String load(){
        try {

            String message =messageServices.getHello();
            JsfUtil.infoDialog("message", message);
        } catch (Exception e) {

            JsfUtil.errorDialog("load()", e.getLocalizedMessage());
        }
        return "";
    }
}
