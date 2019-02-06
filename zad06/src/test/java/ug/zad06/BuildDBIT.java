package ug.zad06;

import com.jayway.restassured.RestAssured;
import org.junit.BeforeClass;
import org.junit.Test;
import ug.zad06.domain.Producer;

import javax.json.Json;
import javax.ws.rs.core.MediaType;

import static com.jayway.restassured.RestAssured.given;

public class BuildDBIT {
    @BeforeClass
    public static void setUp(){
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 8080;
        RestAssured.basePath = "/zad06/api";
    }

    @Test
    public void addAll() {
        addProducers();
        addLocks();
        addInsurances();
        addDoors();
    }

    private void addProducers() {
        Producer producer = new Producer();

        producer.setName("Porta");
        given().contentType(MediaType.APPLICATION_JSON).body(producer).when().
                post("/producer/").then().assertThat().statusCode(201);

        producer.setName("BRW");
        given().contentType(MediaType.APPLICATION_JSON).body(producer).when().
                post("/producer/").then().assertThat().statusCode(201);

        producer.setName("Zamkotron");
        given().contentType(MediaType.APPLICATION_JSON).body(producer).when().
                post("/producer/").then().assertThat().statusCode(201);
    }

    private void addLocks() {
        String json1 = Json.createObjectBuilder().add("producer", Json.createObjectBuilder().add("id", 1))
                .add("electronic", "false").build().toString();
        given().contentType(MediaType.APPLICATION_JSON).body(json1).when().
                post("/lock/").then().assertThat().statusCode(201);

        String json2 = Json.createObjectBuilder().add("producer", Json.createObjectBuilder().add("id", 2))
                .add("electronic", "true").build().toString();
        given().contentType(MediaType.APPLICATION_JSON).body(json2).when().
                post("/lock/").then().assertThat().statusCode(201);

        String json3 = Json.createObjectBuilder().add("producer", Json.createObjectBuilder().add("id", 1))
                .add("electronic", "true").build().toString();
        given().contentType(MediaType.APPLICATION_JSON).body(json3).when().
                post("/lock/").then().assertThat().statusCode(201);

        String json4 = Json.createObjectBuilder().add("producer", Json.createObjectBuilder().add("id", 3))
                .add("electronic", "false").build().toString();
        given().contentType(MediaType.APPLICATION_JSON).body(json4).when().
                post("/lock/").then().assertThat().statusCode(201);

        String json5 = Json.createObjectBuilder().add("producer", Json.createObjectBuilder().add("id", 3))
                .add("electronic", "true").build().toString();
        given().contentType(MediaType.APPLICATION_JSON).body(json5).when().
                post("/lock/").then().assertThat().statusCode(201);
    }

    private void addInsurances() {
        String json1 = Json.createObjectBuilder().add("type", "od ataku niedzwiedzia")
                .add("startDate", "2010-05-20").add("endDate", "2015-11-02").build().toString();
        given().contentType(MediaType.APPLICATION_JSON).body(json1).when().
                post("/insurance/").then().assertThat().statusCode(201);

        String json2 = Json.createObjectBuilder().add("type", "od mrozu")
                .add("startDate", "2010-05-20").add("endDate", "2020-05-20").build().toString();
        given().contentType(MediaType.APPLICATION_JSON).body(json2).when().
                post("/insurance/").then().assertThat().statusCode(201);

        String json3 = Json.createObjectBuilder().add("type", "od wlamania")
                .add("startDate", "2015-11-02").add("endDate", "2020-05-20").build().toString();
        given().contentType(MediaType.APPLICATION_JSON).body(json3).when().
                post("/insurance/").then().assertThat().statusCode(201);
    }

    private void addDoors() {
        String json1 = Json.createObjectBuilder().add("producer", Json.createObjectBuilder().add("id", 1))
                .add("productionDate", "2010-05-20").add("weight", "60")
                .add("exterior", "true").add("description", "drzwi wejsciowo-wyjsciowe")
                .add("price", "5000").add("locks", Json.createArrayBuilder()
                        .add(Json.createObjectBuilder().add("id", 1)).
                                add(Json.createObjectBuilder().add("id", 2)))
                .add("insurances", Json.createArrayBuilder()
                        .add(Json.createObjectBuilder().add("id", 1)).
                                add(Json.createObjectBuilder().add("id", 2))).build().toString();

        given().contentType(MediaType.APPLICATION_JSON).body(json1).when().
                post("/door/").then().assertThat().statusCode(201);

        String json2 = Json.createObjectBuilder().add("producer", Json.createObjectBuilder().add("id", 2))
                .add("productionDate", "2015-07-21").add("weight", "50")
                .add("exterior", "false").add("description", "drzwi prawe")
                .add("price", "3000").add("locks", Json.createArrayBuilder()
                        .add(Json.createObjectBuilder().add("id", 3)))
                .add("insurances", Json.createArrayBuilder()
                        .add(Json.createObjectBuilder().add("id", 2))).build().toString();

        given().contentType(MediaType.APPLICATION_JSON).body(json2).when().
                post("/door/").then().assertThat().statusCode(201);

        String json3 = Json.createObjectBuilder().add("producer", Json.createObjectBuilder().add("id", 2))
                .add("productionDate", "2011-11-12").add("weight", "20")
                .add("exterior", "false").add("description", "drzwi z systemem wte i wewte")
                .add("price", "3000").add("locks", Json.createArrayBuilder()
                        .add(Json.createObjectBuilder().add("id", 4)))
                .add("insurances", Json.createArrayBuilder()
                        .add(Json.createObjectBuilder().add("id", 3))).build().toString();

        given().contentType(MediaType.APPLICATION_JSON).body(json3).when().
                post("/door/").then().assertThat().statusCode(201);

        String json4 = Json.createObjectBuilder().add("producer", Json.createObjectBuilder().add("id", 1))
                .add("productionDate", "2016-05-06").add("weight", "100")
                .add("exterior", "true").add("description", "drzwi pancerne")
                .add("price", "10000").add("locks", Json.createArrayBuilder()
                        .add(Json.createObjectBuilder().add("id", 5)))
                .add("insurances", Json.createArrayBuilder()
                        .add(Json.createObjectBuilder().add("id", 3))).build().toString();

        given().contentType(MediaType.APPLICATION_JSON).body(json4).when().
                post("/door/").then().assertThat().statusCode(201);
    }


}
