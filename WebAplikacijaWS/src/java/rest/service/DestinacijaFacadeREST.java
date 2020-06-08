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
import model.Destinacija;

import pl.KontrolerZahtevaKorisnika;

/**
 *
 * @author gaga__m
 */

@Path("destinacija")
public class DestinacijaFacadeREST {
   
    KontrolerZahtevaKorisnika kontroler;

    public DestinacijaFacadeREST() {
         kontroler = new KontrolerZahtevaKorisnika();
    }

    

    @GET
    @Path("/{iddestinacije}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response vratiDestinaciju(@PathParam("iddestinacije") BigDecimal iddestinacije) {
        Destinacija r= kontroler.pronadjiDestinaciju(iddestinacije.intValue());
        
        if (r != null) {
            DestinacijaDTO des = new DestinacijaDTO();
            des.setIddestinacije(r.getIddestinacije());
            des.setNazivdestinacije(r.getNazivdestinacije());
            
            return Response.ok(des).build();
        }

        return Response.status(Response.Status.NO_CONTENT).build();
    }

    @GET
    @Path("/")
    @Produces({MediaType.APPLICATION_JSON})
    public Response vratiDestinacije() {
        List<Destinacija> destinacije = kontroler.ucitajDestinacijeMany();

        if (destinacije != null) {
            List<DestinacijaDTO> destinacijeDTO = new ArrayList<>();

            for (Destinacija r : destinacije) {
                DestinacijaDTO des = new DestinacijaDTO();
                des.setIddestinacije(r.getIddestinacije());
                des.setNazivdestinacije(r.getNazivdestinacije());
                
                destinacijeDTO.add(des);
            }
             
            GenericEntity<List<DestinacijaDTO>> ge = new GenericEntity<List<DestinacijaDTO>>(destinacijeDTO) {
            };
            
            return Response.ok(ge).build();
        }

        return Response.status(Response.Status.SERVICE_UNAVAILABLE).build();
    }

    
    
}
