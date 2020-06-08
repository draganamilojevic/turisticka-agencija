/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import model.Programputovanja;
import model.Stavkaprograma;
import pl.KontrolerProgramaWS;
import pl.KontrolerZahtevaKorisnika;

/**
 *
 * @author gaga__m
 */

@Path("program")
public class ProgramputovanjaFacadeREST {
    @PersistenceContext(unitName = "WebAplikacijaWSPU")
    KontrolerProgramaWS kontroler;
    
   
    public ProgramputovanjaFacadeREST() {
        kontroler = new KontrolerProgramaWS();
    }

   

    @GET
    @Path("/")
    @Produces({MediaType.APPLICATION_JSON})
    public Response vratiPrograme() {
        List<Programputovanja> programi = kontroler.ucitajProgramePutovanja();
        List<ProgramPutovanjaDTO> programiDTO = new ArrayList<>();
        
        for (Programputovanja z : programi) {
            ProgramPutovanjaDTO zah = new ProgramPutovanjaDTO();
            zah.setSifraprograma(z.getSifraprograma());
            zah.setIdpotvrde(z.getIdpotvrde());
            zah.setIznos(z.getIznos());
            zah.setNijeukljucenoucenu(z.getNijeukljucenoucenu());
            zah.setUkljucenoucenu(z.getUkljucenoucenu());
            zah.setRednibrojprograma(z.getRednibrojprograma());
            zah.setStatus(z.getStatus());
            
            
            List<StavkaDTO> listaStavki = new ArrayList<>();
            for (Stavkaprograma s : z.getStavkaprogramaCollection()) {
                StavkaDTO sta = new StavkaDTO();
                sta.setIddana(s.getStavkaprogramaPK().getIddana());
                sta.setSifraprograma(s.getStavkaprogramaPK().getSifraprograma());
                sta.setDatum(s.getDatum());
                sta.setIdmesta(s.getIdmesta());
                sta.setStatus("izmeni");
                sta.setOpisdana(s.getOpisdana());
                sta.setProgramputovanja(s.getProgramputovanja());
                
                listaStavki.add(sta);
            }
            
            zah.setListaStavki(listaStavki);

            programiDTO.add(zah);

        }
        GenericEntity<List<ProgramPutovanjaDTO>> ge = new GenericEntity<List<ProgramPutovanjaDTO>>(programiDTO) {
        };

        if (programi != null) {
            return Response.ok(ge).build();
        }

        return Response.status(Response.Status.NO_CONTENT).build();
    }

    
    
}
