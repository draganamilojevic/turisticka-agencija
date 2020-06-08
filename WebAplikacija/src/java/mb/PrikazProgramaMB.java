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
import pl.KontrolerProgramaPutovanja;
import prikaz.PotvrdaRezervacijePrikaz;
import prikaz.ProgramPutovanjaPrikaz;

/**
 *
 * @author gaga__m
 */
@ManagedBean
@ViewScoped
public class PrikazProgramaMB implements Serializable{

    KontrolerProgramaPutovanja kontroler;
    private int sifraPrograma;
    private double iznos;
    private String ukljucenoucenu;
    private String nijeukljucenoucenu;
    private String status;
    private int redniBrojPrograma;
    
    private HashMap<String, Integer> programiMapa;
    private HashMap<String, Integer> mestaObilaskaMapa;
    
    private PotvrdaRezervacijePrikaz odabranaPotvrda;
    private List<PotvrdaRezervacijePrikaz> potvrde;

    private List<ProgramPutovanjaPrikaz> listaPrograma;
    private ProgramPutovanjaPrikaz odabranProgram;

    private StavkeKlasa stavka1;
    private List<StavkeKlasa> stavke;
    
    public PrikazProgramaMB() {
        kontroler = new KontrolerProgramaPutovanja();
    }
    
    @PostConstruct
    public void popuni() {
        programiMapa = kontroler.ucitajProgrameOsnova();
        mestaObilaskaMapa = kontroler.ucitajMestaObilaska();
      
        odabranaPotvrda = new PotvrdaRezervacijePrikaz();
        potvrde = kontroler.ucitajPotvrdePrikaz();
        
        stavke = new ArrayList<>();
        
        listaPrograma = kontroler.ucitajProgramePutovanjaPrikaz();
        stavka1 = new StavkeKlasa();
  
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getRedniBrojPrograma() {
        return redniBrojPrograma;
    }

    public void setRedniBrojPrograma(int redniBrojPrograma) {
        this.redniBrojPrograma = redniBrojPrograma;
    }

    public PotvrdaRezervacijePrikaz getOdabranaPotvrda() {
        return odabranaPotvrda;
    }

    public void setOdabranaPotvrda(PotvrdaRezervacijePrikaz odabranaPotvrda) {
        this.odabranaPotvrda = odabranaPotvrda;
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

    public List<ProgramPutovanjaPrikaz> getListaPrograma() {
        return listaPrograma;
    }

    public void setListaPrograma(List<ProgramPutovanjaPrikaz> listaPrograma) {
        this.listaPrograma = listaPrograma;
    }

    public ProgramPutovanjaPrikaz getOdabranProgram() {
        return odabranProgram;
    }

    public void setOdabranProgram(ProgramPutovanjaPrikaz odabranProgram) {
        this.odabranProgram = odabranProgram;
    }

    public void postaviProgram() {
        if (odabranProgram != null) {
            
            sifraPrograma = odabranProgram.getSifraprograma();
            iznos = odabranProgram.getIznos();
            ukljucenoucenu = odabranProgram.getUkljucenoucenu();
            nijeukljucenoucenu = odabranProgram.getNijeukljucenoucenu();
            redniBrojPrograma = odabranProgram.getRednibrojprograma();
            status = odabranProgram.getStatus();
            odabranaPotvrda = odabranProgram.getIdpotvrde();
            stavke =  odabranProgram.getStavke();
       
            
            System.out.println("Uspesna pretraga");

        } else {
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Greška", "Ne postoji faktura sa datim ID-ijem!"));
            System.out.println("Neuspesna pretraga");
            sifraPrograma = 0;
        }
    }

    public StavkeKlasa getStavka1() {
        return stavka1;
    }

    public void setStavka1(StavkeKlasa stavka1) {
        this.stavka1 = stavka1;
    }

    
    
    
}
