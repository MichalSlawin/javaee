package ug.zad06.crud;

import com.jayway.restassured.RestAssured;
import org.junit.BeforeClass;
import org.junit.Test;
import ug.zad06.domain.Insurance;

import javax.ws.rs.core.MediaType;
import java.text.DateFormat;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import static com.jayway.restassured.RestAssured.delete;
import static com.jayway.restassured.RestAssured.given;

public class InsuranceServiceIT {
    private static final ParsePosition PARSE_POSITION = new ParsePosition(0);
    private static final DateFormat parser = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
    private static final Date DATE1 = parser.parse( "2010-05-20", PARSE_POSITION);
    private static final Date DATE2 = parser.parse( "2015-11-02", PARSE_POSITION);
    private static final Date DATE3 = parser.parse( "2020-05-20", PARSE_POSITION);

    @BeforeClass
    public static void setUp(){
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 8080;
        RestAssured.basePath = "/zad06/api";
    }


    @Test
    public void insuranceCRUDTest() {
        Insurance insurance = new Insurance();
        insurance.setStartDate(DATE1);
        insurance.setEndDate(DATE2);
        insurance.setType("na wypadek huraganu");

        given().contentType(MediaType.APPLICATION_JSON).body(insurance).when().
                post("/insurance/").then().assertThat().statusCode(201);

        given().accept(MediaType.APPLICATION_JSON).
                when().get("/insurance/id/{insuranceId}",1).then().assertThat().statusCode(200);

        insurance.setEndDate(DATE3);

        given().contentType(MediaType.APPLICATION_JSON).body(insurance).when().
                put("/insurance/").then().assertThat().statusCode(204);

        delete("/insurance/").then().assertThat().statusCode(200);
    }
}
