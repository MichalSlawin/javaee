package ug.zad06.rest;

import ug.zad06.service.DoorManager;

import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("query")
public class QueryRestService {

    @Inject
    DoorManager doorManager;

    @GET()
    @Path("/name/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getDoorProducerName(@PathParam("name") String name) {

        List<Object[]> rawDoorProducersNames = doorManager.getProducerNames(name);
        JsonArrayBuilder doorProducersNames = Json.createArrayBuilder();

        for(Object[] doorProducerName : rawDoorProducersNames) {
            String producerName = (String) doorProducerName[0];
            String description = (String) doorProducerName[1];
            double price = (double) doorProducerName[2];

            doorProducersNames.add(Json.createObjectBuilder()
                    .add("producerName", producerName)
                    .add("description", description)
                    .add("price", price));
        }

        JsonObject jsonObject = Json.createObjectBuilder().add("result", doorProducersNames).build();

        return Response.ok(jsonObject, MediaType.APPLICATION_JSON).build();
    }
}
