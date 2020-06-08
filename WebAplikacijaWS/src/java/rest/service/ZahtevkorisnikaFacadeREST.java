/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest.service;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.List;
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

import model.Zahtevkorisnika;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import pl.KontrolerZahtevaKorisnika;

/**
 *
 * @author gaga__m
 */
@Path("zahtevkorisnika")
public class ZahtevkorisnikaFacadeREST {

    KontrolerZahtevaKorisnika kontroler;

    public ZahtevkorisnikaFacadeREST() {
        kontroler = new KontrolerZahtevaKorisnika();
    }

    @POST
    @Path("/")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public Response sacuvajZahtev(String r) {
        try {
            JSONObject json = (JSONObject) new JSONParser().parse(r);
            System.out.println(json.toJSONString());

            //int sifrazahteva = ((Long) json.get("sifrazahteva")).intValue();
            int vremeBoravka = ((Long) json.get("vremeboravka")).intValue();
            System.out.println("Vreme boravka: "+vremeBoravka);
            int idkorisnika = ((Long) json.get("idkorisnika")).intValue();
            //int idtipaprevoza = Integer.parseInt((String) json.get("idtipaprevoza"));
            int idtipaprevoza =  ((Long) json.get("idtipaprevoza")).intValue();
            //int idtipasmestaja = Integer.parseInt((String) json.get("idtipasmestaja"));
            int idtipasmestaja =  ((Long) json.get("idtipasmestaja")).intValue();
            //int iddestinacije = Integer.parseInt((String) json.get("iddestinacije"));
            int iddestinacije = ((Long) json.get("iddestinacije")).intValue();
            
            //boolean uspesno = kontroler.sacuvajZahtev(sifrazahteva, vremeBoravka, idkorisnika, iddestinacije, idtipaprevoza, idtipasmestaja);
            boolean uspesno = kontroler.sacuvajZahtev( vremeBoravka, idkorisnika, iddestinacije, idtipaprevoza, idtipasmestaja);
            
            int sifra = kontroler.vratiMaxID();
            Zahtevkorisnika zk = kontroler.pronadjiZahtev(sifra);

            if (zk != null) {
                System.out.println("Uslo u zk != null");
                ZahtevKorisnikaDTO zahtev = new ZahtevKorisnikaDTO();
                zahtev.setSifraZahteva(zk.getSifrazahteva());
                zahtev.setVremeboravka(zk.getVremeboravka());

                KorisnikDTO k = new KorisnikDTO();
                k.setIdkorisnika(zk.getIdkorisnika().getIdkorisnika());
                k.setJmbg(zk.getIdkorisnika().getJmbg());
                k.setBrpasosa(zk.getIdkorisnika().getBrpasosa());
                k.setBrtelefona(zk.getIdkorisnika().getBrtelefona());
                k.setDatumrodj(zk.getIdkorisnika().getDatumrodj());
                k.setImeprezime(zk.getIdkorisnika().getImeprezime());
                zahtev.setIdkorisnika(k);

                TipPrevozaDTO tp = new TipPrevozaDTO();
                tp.setIdtipaprevoza(zk.getIdtipaprevoza().getIdtipaprevoza());
                tp.setNazivtipaprevoza(zk.getIdtipaprevoza().getNazivtipaprevoza());
                zahtev.setIdtipaprevoza(tp);

                TipSmestajaDTO ts = new TipSmestajaDTO();
                ts.setIdtipasmestaja(zk.getIdtipasmestaja().getIdtipasmestaja());
                ts.setNazivtipasmestaja(zk.getIdtipasmestaja().getNazivtipasmestaja());
                zahtev.setIdtipasmestaja(ts);
                
                DestinacijaDTO de = new DestinacijaDTO();
                de.setIddestinacije(zk.getIddestinacije().getIddestinacije());
                de.setNazivdestinacije(zk.getIddestinacije().getNazivdestinacije());
                zahtev.setIddestinacije(de);
                
                return Response.ok(zahtev).build();
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return Response.status(Response.Status.BAD_REQUEST).build();
    }

    @PUT
    @Path("/{sifraZahteva}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public Response izmeniZahtev(@PathParam("sifraZahteva") BigDecimal sifraZahteva, String zah) {
        try {
            JSONObject json = (JSONObject) new JSONParser().parse(zah);

            int vremeBoravka = ((Long) json.get("vremeboravka")).intValue();
            int idkorisnika = ((Long) json.get("idkorisnika")).intValue();
            
            int idtipaprevoza =  ((Long) json.get("idtipaprevoza")).intValue();
            //int idtipasmestaja = Integer.valueOf((String) json.get("idtipasmestaja"));
            int idtipasmestaja =  ((Long) json.get("idtipasmestaja")).intValue();
            //int iddestinacije = Integer.valueOf((String) json.get("iddestinacije"));
            int iddestinacije = ((Long) json.get("iddestinacije")).intValue();
            
            boolean uspesno = kontroler.izmeniZahtev(sifraZahteva.intValue(), vremeBoravka, idkorisnika, iddestinacije, idtipaprevoza, idtipasmestaja);

            
            
            Zahtevkorisnika zk = kontroler.pronadjiZahtev(sifraZahteva.intValue());

            if (zk != null) {
                System.out.println("Uslo u zk != null");
                ZahtevKorisnikaDTO zahtev = new ZahtevKorisnikaDTO();
                zahtev.setSifraZahteva(zk.getSifrazahteva());
                zahtev.setVremeboravka(zk.getVremeboravka());

                KorisnikDTO k = new KorisnikDTO();
                k.setIdkorisnika(zk.getIdkorisnika().getIdkorisnika());
                k.setJmbg(zk.getIdkorisnika().getJmbg());
                k.setBrpasosa(zk.getIdkorisnika().getBrpasosa());
                k.setBrtelefona(zk.getIdkorisnika().getBrtelefona());
                k.setDatumrodj(zk.getIdkorisnika().getDatumrodj());
                k.setImeprezime(zk.getIdkorisnika().getImeprezime());
                zahtev.setIdkorisnika(k);

                TipPrevozaDTO tp = new TipPrevozaDTO();
                tp.setIdtipaprevoza(zk.getIdtipaprevoza().getIdtipaprevoza());
                tp.setNazivtipaprevoza(zk.getIdtipaprevoza().getNazivtipaprevoza());
                zahtev.setIdtipaprevoza(tp);

                TipSmestajaDTO ts = new TipSmestajaDTO();
                ts.setIdtipasmestaja(zk.getIdtipasmestaja().getIdtipasmestaja());
                ts.setNazivtipasmestaja(zk.getIdtipasmestaja().getNazivtipasmestaja());
                zahtev.setIdtipasmestaja(ts);
                
                DestinacijaDTO de = new DestinacijaDTO();
                de.setIddestinacije(zk.getIddestinacije().getIddestinacije());
                de.setNazivdestinacije(zk.getIddestinacije().getNazivdestinacije());
                zahtev.setIddestinacije(de);
                
                return Response.ok(zahtev).build();
            }
            

        } catch (Exception e) {
            e.printStackTrace();
        }

        return Response.status(Response.Status.BAD_REQUEST).build();
    }

    @DELETE
    @Path("/{sifraZahteva}")
    public Response obrisiZahtev(@PathParam("sifraZahteva") BigDecimal sifraZahteva) {
        boolean uspesno = kontroler.obrisiZahtev(sifraZahteva);

        if (uspesno) {
            return Response.ok().build();
        }

        return Response.status(Response.Status.BAD_REQUEST).build();
    }

    @GET
    @Path("/{sifrazahteva}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response vratiZahtev(@PathParam("sifrazahteva") BigDecimal sifrazahteva) {
        Zahtevkorisnika zk = kontroler.pronadjiZahtev(sifrazahteva.intValue());
        if (zk != null) {
            ZahtevKorisnikaDTO zahtev = new ZahtevKorisnikaDTO();
            zahtev.setSifraZahteva(zk.getSifrazahteva());
            zahtev.setVremeboravka(zk.getVremeboravka());

            KorisnikDTO k = new KorisnikDTO();
            k.setIdkorisnika(zk.getIdkorisnika().getIdkorisnika());
            k.setJmbg(zk.getIdkorisnika().getJmbg());
            k.setBrpasosa(zk.getIdkorisnika().getBrpasosa());
            k.setBrtelefona(zk.getIdkorisnika().getBrtelefona());
            k.setDatumrodj(zk.getIdkorisnika().getDatumrodj());
            k.setImeprezime(zk.getIdkorisnika().getImeprezime());
            zahtev.setIdkorisnika(k);

            TipPrevozaDTO tp = new TipPrevozaDTO();
            tp.setIdtipaprevoza(zk.getIdtipaprevoza().getIdtipaprevoza());
            tp.setNazivtipaprevoza(zk.getIdtipaprevoza().getNazivtipaprevoza());
            zahtev.setIdtipaprevoza(tp);

            TipSmestajaDTO ts = new TipSmestajaDTO();
            ts.setIdtipasmestaja(zk.getIdtipasmestaja().getIdtipasmestaja());
            ts.setNazivtipasmestaja(zk.getIdtipasmestaja().getNazivtipasmestaja());
            zahtev.setIdtipasmestaja(ts);

            DestinacijaDTO d = new DestinacijaDTO();
            d.setIddestinacije(zk.getIddestinacije().getIddestinacije());
            d.setNazivdestinacije(zk.getIddestinacije().getNazivdestinacije());
            zahtev.setIddestinacije(d);
            
            return Response.ok(zahtev).build();
        }
        return Response.status(Response.Status.NO_CONTENT).build();
    }

    @GET
    @Path("/")
    @Produces({MediaType.APPLICATION_JSON})
    public Response vratiZahteve() {
        List<Zahtevkorisnika> zahtevi = kontroler.ucitajZahteve();

        if (zahtevi != null) {
            List<ZahtevKorisnikaDTO> zahteviDTO = new ArrayList<>();

            for (Zahtevkorisnika zk : zahtevi) {
                ZahtevKorisnikaDTO zahtev = new ZahtevKorisnikaDTO();
                zahtev.setSifraZahteva(zk.getSifrazahteva());
                zahtev.setVremeboravka(zk.getVremeboravka());

                KorisnikDTO k = new KorisnikDTO();
                k.setIdkorisnika(zk.getIdkorisnika().getIdkorisnika());
                k.setJmbg(zk.getIdkorisnika().getJmbg());
                k.setBrpasosa(zk.getIdkorisnika().getBrpasosa());
                k.setBrtelefona(zk.getIdkorisnika().getBrtelefona());
                k.setDatumrodj(zk.getIdkorisnika().getDatumrodj());
                k.setImeprezime(zk.getIdkorisnika().getImeprezime());
                zahtev.setIdkorisnika(k);

                TipPrevozaDTO tp = new TipPrevozaDTO();
                tp.setIdtipaprevoza(zk.getIdtipaprevoza().getIdtipaprevoza());
                tp.setNazivtipaprevoza(zk.getIdtipaprevoza().getNazivtipaprevoza());
                zahtev.setIdtipaprevoza(tp);

                TipSmestajaDTO ts = new TipSmestajaDTO();
                ts.setIdtipasmestaja(zk.getIdtipasmestaja().getIdtipasmestaja());
                ts.setNazivtipasmestaja(zk.getIdtipasmestaja().getNazivtipasmestaja());
                zahtev.setIdtipasmestaja(ts);

                DestinacijaDTO d = new DestinacijaDTO();
                d.setIddestinacije(zk.getIddestinacije().getIddestinacije());
                d.setNazivdestinacije(zk.getIddestinacije().getNazivdestinacije());
                zahtev.setIddestinacije(d);
                
                zahteviDTO.add(zahtev);
            }

            GenericEntity<List<ZahtevKorisnikaDTO>> ge = new GenericEntity<List<ZahtevKorisnikaDTO>>(zahteviDTO) {
            };

            return Response.ok(ge).build();
        }
        return Response.status(Response.Status.SERVICE_UNAVAILABLE).build();

    }

}
