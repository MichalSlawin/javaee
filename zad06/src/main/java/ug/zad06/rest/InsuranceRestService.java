package ug.zad06.rest;

import ug.zad06.domain.Insurance;
import ug.zad06.service.InsuranceManager;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("insurance")
public class InsuranceRestService {

    @EJB
    InsuranceManager insuranceManager;

    @POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addInsurance(Insurance insurance) {
        insuranceManager.addInsurance(insurance);

        return Response.status(201).entity(insurance).build();
    }

    @GET()
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Insurance> getAll() {
        return insuranceManager.getAll();
    }

    @GET()
    @Path("/id/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Insurance getInsurance(@PathParam("id") long id) {
        return (Insurance) insuranceManager.getInsurance(id);
    }
}
