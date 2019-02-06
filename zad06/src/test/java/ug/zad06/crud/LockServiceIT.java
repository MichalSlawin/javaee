package ug.zad06.crud;

import com.jayway.restassured.RestAssured;
import org.junit.BeforeClass;
import org.junit.Test;
import ug.zad06.domain.Lock;

import javax.ws.rs.core.MediaType;

import static com.jayway.restassured.RestAssured.delete;
import static com.jayway.restassured.RestAssured.given;

public class LockServiceIT {
    @BeforeClass
    public static void setUp(){
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 8080;
        RestAssured.basePath = "/zad06/api";
    }


    @Test
    public void lockCRUDTest() {
        Lock lock = new Lock();
        lock.setElectronic(true);
        lock.setProducer(null);

        given().contentType(MediaType.APPLICATION_JSON).body(lock).when().
                post("/lock/").then().assertThat().statusCode(201);

        given().accept(MediaType.APPLICATION_JSON).
                when().get("/lock/id/{id}",1).then().assertThat().statusCode(200);

        lock.setElectronic(false);

        given().contentType(MediaType.APPLICATION_JSON).body(lock).when().
                put("/lock/").then().assertThat().statusCode(204);

        delete("/lock/").then().assertThat().statusCode(200);
    }
}
