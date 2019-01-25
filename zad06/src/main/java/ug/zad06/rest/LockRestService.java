package ug.zad06.rest;

import ug.zad06.domain.Lock;
import ug.zad06.service.LockManager;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("lock")
public class LockRestService {

    @EJB
    LockManager lockManager;

    @POST()
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addLock(Lock lock) {
        lockManager.addLock(lock);

        return Response.status(Response.Status.CREATED).build();
    }

    @GET()
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Lock> getAll() {
        return lockManager.getAll();
    }
}
