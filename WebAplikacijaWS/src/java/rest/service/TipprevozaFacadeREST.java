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
import model.Tipprevoza;

import pl.KontrolerZahtevaKorisnika;

/**
 *
 * @author gaga__m
 */

@Path("tipprevoza")
public class TipprevozaFacadeREST {
    
    KontrolerZahtevaKorisnika kontroler;

    public TipprevozaFacadeREST() {
        kontroler = new KontrolerZahtevaKorisnika();
    }

    

    @GET
    @Path("/{idtipaprevoza}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response vratiTipPrevoza(@PathParam("idtipaprevoza") BigDecimal idtipaprevoza) {
        Tipprevoza r= kontroler.pronadjiTipPrevoza(idtipaprevoza.intValue());
        
        if (r != null) {
            TipPrevozaDTO tip = new TipPrevozaDTO();
            tip.setIdtipaprevoza(r.getIdtipaprevoza());
            tip.setNazivtipaprevoza(r.getNazivtipaprevoza());
            
            return Response.ok(tip).build();
        }

        return Response.status(Response.Status.NO_CONTENT).build();
    }

    @GET
    @Path("/")
    @Produces({MediaType.APPLICATION_JSON})
    public Response vratiTipovePrevoza() {
        List<Tipprevoza> tipoviPrevoza = kontroler.ucitajTipovePrevoza();

        if (tipoviPrevoza != null) {
            List<TipPrevozaDTO> tipoviPrevozaDTO = new ArrayList<>();

            for (Tipprevoza r : tipoviPrevoza) {
                TipPrevozaDTO tip = new TipPrevozaDTO();
                tip.setIdtipaprevoza(r.getIdtipaprevoza());
                tip.setNazivtipaprevoza(r.getNazivtipaprevoza());
                
                tipoviPrevozaDTO.add(tip);
            }
             
            GenericEntity<List<TipPrevozaDTO>> ge = new GenericEntity<List<TipPrevozaDTO>>(tipoviPrevozaDTO) {
            };
            
            return Response.ok(ge).build();
        }

        return Response.status(Response.Status.SERVICE_UNAVAILABLE).build();
    }

    

    
    
}
