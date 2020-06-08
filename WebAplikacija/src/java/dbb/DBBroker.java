/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbb;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import model.Destinacija;
import model.Korisnik;
import model.Mestoobilaska;
import model.Potvrdarezervacije;
import model.Programiputovanja;
import model.Programputovanja;
import model.Stavkaprograma;
import model.Tipprevoza;
import model.Tipsmestaja;
import model.Zahtevkorisnika;

/**
 *
 * @author gaga__m
 */
public class DBBroker implements Serializable {

    EntityManagerFactory emf;
    EntityManager em;

    public DBBroker() {
        emf = Persistence.createEntityManagerFactory("WebAplikacijaPU");
    }

    public void otvoriKonekciju() {
        if (em == null || !em.isOpen()) {
            em = emf.createEntityManager();
        }
    }

    public void zatvoriKonekciju() {
        if (em.isOpen()) {
            em.close();
        }
    }

    public void pokreniTransakciju() {
        if (em.isOpen()) {
            em.getTransaction().begin();
        }
    }

    public void potvrdiTransakciju() {
        if (em.isOpen()) {
            em.getTransaction().commit();
            System.out.println("Commitovano");
        }
    }

    public void ponistiTransakciju() {
        if (em.isOpen()) {
            em.getTransaction().rollback();
        }
    }

