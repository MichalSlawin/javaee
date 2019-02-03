package ug.zad06.rest;

import ug.zad06.domain.Door;
import ug.zad06.util.DoorResponse;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.text.DateFormat;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@Path("door")
@Stateless
public class DoorRestService {

    @PersistenceContext
    EntityManager em;

    @GET
    @Path("/id/{doorId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Door getDoor(@PathParam("doorId") long id) {
        return (Door) em.createNamedQuery("door.findById").setParameter("id", id).getSingleResult();
    }

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    @SuppressWarnings("unchecked")
    public List<Door> getAllDoors() {
        return em.createNamedQuery("door.getAll").getResultList();
    }

    @GET
    @Path("/exterior/{exterior}")
    @Produces(MediaType.APPLICATION_JSON)
    @SuppressWarnings("unchecked")
    public List<Door> getDoor(@PathParam("exterior") boolean exterior) {
        return em.createNamedQuery("door.findByExterior").setParameter("exterior", exterior).getResultList();
    }

    @POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addDoor(Door door){
        em.persist(door);
        return Response.status(201).entity(door).build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void updateDoor(Door door) {
        em.merge(door);
    }

    @DELETE
    public Response clearDoors(){
        em.createNamedQuery("door.deleteAll").executeUpdate();
        return Response.status(200).build();
    }

    @DELETE
    @Path("/id/{doorId}")
    public Response deleteDoor(@PathParam("doorId") long id) {
        em.createNamedQuery("door.deleteById").setParameter("id", id).executeUpdate();
        return Response.status(200).build();
    }

    @DELETE
    @Path("/date/{date}")
    public Response deleteDoors(@PathParam("date") String dateStr) {
        ParsePosition PARSE_POSITION = new ParsePosition(0);
        DateFormat parser = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        Date date = parser.parse( dateStr, PARSE_POSITION);

        em.createNamedQuery("door.deleteOlder").setParameter("date", date).executeUpdate();

        return Response.status(200).build();
    }

}
