/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mb;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import model.Destinacija;
import model.Korisnik;
import model.Tipprevoza;
import model.Tipsmestaja;
import pl.KontrolerZahtevaKorisnika;
import prikaz.KorisnikPrikaz;


/**
 *
 * @author gaga__m
 */
@ManagedBean
@ViewScoped

public class UnosZahtevaKorisnikaMB implements Serializable{

    KontrolerZahtevaKorisnika kontroler;
    private int sifraZahteva;
    private int vremeBoravka;
    private int IDDestinacije;
    private int IDTipaPrevoza;
    private int IDTipaSmestaja;
    
    private HashMap<String, Integer> tipoviPrevozaMapa;
    private HashMap<String, Integer> tipoviSmestajaMapa;
    private HashMap<String, Integer> destinacijeMapa;
    
    private KorisnikPrikaz korisnikPrikaz;
    private List<KorisnikPrikaz> korisniciPrikaz;
    
    
    public UnosZahtevaKorisnikaMB() {
        kontroler = new KontrolerZahtevaKorisnika();
    }

    @PostConstruct
    public void popuni() {
        sifraZahteva = kontroler.vratiSifruZahteva();
        tipoviPrevozaMapa = kontroler.ucitajTipovePrevoza();
        tipoviSmestajaMapa = kontroler.ucitajTipoveSmestaja();
        destinacijeMapa = kontroler.ucitajDestinacije(); 
        korisniciPrikaz = kontroler.ucitajKorisnikePrikaz();
        korisnikPrikaz = new KorisnikPrikaz();
    }

    public int getSifraZahteva() {
        return sifraZahteva;
    }

    public void setSifraZahteva(int sifraZahteva) {
        this.sifraZahteva = sifraZahteva;
    }

    public int getVremeBoravka() {
        return vremeBoravka;
    }

    public void setVremeBoravka(int vremeBoravka) {
        this.vremeBoravka = vremeBoravka;
    }

    public int getIDDestinacije() {
        return IDDestinacije;
    }

    public void setIDDestinacije(int IDDestinacije) {
        this.IDDestinacije = IDDestinacije;
    }

    public int getIDTipaPrevoza() {
        return IDTipaPrevoza;
    }

    public void setIDTipaPrevoza(int IDTipaPrevoza) {
        this.IDTipaPrevoza = IDTipaPrevoza;
    }

    public int getIDTipaSmestaja() {
        return IDTipaSmestaja;
    }

    public void setIDTipaSmestaja(int IDTipaSmestaja) {
        this.IDTipaSmestaja = IDTipaSmestaja;
    }


    public HashMap<String, Integer> getTipoviPrevozaMapa() {
        return tipoviPrevozaMapa;
    }

    public void setTipoviPrevozaMapa(HashMap<String, Integer> tipoviPrevozaMapa) {
        this.tipoviPrevozaMapa = tipoviPrevozaMapa;
    }

    public HashMap<String, Integer> getTipoviSmestajaMapa() {
        return tipoviSmestajaMapa;
    }

    public void setTipoviSmestajaMapa(HashMap<String, Integer> tipoviSmestajaMapa) {
        this.tipoviSmestajaMapa = tipoviSmestajaMapa;
    }

    public HashMap<String, Integer> getDestinacijeMapa() {
        return destinacijeMapa;
    }

    public void setDestinacijeMapa(HashMap<String, Integer> destinacijeMapa) {
        this.destinacijeMapa = destinacijeMapa;
    }

   
    public void unesiZahtevKorisnika() {
        System.out.println("Novi zahtev se kreira");
        
        if (IDTipaPrevoza != 0 && IDTipaSmestaja != 0 && IDDestinacije != 0 && vremeBoravka != 0 && korisnikPrikaz != null) {
            
           // boolean uspeh = kontroler.sacuvajZahtev(vremeBoravka, odabraniKorisnik.getIdkorisnika().intValue(), odabraneDestinacije, IDTipaPrevoza, IDTipaSmestaja);
            boolean uspeh = kontroler.sacuvajZahtevRest(sifraZahteva, vremeBoravka, korisnikPrikaz.getIdkorisnika(), IDDestinacije, IDTipaPrevoza, IDTipaSmestaja);

            
            if (uspeh) {
                System.out.println("Uspesan unos.");
                FacesContext fc = FacesContext.getCurrentInstance();
                fc.addMessage(null, new FacesMessage("Uspešan unos", "Zahtev korisnika je uspešno unet."));
                
            } else {
                System.out.println("Neuspesan unos.");
                FacesContext fc = FacesContext.getCurrentInstance();
                fc.addMessage(null, new FacesMessage("Neuspesan unos", "Zahtev korisnika nije unet."));
            }
        } else {

            FacesContext fc = FacesContext.getCurrentInstance();
            fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Neuspesan unos", "Morate popuniti sva polja."));
        }
    }

    
    

    public void resetuj(){
        System.out.println("Resetovanje");
        
        vremeBoravka = 0;
        IDTipaPrevoza = 0;
        IDTipaSmestaja = 0;
        IDDestinacije = 0;
        korisnikPrikaz = new KorisnikPrikaz();
    }
    
    public KorisnikPrikaz getKorisnikPrikaz() {
        return korisnikPrikaz;
    }

    public void setKorisnikPrikaz(KorisnikPrikaz korisnikPrikaz) {
        this.korisnikPrikaz = korisnikPrikaz;
    }

    public List<KorisnikPrikaz> getKorisniciPrikaz() {
        return korisniciPrikaz;
    }

    public void setKorisniciPrikaz(List<KorisnikPrikaz> korisniciPrikaz) {
        this.korisniciPrikaz = korisniciPrikaz;
    }

}
