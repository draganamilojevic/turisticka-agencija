/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest.service;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;

import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import model.Tipsmestaja;
import pl.KontrolerZahtevaKorisnika;

/**
 *
 * @author gaga__m
 */

@Path("tipsmestaja")
public class TipsmestajaFacadeREST {
   
    KontrolerZahtevaKorisnika kontroler;

    public TipsmestajaFacadeREST() {
        kontroler = new KontrolerZahtevaKorisnika();
    }

    @GET
    @Path("/")
    @Produces({MediaType.APPLICATION_JSON})
    public Response vratiTipoveSmestaja() {
        
        List<Tipsmestaja> tipoviSmestaja = kontroler.ucitajTipoveSmestaja();

        if (tipoviSmestaja != null) {
            List<TipSmestajaDTO> tipoviSmestajaDTO = new ArrayList<>();

            for (Tipsmestaja r : tipoviSmestaja) {
                TipSmestajaDTO tip = new TipSmestajaDTO();
                tip.setIdtipasmestaja(r.getIdtipasmestaja());
                tip.setNazivtipasmestaja(r.getNazivtipasmestaja());
                
                tipoviSmestajaDTO.add(tip);
            }
             
            GenericEntity<List<TipSmestajaDTO>> ge = new GenericEntity<List<TipSmestajaDTO>>(tipoviSmestajaDTO) {
            };
            
            return Response.ok(ge).build();
        }

        return Response.status(Response.Status.SERVICE_UNAVAILABLE).build();
    }

    @GET
    @Path("/{idtipasmestaja}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response vratiTipSmestaja(@PathParam("idtipasmestaja") BigDecimal idtipasmestaja) {
        Tipsmestaja r= kontroler.pronadjiTipSmestaja(idtipasmestaja.intValue());
        
        if (r != null) {
            TipSmestajaDTO tip = new TipSmestajaDTO();
            tip.setIdtipasmestaja(r.getIdtipasmestaja());
            tip.setNazivtipasmestaja(r.getNazivtipasmestaja());
            
            return Response.ok(tip).build();
        }

        return Response.status(Response.Status.NO_CONTENT).build();
    }

    

    

    
    
}