    public boolean sacuvajTipPrevoza(Tipprevoza tp) {
        try {
            if (em.isOpen()) {
                em.persist(tp);
            }
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public List<Tipprevoza> ucitajTipovePrevoza() {
        List<Tipprevoza> tipoviPrevoza = new ArrayList<>();

        if (em.isOpen()) {
            tipoviPrevoza = em.createNamedQuery("Tipprevoza.findAll").getResultList();
        }

        return tipoviPrevoza;
    }

    public List<Tipsmestaja> ucitajTipoveSmestaja() {
        List<Tipsmestaja> tipoviSmestaja = new ArrayList<>();

        if (em.isOpen()) {
            tipoviSmestaja = em.createNamedQuery("Tipsmestaja.findAll").getResultList();
        }

        return tipoviSmestaja;
    }

    public List<Destinacija> ucitajDestinacije() {
        List<Destinacija> destinacije = new ArrayList<>();

        if (em.isOpen()) {
            destinacije = em.createNamedQuery("Destinacija.findAll").getResultList();
        }

        return destinacije;
    }

    public List<Korisnik> ucitajKorisnike() {
        List<Korisnik> korisnici = new ArrayList<>();

        if (em.isOpen()) {
            korisnici = em.createNamedQuery("Korisnik.findAll").getResultList();
        }

        return korisnici;
    }

    public boolean sacuvajZahtev(Zahtevkorisnika novi) {
        //boolean uspesno = false;
        //BigDecimal id = vratiMaxID();
        //System.out.println("id " + id);
//        novi.setSifrazahteva(BigDecimal.valueOf(id));
        try {
            if (!em.isOpen()) {
                System.out.println("em nije otvoreno");
            }
            if (em.isOpen()) {
                System.out.println("try");
                em.persist(novi);
                return true;
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("catch");
        }
        return false;
    }

    public BigDecimal vratiMaxID() {
        BigDecimal id = BigDecimal.valueOf(0);
        if (em.isOpen()) {
            id = (BigDecimal) em.createQuery("SELECT MAX(pp.sifraprograma) from Programputovanja pp").getSingleResult();
        }
        
        if (id == null) {
            id = BigDecimal.valueOf(0);
            System.out.println("id je null po izvrsenju upita");
        }
        System.out.println("max ID je: " + id);
        int d = id.intValue();
        d++;
        id = BigDecimal.valueOf(d);
        System.out.println("sifra programa: " + id);
        return id;
    }

    public List<Zahtevkorisnika> ucitajZahteve() {
        List<Zahtevkorisnika> zahtevi = new ArrayList<>();

        if (em.isOpen()) {
            zahtevi = em.createNamedQuery("Zahtevkorisnika.findAll").getResultList();
        }

        return zahtevi;
    }

    public boolean izmeniZahtev(Zahtevkorisnika novi) {
        try {

            if (em.isOpen()) {
                em.merge(novi);

            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean obrisiZahtev(BigDecimal sifra) {
        try {
            if (em.isOpen()) {
                Zahtevkorisnika z = em.find(Zahtevkorisnika.class, sifra);
                if (z == null) {
                    System.out.println("Zahtev je null");
                    return false;
                }
                //System.out.println("Zahtev smestaj: "+z.getIdtipasmestaja().getNazivtipasmestaja());
                if (em.isOpen()) {
                    em.remove(z);
                }

                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    public List<Programiputovanja> ucitajProgrameOsnov() {
        List<Programiputovanja> programiO = new ArrayList<>();

        if (em.isOpen()) {
            programiO = em.createNamedQuery("Programiputovanja.findAll").getResultList();
        }

        return programiO;
    }

    public List<Mestoobilaska> ucitajMesta() {
        List<Mestoobilaska> mesta = new ArrayList<>();

        if (em.isOpen()) {
            mesta = em.createNamedQuery("Mestoobilaska.findAll").getResultList();
        }

        return mesta;
    }

    public List<Potvrdarezervacije> ucitajPotvrde() {
        List<Potvrdarezervacije> potvrde = new ArrayList<>();

        if (em.isOpen()) {
            potvrde = em.createNamedQuery("Potvrdarezervacije.findAll").getResultList();
        }

        return potvrde;
    }

    public boolean sacuvajProgram(Programputovanja novi) {
        try {
            if (!em.isOpen()) {
                System.out.println("em nije otvoreno");
            }
            if (em.isOpen()) {
                System.out.println("try");
                em.persist(novi);

                return true;
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("catch");
        }
        return false;
    }

    public boolean sacuvajStavku(Stavkaprograma stavka) {
        try {
            if (!em.isOpen()) {
                System.out.println("em nije otvoreno");
            }
            if (em.isOpen()) {
                System.out.println("try");
                em.persist(stavka);
                return true;
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("catch");
        }
        return false;
    }

    public List<Programputovanja> ucitajProgramePutovanja() {
        List<Programputovanja> programii = new ArrayList<>();

        if (em.isOpen()) {
            programii = em.createNamedQuery("Programputovanja.findAll").getResultList();
        }

        return programii;
    }

    public void izmeniProgram(Programputovanja pp) {
        try {
            if (em.isOpen()) {

                em.merge(pp);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void izmeniStavku(Stavkaprograma st) {
        try {
            if (!em.isOpen()) {

                System.out.println("em nije otvoreno");

            }
            if (em.isOpen()) {

                em.merge(st);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void obrisiStavku(BigInteger iddana, BigInteger sifraprograma) {
        try {
            if (!em.isOpen()) {
                System.out.println("em nije otvoreno");
            }
            if (em.isOpen()) {
                //System.out.println("DELETE FROM stavkarezervacijehotela WHERE sifra_zahteva=" + sifraZahteva + " AND idStavkeRezHotela=" + idStavkeRezHotela + "");
               //em.createNativeQuery("DELETE FROM Stavkaprograma WHERE stavkaprogramaPK.sifraprograma=" + sifraprograma + " AND stavkaprogramaPK.iddana=" + iddana + "");
               //System.out.println("DELETE FROM Stavkaprograma WHERE sifraprograma=" + sifraprograma + " AND iddana=" + iddana + "");
                List<Stavkaprograma> listaS = em.createNamedQuery("Stavkaprograma.findAll").getResultList();

                if (listaS == null) {
                    System.out.println("Z je null");
                    return;
                }

                for (Stavkaprograma sp : listaS) {
                    if (sp.getStavkaprogramaPK().getSifraprograma() == sifraprograma && sp.getStavkaprogramaPK().getIddana() == iddana) {
                        System.out.println("Nasao tu stavku");
                        em.remove(sp);
                    }
                }
                        
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public boolean obrisiProgram(BigDecimal sifraprograma) {
        try {
            if (em.isOpen()) {
                Programputovanja pp = em.find(Programputovanja.class, sifraprograma);
                if (pp == null) {
                    System.out.println("PP je null");
                    return false;
                }

                if (em.isOpen()) {
                    em.remove(pp);
                }

                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    public BigDecimal vratiMaxIDZahteva() {
        BigDecimal id = BigDecimal.valueOf(0);
        if (em.isOpen()) {
            id = (BigDecimal) em.createQuery("SELECT MAX(zk.sifrazahteva) from Zahtevkorisnika zk").getSingleResult();
        }
        if (id == null) {
            id = BigDecimal.valueOf(0);
            System.out.println("id je null po izvrsenju upita");
        }
        System.out.println("max ID je: " + id);
        int d = id.intValue();
        d++;
        id = BigDecimal.valueOf(d);
        System.out.println("sifra programa: " + id);
        return id;
    }

    public boolean sacuvajProgram(Programputovanja novi, List<Stavkaprograma> novaLista) {
        try {
            if(!em.isOpen()){
                System.out.println("Em nije otvoreno");
            }
            
            if (em.isOpen()) {
     
                em.persist(novi);
                for (Stavkaprograma sp : novaLista) {
                    em.persist(sp);
                }

                return true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean izmeniProgram(Programputovanja pp, List<Stavkaprograma> novaLista) {
        try {
            if (!em.isOpen()) {
                System.out.println("Em nije otvoreno");
            }
            if (em.isOpen()) {

                em.merge(pp);
                for (Stavkaprograma sp : novaLista) {
                    if (sp.getStatus().equals("unosenje")) {
                        sp.setStatus("izmena");
                        System.out.println("Uslo u unosenje");
                        em.persist(sp);
                    } else if (sp.getStatus().equals("izmena")) {
                        System.out.println("Uslo u izmenu");
                        em.merge(sp);

                    } else if (sp.getStatus().equals("brisanje")) {
                        System.out.println("Uslo u brisanje");
                        obrisiStavku(sp.getStavkaprogramaPK().getIddana(), sp.getStavkaprogramaPK().getSifraprograma());
                        //em.remove(sp);
                    }
                }
                return true;

            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
