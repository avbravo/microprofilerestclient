/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avbravo.restclient.controller;

import com.avbravo.jmoordbutils.JsfUtil;
import com.avbravo.restclient.services.CountryServices;
import com.avbravo.restclient.domains.Country;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.ws.rs.core.Response;

/**
 *
 * @author avbravo
 */
@Named
@ViewScoped
public class CountryController implements Serializable{
    
    // <editor-fold defaultstate="collapsed" desc=" fields">
    String message="";
    Country country = new Country();
    List<Country> countryList = new ArrayList<>();
            
// </editor-fold>

    
// <editor-fold defaultstate="collapsed" desc="Microprofile Rest Client">
      @Inject
  CountryServices countryServices;
// </editor-fold>
      
          // <editor-fold defaultstate="collapsed" desc=" set/get">

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public List<Country> getCountryList() {
        return countryList;
    }

    public void setCountryList(List<Country> countryList) {
        this.countryList = countryList;
    }
      
    
    
      
// </editor-fold>
  
    /**
     * Creates a new instance of SimpleController
     */
    public CountryController() {
    }
    
    
    
    // <editor-fold defaultstate="collapsed" desc=" init">
    @PostConstruct
    public void init(){
        countryList = countryServices.findAll();
    }
// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="clear()">
    public String clear(){
        message="";
        country = new Country();
        return "";
    }
// </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="String getHello()">

    public String getHello(){
        try {

  message =countryServices.getHello();
 
        } catch (Exception e) {

            JsfUtil.errorDialog("getHello(", e.getLocalizedMessage());
        }
        return "";
    }
    
    // </editor-fold>
    
      // <editor-fold defaultstate="collapsed" desc="String first()">
    public String first(){
        try {

            country =countryServices.first();

        } catch (Exception e) {

            JsfUtil.errorDialog("first()", e.getLocalizedMessage());
        }
        return "";
    }
    // </editor-fold>
    
     
    
      // <editor-fold defaultstate="collapsed" desc="String getCountryXML()">
    public String findAll(){
        try {

           countryList =countryServices.findAll();

        } catch (Exception e) {

            JsfUtil.errorDialog("findAll()", e.getLocalizedMessage());
        }
        return "";
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="save()">
    public String add(){
        Response response =countryServices.add(country);
        if (response.getStatus() == 400) {
            JsfUtil.errorMessage("No se pudo guardar");
        }else{
            JsfUtil.successMessage("Guardado exitosamente");
            
        }
        return "";
    }
// </editor-fold>
    
}
