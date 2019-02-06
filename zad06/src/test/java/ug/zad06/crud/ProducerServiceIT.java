package ug.zad06.crud;

import com.jayway.restassured.RestAssured;
import org.junit.BeforeClass;
import org.junit.Test;
import ug.zad06.domain.Producer;

import javax.ws.rs.core.MediaType;

import static com.jayway.restassured.RestAssured.delete;
import static com.jayway.restassured.RestAssured.given;

public class ProducerServiceIT {
    @BeforeClass
    public static void setUp(){
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 8080;
        RestAssured.basePath = "/zad06/api";
    }


    @Test
    public void producerCRUDTest() {
        Producer producer = new Producer();
        producer.setName("Porta");

        given().contentType(MediaType.APPLICATION_JSON).body(producer).when().
                post("/producer/").then().assertThat().statusCode(201);

        given().accept(MediaType.APPLICATION_JSON).
                when().get("/producer/id/{producerId}",1).then().assertThat().statusCode(200);

        producer.setName("BRW");

        given().contentType(MediaType.APPLICATION_JSON).body(producer).when().
                put("/producer/").then().assertThat().statusCode(204);

        delete("/producer/").then().assertThat().statusCode(200);
    }
}
