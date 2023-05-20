/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import domain.Utente;
import java.awt.image.BufferedImage;
import java.time.LocalDate;
import java.sql.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import qrLib.QR;

/**
 *
 * @author stefa
 */
@Stateless
@Path("parking")
public class UtenteFacadeREST extends AbstractFacade<Utente> {

    @PersistenceContext(unitName = "ParkingPU")
    private EntityManager em;

    public UtenteFacadeREST() {
        super(Utente.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Utente entity) {
        super.create(entity);
    }
    
    @POST
    @Path("register")
    public void register(@FormParam("user") String user, @FormParam("password") String password, @FormParam("mail") String mail, @FormParam("name") String name, @FormParam("surname") String surname, @FormParam("date") String date){
        LocalDate locDate = LocalDate.parse(date);
        Date data = Date.valueOf(locDate);
        create(new Utente(user, password, mail, name, surname, data));
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, Utente entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Utente find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Utente> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Utente> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    @GET
    @Path("qr")
    @Produces("image/png")
    public Response getQr(){
        return Response.ok(QR.createQRCodeBufferedImage("caio", 200)).build();
    }
}
