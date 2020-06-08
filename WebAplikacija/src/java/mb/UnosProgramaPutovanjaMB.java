/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mb;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import pl.KontrolerProgramaPutovanja;
import prikaz.PotvrdaRezervacijePrikaz;

/**
 *
 * @author gaga__m
 */
@ManagedBean
@ViewScoped
public class UnosProgramaPutovanjaMB implements Serializable{

    KontrolerProgramaPutovanja kontroler;
    private int sifraPrograma;
    private double iznos;
    private String ukljucenoucenu;
    private String nijeukljucenoucenu;
    private String status;
    private int redniBrojPrograma;
  
    private HashMap<String, Integer> programiMapa;
    private HashMap<String, Integer> mestaObilaskaMapa;
    
    private StavkeKlasa izabranaStavka;
    private List<StavkeKlasa> stavke;
   
    private PotvrdaRezervacijePrikaz odabranaPotvrda;
    private List<PotvrdaRezervacijePrikaz> potvrde;
    
    public UnosProgramaPutovanjaMB() {
        kontroler = new KontrolerProgramaPutovanja();
        
    }

    @PostConstruct
    public void popuni() {
        sifraPrograma = kontroler.vratiIDPrograma();
        programiMapa = kontroler.ucitajProgrameOsnova();
        mestaObilaskaMapa = kontroler.ucitajMestaObilaska();
        odabranaPotvrda = new PotvrdaRezervacijePrikaz();
        potvrde = kontroler.ucitajPotvrdePrikaz();
        izabranaStavka = new StavkeKlasa(BigInteger.valueOf(0), BigInteger.valueOf(0), "", "", new Date(), BigInteger.valueOf(1), BigInteger.valueOf(0));
        stavke = new ArrayList<>();
       
    }
    
    public int getSifraPrograma() {
        return sifraPrograma;
    }

    public void setSifraPrograma(int sifraPrograma) {
        this.sifraPrograma = sifraPrograma;
    }

    public double getIznos() {
        return iznos;
    }

    public void setIznos(double iznos) {
        this.iznos = iznos;
    }

    public String getUkljucenoucenu() {
        return ukljucenoucenu;
    }

    public void setUkljucenoucenu(String ukljucenoucenu) {
        this.ukljucenoucenu = ukljucenoucenu;
    }

    public String getNijeukljucenoucenu() {
        return nijeukljucenoucenu;
    }

    public void setNijeukljucenoucenu(String nijeukljucenoucenu) {
        this.nijeukljucenoucenu = nijeukljucenoucenu;
    }

    
    public int getRedniBrojPrograma() {
        return redniBrojPrograma;
    }

    public void setRedniBrojPrograma(int redniBrojPrograma) {
        this.redniBrojPrograma = redniBrojPrograma;
    }

    public HashMap<String, Integer> getProgramiMapa() {
        return programiMapa;
    }

    public void setProgramiMapa(HashMap<String, Integer> programiMapa) {
        this.programiMapa = programiMapa;
    }

    public HashMap<String, Integer> getMestaObilaskaMapa() {
        return mestaObilaskaMapa;
    }

    public void setMestaObilaskaMapa(HashMap<String, Integer> mestaObilaskaMapa) {
        this.mestaObilaskaMapa = mestaObilaskaMapa;
    }

    public PotvrdaRezervacijePrikaz getOdabranaPotvrda() {
        return odabranaPotvrda;
    }

    public void setOdabranaPotvrda(PotvrdaRezervacijePrikaz odabranaPotvrda) {
        this.odabranaPotvrda = odabranaPotvrda;
    }

    public List<PotvrdaRezervacijePrikaz> getPotvrde() {
        return potvrde;
    }

    public void setPotvrde(List<PotvrdaRezervacijePrikaz> potvrde) {
        this.potvrde = potvrde;
    }

    
    public List<StavkeKlasa> getStavke() {
        return stavke;
    }

    public void setStavke(List<StavkeKlasa> stavke) {
        this.stavke = stavke;
    }

    public StavkeKlasa getIzabranaStavka() {
        return izabranaStavka;
    }

    public void setIzabranaStavka(StavkeKlasa izabranaStavka) {
        this.izabranaStavka = izabranaStavka;
    }
    

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    
    public void unesiProgram(){
        System.out.println("Unosi se program: " + sifraPrograma+ " " +iznos + " " + ukljucenoucenu + " " + nijeukljucenoucenu + " " + redniBrojPrograma + " " + odabranaPotvrda.getIdpotvrde());

        //boolean uspesno = kontroler.sacuvajProgram(iznos, ukljucenoucenu, nijeukljucenoucenu, redniBrojPrograma, odabranaPotvrda.getIdpotvrde().intValue(),  stavke, "formiran");

        boolean uspesno = kontroler.sacuvajProgram1(sifraPrograma,iznos, ukljucenoucenu, nijeukljucenoucenu, redniBrojPrograma, odabranaPotvrda.getIdpotvrde(),  stavke, "formiran");

        
        if (uspesno) {
            System.out.println("Uspesan unos");

            FacesContext fc = FacesContext.getCurrentInstance();
            fc.addMessage(null, new FacesMessage("Uspešan unos", "Program putovanja je uspešno unet."));

            

        } else {
            System.out.println("Neuspesan unos");

            FacesContext fc = FacesContext.getCurrentInstance();
            fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Greška u unosu", "Program putovanja nije uspešno unet."));
        }
    }
    
    public void dodajStavku()
    {
        System.out.println("Broj stavki pre unosa: "+stavke.size());
        izabranaStavka.setStatus("unos");
        stavke.add(izabranaStavka);
        izabranaStavka = new StavkeKlasa();
        
    } 
}
