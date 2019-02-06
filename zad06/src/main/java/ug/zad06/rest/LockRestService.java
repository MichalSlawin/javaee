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

        return Response.status(201).entity(lock).build();
    }

    @GET()
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Lock> getAll() {
        return lockManager.getAll();
    }

    @GET()
    @Path("/id/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Lock getLock(@PathParam("id") long id) {
        return (Lock) lockManager.findLock(id);
    }

    @GET
    @Path("/electronic/{electronic}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Lock> getLocks(@PathParam("electronic") boolean electronic) {
        return lockManager.getLocks(electronic);
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void updateLock(Lock lock) {
        lockManager.updateLock(lock);
    }

    @DELETE
    public Response clearLocks(){
        lockManager.clearLocks();
        return Response.status(200).build();
    }

    @DELETE
    @Path("/id/{lockId}")
    public Response deleteLock(@PathParam("lockId") long id) {
        lockManager.deleteById(id);
        return Response.status(200).build();
    }
    
}
