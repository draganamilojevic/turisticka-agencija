/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mb;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import pl.KontrolerZahtevaKorisnika;
import prikaz.KorisnikPrikaz;
import prikaz.ZahtevKorisnikaPrikaz;


/**
 *
 * @author gaga__m
 */
@ManagedBean
@ViewScoped
public class IzmenaZahtevaMB implements Serializable{

    KontrolerZahtevaKorisnika kontroler;
    private int sifraZahteva;
    private int vremeBoravka;
    private int IDDestinacije;
    private int IDTipaPrevoza;
    private int IDTipaSmestaja;
    
    private HashMap<String, Integer> tipoviPrevozaMapa;
    private HashMap<String, Integer> tipoviSmestajaMapa;
    private HashMap<String, Integer> destinacijeMapa;
    private HashMap<String, Integer> korisniciMapa;

    
    private KorisnikPrikaz korisnikPrikaz;
    private List<KorisnikPrikaz> korisniciPrikaz;
    
    ZahtevKorisnikaPrikaz zahtev;
    List<ZahtevKorisnikaPrikaz> listaZahteva;
    
    /**
     * Creates a new instance of IzmenaZahtevaMB
     */
    public IzmenaZahtevaMB() {
        kontroler = new KontrolerZahtevaKorisnika();  
        
    }
    
    @PostConstruct
    public void ucitaj() {
        tipoviPrevozaMapa = kontroler.ucitajTipovePrevoza();
        tipoviSmestajaMapa = kontroler.ucitajTipoveSmestaja();
        destinacijeMapa = kontroler.ucitajDestinacije();
        korisniciPrikaz = kontroler.ucitajKorisnikePrikaz();
        listaZahteva = kontroler.ucitajZahtevePrikaz();
        zahtev = new ZahtevKorisnikaPrikaz();
        
    }

    public int getVremeBoravka() {
        return vremeBoravka;
    }

    public void setVremeBoravka(int vremeBoravka) {
        this.vremeBoravka = vremeBoravka;
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

    public ZahtevKorisnikaPrikaz getZahtev() {
        return zahtev;
    }

    public void setZahtev(ZahtevKorisnikaPrikaz zahtev) {
        this.zahtev = zahtev;
    }

    public List<ZahtevKorisnikaPrikaz> getListaZahteva() {
        return listaZahteva;
    }

    public void setListaZahteva(List<ZahtevKorisnikaPrikaz> listaZahteva) {
        this.listaZahteva = listaZahteva;
    }

    public int getSifraZahteva() {
        return sifraZahteva;
    }

    public void setSifraZahteva(int sifraZahteva) {
        this.sifraZahteva = sifraZahteva;
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

    public HashMap<String, Integer> getKorisniciMapa() {
        return korisniciMapa;
    }

    public void setKorisniciMapa(HashMap<String, Integer> korisniciMapa) {
        this.korisniciMapa = korisniciMapa;
    }

    

   /* public void pronadjiZahtev() {

        System.out.println("Trazi se zahtev sa sifrom :" + sifraZahteva);
        zahtev = kontroler.pronadjiZahtev(sifraZahteva);
        
        if (zahtev != null) {
            vremeBoravka = zahtev.getVremeboravka().intValue();
            IDTipaPrevoza = zahtev.getIdtipaprevoza().getIdtipaprevoza().intValue();
            IDTipaSmestaja = zahtev.getIdtipasmestaja().getIdtipasmestaja().intValue();
            odabraneDestinacije = (List<Destinacija>) zahtev.getDestinacijaCollection();
            for (Destinacija d : odabraneDestinacije) {
                for (int i = 0; i < izabraneD.length; i++) {
                    izabraneD[i] = String.valueOf(d.getIddestinacije());
                    System.out.println("ID destinacije" + izabraneD[i]);
                }
            }

            odabraniKorisnik = zahtev.getIdkorisnika();
            tipPrevoza = zahtev.getIdtipaprevoza();
            tipSmestaja = zahtev.getIdtipasmestaja();

            //prikazZahtev.setSifraZahteva(sifraZahteva);
            System.out.println("Uspesna pretraga");

        } else {
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Greška", "Ne postoji faktura sa datim ID-ijem!"));
            System.out.println("Neuspesna pretraga");
            sifraZahteva = 0;
        }
    }*/
    
    public void postaviZahtev() {

        if (zahtev != null) {
            vremeBoravka = zahtev.getVremeboravka();
            IDTipaPrevoza = zahtev.getIdtipaprevoza().getIdtipaprevoza();
            IDTipaSmestaja = zahtev.getIdtipasmestaja().getIdtipasmestaja();
            IDDestinacije = zahtev.getIddestinacije().getIddestinacije();
            
            korisnikPrikaz = zahtev.getIdkorisnika();
            
            System.out.println("Uspesna pretraga");

        } else {
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Greška", "Niste izabrali zahtev"));
            System.out.println("Neuspesna pretraga");
         
        }
    }


    public void izmeniZahtev() {
        System.out.println("Izmena zahteva: " + zahtev.getSifrazahteva());
        if(zahtev.getSifrazahteva() == 0){
            System.out.println("Sifra je nula");
            return;
        }
        
        //boolean uspesno = kontroler.izmeniZahtev(zahtev.getSifrazahteva().intValue(), vremeBoravka, odabraniKorisnik.getIdkorisnika().intValue(), IDDestinacije, IDTipaPrevoza, IDTipaSmestaja);
        boolean uspesno = kontroler.izmeniZahtevRest(zahtev.getSifrazahteva(), vremeBoravka, korisnikPrikaz.getIdkorisnika(), IDDestinacije, IDTipaPrevoza, IDTipaSmestaja);

        if (uspesno) {
            System.out.println("Uspesna izmena");
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.addMessage(null, new FacesMessage("Uspešna izmena", "Zahtev je uspešno izmenjen"));
            resetuj();
            
        } else {
            System.out.println("Neuspesna izmena");
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Greška", "Zahtev nije izmenjen"));
        }
    }

    
    
    public void resetuj(){
        System.out.println("Resetovanje");
        zahtev = new ZahtevKorisnikaPrikaz();
        vremeBoravka = 0;
        IDTipaPrevoza = 0;
        IDTipaSmestaja = 0;
        IDDestinacije = 0;
        korisnikPrikaz = new KorisnikPrikaz();
        listaZahteva = kontroler.ucitajZahtevePrikaz();
        
    }
    
    public void obrisiZahtev(){
        //boolean uspesno = kontroler.obrisiZahtev(zahtev.getSifrazahteva());
        double sif = zahtev.getSifrazahteva();
        boolean uspesno = kontroler.obrisiZahtevRest( BigDecimal.valueOf(sif));
        
        if (uspesno) {
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.addMessage(null, new FacesMessage("Uspešno brisanje", "Zahtev: "+zahtev.getSifrazahteva()+" je uspešno obrisan"));
            resetuj();            
        } else {
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Greška", "Zahtev nije obrisan"));
        }
    }
}
