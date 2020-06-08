/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

/**
 *
 * @author gaga__m
 */
public class RESTKontrolerZahtevKorisnika {
    
    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "http://localhost:8080/WebAplikacijaWS/";

    public RESTKontrolerZahtevKorisnika() {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("zahtevkorisnika");
    }
    
    public Response obrisiZahtev(String sifraZahteva) throws ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("{0}", new Object[]{sifraZahteva})).request().delete(Response.class);
    }

    public Response izmeniZahtev(Object requestEntity, String sifraZahteva) throws ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("{0}", new Object[]{sifraZahteva})).request(javax.ws.rs.core.MediaType.APPLICATION_JSON).put(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON), Response.class);
    }
    
    public Response sacuvajZahtev(Object requestEntity) throws ClientErrorException {
        return webTarget.path("").request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON), Response.class);
    }
}
