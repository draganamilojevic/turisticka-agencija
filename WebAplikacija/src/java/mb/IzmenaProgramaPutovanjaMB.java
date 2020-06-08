/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mb;

import java.io.Serializable;
import java.math.BigDecimal;
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
import org.primefaces.event.RowEditEvent;
import pl.KontrolerProgramaPutovanja;
import prikaz.PotvrdaRezervacijePrikaz;
import prikaz.ProgramPutovanjaPrikaz;

/**
 *
 * @author gaga__m
 */
@ManagedBean
@ViewScoped
public class IzmenaProgramaPutovanjaMB implements Serializable {

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
    
    private StavkeKlasa izabranaStavka;
    private List<StavkeKlasa> stavke;
    
    private List<ProgramPutovanjaPrikaz> listaPrograma;
    private ProgramPutovanjaPrikaz odabranProgram;
    
    private List<StavkeKlasa> odabraneStavke;
    private StavkeKlasa stavka1;
    private List<StavkeKlasa> obrisaneStavke;

    public IzmenaProgramaPutovanjaMB() {
        kontroler = new KontrolerProgramaPutovanja();
    }

    @PostConstruct
    public void popuni() {
        programiMapa = kontroler.ucitajProgrameOsnova();
        mestaObilaskaMapa = kontroler.ucitajMestaObilaska();
        odabranaPotvrda = new PotvrdaRezervacijePrikaz();
        potvrde = kontroler.ucitajPotvrdePrikaz();
        izabranaStavka = new StavkeKlasa(BigInteger.valueOf(0), BigInteger.valueOf(0), "", "", new Date(), BigInteger.valueOf(1), BigInteger.valueOf(0));
        System.out.println("Inicijalizovana stavka");
        stavke = new ArrayList<>();
        listaPrograma = kontroler.ucitajProgramePutovanjaPrikaz();
        stavka1 = new StavkeKlasa();
        obrisaneStavke = new ArrayList<>();
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

    

    public StavkeKlasa getIzabranaStavka() {
        return izabranaStavka;
    }

    public void setIzabranaStavka(StavkeKlasa izabranaStavka) {
        this.izabranaStavka = izabranaStavka;
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
            if (odabranProgram.getStatus().equals("poslat")) {
                FacesContext fc = FacesContext.getCurrentInstance();
                fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "", "Program je poslat, nije moguca izmena"));
                return;
            }
            sifraPrograma = odabranProgram.getSifraprograma();
            iznos = odabranProgram.getIznos();
            ukljucenoucenu = odabranProgram.getUkljucenoucenu();
            nijeukljucenoucenu = odabranProgram.getNijeukljucenoucenu();
            redniBrojPrograma = odabranProgram.getRednibrojprograma();
            status = odabranProgram.getStatus();
            odabranaPotvrda = odabranProgram.getIdpotvrde();
            stavke =  odabranProgram.getStavke();
     
            if(stavke.isEmpty()){
                System.out.println("Prazne stavke");
            }
            System.out.println("Uspesna pretraga");

        } else {
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Greška", "Niste odabrali program!"));
            System.out.println("Neuspesna pretraga");
            sifraPrograma = 0;
        }
    }

    public List<StavkeKlasa> getOdabraneStavke() {
        return odabraneStavke;
    }

    public void setOdabraneStavke(List<StavkeKlasa> odabraneStavke) {
        this.odabraneStavke = odabraneStavke;
    }

    public StavkeKlasa getStavka1() {
        return stavka1;
    }

    public void setStavka1(StavkeKlasa stavka1) {
        this.stavka1 = stavka1;
    }

    public void izmeniStavku(RowEditEvent event) {
       
        for (StavkeKlasa sk : stavke) {
            if (stavka1 == null) {
                System.out.println("Stavka1 je null");
                return;
            }
            if (sk.getIddana() == stavka1.getIddana()) {
                sk = stavka1;
                sk.setDatum(stavka1.getDatum());
                sk.setIdmesta(stavka1.getIdmesta());
                sk.setOpisdana(stavka1.getOpisdana());
                sk.setProgramputovanja(stavka1.getProgramputovanja());
                sk.setSifraprograma(stavka1.getSifraprograma());

                sk.setStatus("izmena");

                stavka1 = new StavkeKlasa();
                return;
            }
        }
        FacesMessage msg = new FacesMessage("Uspešna izmena", "");
        FacesContext.getCurrentInstance().addMessage(null, msg);

    }

    public void ponistiIzmenuStavke(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Neuspešana izmena", "");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void obrisiStavku() {
        for (StavkeKlasa sk : stavke) {
            if (stavka1 == null) {
                System.out.println("Stavka1 je null");
                return;
            }
            if (sk.getIddana() == stavka1.getIddana()) {
                stavke.remove(sk);

                sk.setStatus("brisanje");
                obrisaneStavke.add(sk);

                stavka1 = new StavkeKlasa();
                return;
            }
        }
    }

    public List<StavkeKlasa> getObrisaneStavke() {
        return obrisaneStavke;
    }

    public void setObrisaneStavke(List<StavkeKlasa> obrisaneStavke) {
        this.obrisaneStavke = obrisaneStavke;
    }

    public void izmeniProgram() {
        System.out.println("Poruka: ");
        System.out.println("Izmena programa: " + sifraPrograma);
        if (sifraPrograma == 0) {
            System.out.println("Sifra je nula");
            return;
        }

        System.out.println("Status programa: "+status);
        stavke.addAll(obrisaneStavke);
        

        //boolean uspesno = kontroler.izmeniProgram(odabranProgram.getSifraprograma().intValue(), iznos, ukljucenoucenu, nijeukljucenoucenu, redniBrojPrograma, odabranaPotvrda.getIdpotvrde().intValue(), stavke, status);
        boolean uspesno = kontroler.izmeniProgram1(sifraPrograma, iznos, ukljucenoucenu, nijeukljucenoucenu, redniBrojPrograma, odabranaPotvrda.getIdpotvrde(), stavke, status);
      
        
        if (uspesno) {
            System.out.println("Uspesna izmena");
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.addMessage(null, new FacesMessage("Uspešna izmena", "Program putovanja je uspešno izmenjen"));
            //resetujPolja();
        } else {
            System.out.println("Neuspesna izmena");
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Greška", "Program putovanja nije izmenjen"));
        }
    }

    public void dodajStavku() {
        System.out.println("Broj stavki pre unosa: " + stavke.size());
        izabranaStavka.setStatus("unosenje");
        stavke.add(izabranaStavka);
        izabranaStavka = new StavkeKlasa();

    }
    
    public void obrisiProgram(){
        
        double sif = sifraPrograma;
        boolean uspesno = kontroler.obrisiProgram(BigDecimal.valueOf(sif), stavke);
        
        
        if (uspesno) {
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.addMessage(null, new FacesMessage("Uspešno brisanje", "Program: "+odabranProgram.getSifraprograma()+" je uspešno obrisan"));
            //resetuj();            
            
        } else {
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Greška", "Program nije obrisan"));
        }
    }
}
