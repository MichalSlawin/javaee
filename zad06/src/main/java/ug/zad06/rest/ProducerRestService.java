package ug.zad06.rest;

import ug.zad06.domain.Producer;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("producer")
@Stateless
public class ProducerRestService {
    @PersistenceContext
    EntityManager em;

    @GET
    @Path("/id={producerId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Producer getProducer(@PathParam("producerId") long id) {
        return em.find(Producer.class, id);
    }

    @GET
    @Path("/name={producerName}")
    @Produces(MediaType.APPLICATION_JSON)
    public Producer getProducer(@PathParam("producerName") String name) {
        return (Producer) em.createNamedQuery("producer.findByName").setParameter("name", name).getSingleResult();
    }

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    @SuppressWarnings("unchecked")
    public List<Producer> getAllProducers() {
        return em.createNamedQuery("producer.getAll").getResultList();
    }

    @POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addProducer(Producer producer){
        em.persist(producer);
        return Response.status(201).entity(producer).build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void updateProducer(Producer producer) {
        em.merge(producer);
    }

    @DELETE
    public Response clearProducers(){
        em.createNamedQuery("producer.deleteAll").executeUpdate();
        return Response.status(200).build();
    }

    @DELETE
    @Path("/id={producerId}")
    public Response deleteProducer(@PathParam("producerId") long id) {
        em.createNamedQuery("producer.deleteById").setParameter("id", id).executeUpdate();
        return Response.status(200).build();
    }

    @GET
    @Path("/test")
    @Produces(MediaType.TEXT_PLAIN)
    public String testProducer() {
        return "ProducerRestService test works!";
    }
}
