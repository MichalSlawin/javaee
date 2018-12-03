package ug.zad05.rest;

import ug.zad05.domain.Door;
import ug.zad05.service.DoorManager;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("door")
@Stateless
public class DoorRESTService {

    @Inject
    private DoorManager doorManager;

    @GET
    @Path("/id={doorId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Door getDoor(@PathParam("doorId") Long id) {
        return doorManager.getDoor(id);
    }

    @GET
    @Path("/producer={doorProducer}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Door> getDoors(@PathParam("doorProducer") String producer) {
        return doorManager.getDoors(producer);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Door> getAllDoors() {
        return doorManager.getAllDoors();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addDoor(Door door) {
        doorManager.addDoor(door);

        return Response.status(201).entity("Door").build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void updateDoor(Door door) {
        doorManager.updateDoor(door);
    }

    @DELETE
    public Response deleteAllDoors() {
        doorManager.deleteAllDoors();
        return Response.status(200).build();
    }

    @DELETE
    @Path("/id={doorId}")
    public Response deleteDoor(@PathParam("doorId") long id) {
        doorManager.deleteDoor(id);
        return Response.status(200).build();
    }

}
