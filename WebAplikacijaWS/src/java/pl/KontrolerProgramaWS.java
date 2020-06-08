/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl;

import dbb.DBBroker;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import model.Korisnik;
import model.Mestoobilaska;
import model.Potvrdarezervacije;
import model.Programiputovanja;
import model.Programputovanja;
import model.Stavkaprograma;
import model.StavkaprogramaPK;

/**
 *
 * @author gaga__m
 */
public class KontrolerProgramaWS {
    DBBroker dbb;

    public KontrolerProgramaWS() {
        dbb = new DBBroker();
    }
    
    public HashMap<String, Integer> ucitajProgrameOsnova() {
        HashMap<String, Integer> programiMapa = new HashMap<>();
        List<Programiputovanja> listaProgramaOsnov = new ArrayList<>();

        try {
            dbb.otvoriKonekciju();
            listaProgramaOsnov = dbb.ucitajProgrameOsnov();
            dbb.zatvoriKonekciju();
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (Programiputovanja ppo : listaProgramaOsnov) {
            programiMapa.put(ppo.getSablonprograma(), ppo.getRednibrojprograma().intValue());
        }
        return programiMapa;
    }

    public List<Korisnik> ucitajKorisnike() {
        List<Korisnik> korisniciLista = new ArrayList<>();
        try {
            dbb.otvoriKonekciju();
            korisniciLista = dbb.ucitajKorisnike();
            dbb.zatvoriKonekciju();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return korisniciLista;
    }

    public HashMap<String, Integer> ucitajMestaObilaska() {
        HashMap<String, Integer> mestaMapa = new HashMap<>();
        List<Mestoobilaska> listaMesta = new ArrayList<>();

        try {
            dbb.otvoriKonekciju();
            listaMesta = dbb.ucitajMesta();
            dbb.zatvoriKonekciju();
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (Mestoobilaska mo : listaMesta) {
            mestaMapa.put(mo.getNazivmesta(), mo.getIdmesta().intValue());
        }

        return mestaMapa;
    }

    public List<Potvrdarezervacije> ucitajPotvrde() {
        List<Potvrdarezervacije> potvrdeLista = new ArrayList<>();
        try {
            dbb.otvoriKonekciju();
            potvrdeLista = dbb.ucitajPotvrde();
            dbb.zatvoriKonekciju();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return potvrdeLista;
    }

    public Programiputovanja pronadjiOsnovProgram(int redniBrojPrograma) {
        List<Programiputovanja> listaosnova = new ArrayList<>();
        try {
            dbb.otvoriKonekciju();
            listaosnova = dbb.ucitajProgrameOsnov();
            dbb.zatvoriKonekciju();
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (Programiputovanja ppo : listaosnova) {
            if (ppo.getRednibrojprograma().intValue() == redniBrojPrograma) {
                return ppo;
            }
        }
        return null;
    }

    public Potvrdarezervacije pronadjiPotvrduRez(int idpotvrde) {
        List<Potvrdarezervacije> listapotvrda = new ArrayList<>();
        try {
            dbb.otvoriKonekciju();
            listapotvrda = dbb.ucitajPotvrde();
            dbb.zatvoriKonekciju();
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (Potvrdarezervacije pr : listapotvrda) {
            if (pr.getIdpotvrde().intValue() == idpotvrde) {
                return pr;
            }
        }
        return null;
    }

    /*public boolean sacuvajProgram(double iznos, String ukljucenoucenu, String nijeukljucenoucenu, int redniBrojPrograma, int idpotvrde, List<StavkeKlasa> listaStavki, String status) {
        /*boolean uspesno = false;

        try {

            Programputovanja novi = kreirajProgram(iznos, ukljucenoucenu, nijeukljucenoucenu, pronadjiOsnovProgram(redniBrojPrograma), pronadjiPotvrduRez(idpotvrde), status);
            System.out.println("Program formiran");
            System.out.println("Program iznos: " + novi.getIznos());
            System.out.println("Program osnov program: " + novi.getRednibrojprograma().getSablonprograma());
            System.out.println("Program potvrda rez: " + novi.getIdpotvrde().getOpis());

            if (listaStavki.isEmpty()) {
                System.out.println("Lista stavki prazna");
                return false;
            }

            dbb.otvoriKonekciju();
            dbb.pokreniTransakciju();

            BigDecimal sifraPrograma = dbb.vratiMaxID();

            novi.setSifraprograma(sifraPrograma);
            uspesno = dbb.sacuvajProgram(novi);
            
            //dbb.zatvoriKonekciju();
            if (uspesno) {
                dbb.potvrdiTransakciju();
                dbb.zatvoriKonekciju();
                System.out.println("If");
                //return true;
            } else {
                dbb.ponistiTransakciju();
                dbb.zatvoriKonekciju();
                System.out.println("Else");
                //return false;
            }
            int sifra = sifraPrograma.intValue();
            boolean uspesnoStavka = false;

            //dbb.zatvoriKonekciju();
            for (StavkeKlasa s : listaStavki) {
                s.setSifraprograma(BigInteger.valueOf(sifra));
                Stavkaprograma stavka = kreirajStavku(s);
                dbb.otvoriKonekciju();
                dbb.pokreniTransakciju();
                uspesnoStavka = dbb.sacuvajStavku(stavka);
                System.out.println("Uspesno stavka:" + uspesnoStavka);
                if (uspesnoStavka) {
                    dbb.potvrdiTransakciju();
                    dbb.zatvoriKonekciju();
                    System.out.println("If stavka");
                    //return true;
                } else {
                    dbb.ponistiTransakciju();
                    dbb.zatvoriKonekciju();
                    System.out.println("Else stavka");
                    //return false;
                }
            }
            if(uspesno == true && uspesnoStavka == true){
                return true;
            }

        } catch (Exception e) {
            e.printStackTrace();
            dbb.zatvoriKonekciju();
        }
        return false;
                
        
        boolean uspesno = false;

        try {
            
            
            Programputovanja novi = kreirajProgram(iznos, ukljucenoucenu, nijeukljucenoucenu, pronadjiOsnovProgram(redniBrojPrograma), pronadjiPotvrduRez(idpotvrde), status);
            System.out.println("Program formiran");
            System.out.println("Program iznos: " + novi.getIznos());
            System.out.println("Program osnov program: " + novi.getRednibrojprograma().getSablonprograma());
            System.out.println("Program potvrda rez: " + novi.getIdpotvrde().getOpis());

            if (listaStavki.isEmpty()) {
                System.out.println("Lista stavki prazna");
                return false;
            }

            dbb.otvoriKonekciju();
            dbb.pokreniTransakciju();

            BigDecimal sifraPrograma = dbb.vratiMaxID();

            novi.setSifraprograma(sifraPrograma);
            uspesno = dbb.sacuvajProgram(novi);
           
            
            int sifra = sifraPrograma.intValue();
            boolean uspesnoStavka = false;

            for (StavkeKlasa s : listaStavki) {
                s.setSifraprograma(BigInteger.valueOf(sifra));
                Stavkaprograma stavka = kreirajStavku(s);
                
                uspesnoStavka = dbb.sacuvajStavku(stavka);
                System.out.println("Uspesno stavka:" + uspesnoStavka);
                
            }
            
            if(uspesno == true && uspesnoStavka == true){
                dbb.potvrdiTransakciju();
                dbb.zatvoriKonekciju();
            }else{
                dbb.ponistiTransakciju();
                dbb.zatvoriKonekciju();
            }

        } catch (Exception e) {
            e.printStackTrace();
            dbb.zatvoriKonekciju();
        }
        return false;
    }*/
    
    

    private Programputovanja kreirajProgram(double iznos, String ukljucenoucenu, String nijeukljucenoucenu, Programiputovanja osnovProgram, Potvrdarezervacije potvrdaRez, String status) {
        Programputovanja pp = new Programputovanja();
        pp.setIznos(BigDecimal.valueOf(iznos));
        pp.setUkljucenoucenu(ukljucenoucenu);
        pp.setNijeukljucenoucenu(nijeukljucenoucenu);
        pp.setRednibrojprograma(osnovProgram);
        pp.setIdpotvrde(potvrdaRez);
        pp.setStatus(status);

        return pp;
    }
    
    private Programputovanja kreirajProgram(int sifraPrograma,double iznos, String ukljucenoucenu, String nijeukljucenoucenu, Programiputovanja osnovProgram, Potvrdarezervacije potvrdaRez, String status) {
        Programputovanja pp = new Programputovanja();
        double sifrap = sifraPrograma;
        pp.setSifraprograma(BigDecimal.valueOf(sifrap));
        pp.setIznos(BigDecimal.valueOf(iznos));
        pp.setUkljucenoucenu(ukljucenoucenu);
        pp.setNijeukljucenoucenu(nijeukljucenoucenu);
        pp.setRednibrojprograma(osnovProgram);
        pp.setIdpotvrde(potvrdaRez);
        pp.setStatus(status);

        return pp;
    }

    /*private Stavkaprograma kreirajStavku(StavkeKlasa s) {
        Stavkaprograma sp = new Stavkaprograma();
        sp.setDatum(s.getDatum());
        Mestoobilaska mo = pronadjiMesto(s.getIdmesta().intValue());
        sp.setIdmesta(mo);
        sp.setOpisdana(s.getOpisdana());
        sp.setStavkaprogramaPK(new StavkaprogramaPK(s.getIddana(), s.getSifraprograma()));
        sp.setStatus(s.getStatus());
        return sp;
    }*/

    private Mestoobilaska pronadjiMesto(int idmesta) {
        List<Mestoobilaska> listamesta = new ArrayList<>();
        try {
            dbb.otvoriKonekciju();
            listamesta = dbb.ucitajMesta();
            dbb.zatvoriKonekciju();
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (Mestoobilaska m : listamesta) {
            if (m.getIdmesta().intValue() == idmesta) {
                return m;
            }
        }
        return null;
    }

    public List<Programputovanja> ucitajProgramePutovanja() {
        List<Programputovanja> listaprograma = new ArrayList<>();
        try {
            dbb.otvoriKonekciju();
            listaprograma = dbb.ucitajProgramePutovanja();
            dbb.zatvoriKonekciju();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaprograma;
    }

    /*public boolean izmeniProgram(int sifraPrograma, double iznos, String ukljucenoucenu, String nijeukljucenoucenu, int redniBrojPrograma, int idpotvrde, List<StavkeKlasa> stavke, String status) {
        boolean uspesno = false;

        try {
            Programputovanja pp = kreirajProgram(sifraPrograma, iznos, ukljucenoucenu, nijeukljucenoucenu, pronadjiOsnovProgram(redniBrojPrograma), pronadjiPotvrduRez(idpotvrde), status);
            
            dbb.otvoriKonekciju();
            dbb.pokreniTransakciju();
            dbb.izmeniProgram(pp);
            dbb.potvrdiTransakciju();
            dbb.zatvoriKonekciju();
            
            for (StavkeKlasa sk : stavke) {
                sk.setSifraprograma(BigInteger.valueOf(sifraPrograma));
                Stavkaprograma st = kreirajStavku(sk);
                dbb.otvoriKonekciju();
                dbb.pokreniTransakciju();
                if (st.getStatus().equals("unos")) {
                    st.setStatus("izmena");
                    System.out.println("Uslo u unos");
                    dbb.sacuvajStavku(st);
                } else if(st.getStatus().equals("izmena")){
                    System.out.println("Uslo u izmenu");
                    dbb.izmeniStavku(st);

                }else if (st.getStatus().equals("brisanje")) {
                    System.out.println("Uslo u brisanje");
                    dbb.obrisiStavku(st.getStavkaprogramaPK().getIddana(), st.getStavkaprogramaPK().getSifraprograma());
                    
                }
                dbb.potvrdiTransakciju();
            }

            //dbb.potvrdiTransakciju();
            uspesno = true;
        } catch (Exception e) {
            e.printStackTrace();
            dbb.ponistiTransakciju();
            uspesno = false;
        }
        dbb.zatvoriKonekciju();
        return uspesno;
    }*/

    

    /*public boolean obrisiProgram(BigDecimal sifraprograma, List<StavkeKlasa> stavke) {
        boolean uspesno = false;

        try {
            dbb.otvoriKonekciju();
            dbb.pokreniTransakciju();
            System.out.println("Pokrenuta transakcija");
            uspesno = dbb.obrisiProgram(sifraprograma);
            for (StavkeKlasa sk : stavke) {
                dbb.obrisiStavku(sk.getIddana(), sk.getSifraprograma());
            }
            dbb.potvrdiTransakciju();
            dbb.zatvoriKonekciju();
        } catch (Exception e) {
            dbb.ponistiTransakciju();
            dbb.zatvoriKonekciju();
            e.printStackTrace();
        }

        return uspesno;
    }*/
    
}
