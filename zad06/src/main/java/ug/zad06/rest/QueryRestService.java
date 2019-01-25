//package ug.zad06.rest;
//
//
//
//import javax.inject.Inject;
//import javax.json.Json;
//import javax.json.JsonArrayBuilder;
//import javax.json.JsonObject;
//import javax.ws.rs.GET;
//import javax.ws.rs.Path;
//import javax.ws.rs.PathParam;
//import javax.ws.rs.Produces;
//import javax.ws.rs.core.MediaType;
//import javax.ws.rs.core.Response;
//import java.util.List;
//
//@Path("query")
//public class QueryRestService {
//
//    @Inject
//    BookManager bm;
//
//    @GET("/{firstName}")
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response getAuthorsBooks(@PathParam("firstName") String firstName) {
//
//        List<Object[]> rawAuthorsBooks = bm.getAuthorsBooks(firstName);
//        JsonArrayBuilder authorsBooks = Json.createArrayBuilder();
//
//        for(Object[] authorbook : rawAuthorsBooks) {
//            String fName = (String) authorbook[0];
//            String lName = (String) authorbook[1];
//            String title = (String) authorbook[2];
//            int yop = (int) authorbook[3];
//
//            authorsBooks.add(Json.createObjectBuilder()
//                    .add("firstName", fName)
//                    .add("lastName", lName)
//                    .add("title", title)
//                    .add("yop", yop));
//        }
//
//        JsonObject jsonObject = Json.createObjectBuilder().add("result", authorsAndBook).build();
//
//        return Response.ok(jsonObject, MediaType.APPLICATION_JSON).build();
//    }
//}
