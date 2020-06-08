/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest.config;

import rest.service.*;
import java.util.HashSet;
import java.util.Set;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 *
 * @author gaga__m
 */
@ApplicationPath("/")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> s = new HashSet<>();
        s.add(ZahtevkorisnikaFacadeREST.class);
        s.add(ProgramputovanjaFacadeREST.class);
        s.add(TipsmestajaFacadeREST.class);
        s.add(TipprevozaFacadeREST.class);
        s.add(DestinacijaFacadeREST.class);
        s.add(KorisnikFacadeREST.class);
        return s;
    }

}
