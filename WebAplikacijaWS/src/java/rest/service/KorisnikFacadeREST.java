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
import model.Korisnik;
import pl.KontrolerZahtevaKorisnika;

/**
 *
 * @author gaga__m
 */

@Path("korisnik")
public class KorisnikFacadeREST {
    
    KontrolerZahtevaKorisnika kontroler;

    public KorisnikFacadeREST() {
         kontroler = new KontrolerZahtevaKorisnika();
    }

    

    @GET
    @Path("/{idkorisnika}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response vratiKorisnika(@PathParam("idkorisnika") BigDecimal idkorisnika) {
       Korisnik r= kontroler.pronadjiKorisnika(idkorisnika.intValue());
        
        if (r != null) {
            KorisnikDTO kor = new KorisnikDTO();
            kor.setIdkorisnika(r.getIdkorisnika());
            kor.setImeprezime(r.getImeprezime());
            kor.setBrpasosa(r.getBrpasosa());
            kor.setJmbg(r.getJmbg());
            kor.setBrtelefona(r.getBrtelefona());
            kor.setDatumrodj(r.getDatumrodj());
            kor.setAdresa(r.getAdresa().toString());
            
            return Response.ok(kor).build();
        }

        return Response.status(Response.Status.NO_CONTENT).build();
    }

    @GET
    @Path("/")
    @Produces({MediaType.APPLICATION_JSON})
    public Response vratiKorisnike() {
        List<Korisnik> listakorisnika = kontroler.ucitajKorisnike();

        if (listakorisnika != null) {
            List<KorisnikDTO> listakorisnikaDTO = new ArrayList<>();

            for (Korisnik r : listakorisnika) {
                KorisnikDTO kor = new KorisnikDTO();
                kor.setIdkorisnika(r.getIdkorisnika());
                kor.setImeprezime(r.getImeprezime());
                kor.setBrpasosa(r.getBrpasosa());
                kor.setJmbg(r.getJmbg());
                kor.setBrtelefona(r.getBrtelefona());
                kor.setDatumrodj(r.getDatumrodj());
                kor.setAdresa(r.getAdresa().toString());
                
                listakorisnikaDTO.add(kor);
            }
             
            GenericEntity<List<KorisnikDTO>> ge = new GenericEntity<List<KorisnikDTO>>(listakorisnikaDTO) {
            };
            
            return Response.ok(ge).build();
        }

        return Response.status(Response.Status.SERVICE_UNAVAILABLE).build();
    }

    
    
}
