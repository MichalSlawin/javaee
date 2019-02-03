package ug.zad06;

import static com.jayway.restassured.RestAssured.*;
import javax.ws.rs.core.MediaType;

import org.junit.BeforeClass;
import org.junit.Test;

import ug.zad06.domain.Door;
import com.jayway.restassured.RestAssured;

import java.text.DateFormat;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DoorServiceIT {

	private static final ParsePosition PARSE_POSITION = new ParsePosition(0);
	private static final DateFormat parser = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
	private static final Date DATE1 = parser.parse( "2010-05-20", PARSE_POSITION);
	
	@BeforeClass
	public static void setUp(){
		RestAssured.baseURI = "http://localhost";
		RestAssured.port = 8080;
		RestAssured.basePath = "/zad06/api";
	}

	
	@Test
	public void addDoor() {
		Door door = new Door();
		door.setProductionDate(DATE1);
		door.setWeight(80.0);
		door.setDescription("dobre drzwi");

		given().
	       contentType(MediaType.APPLICATION_JSON).
	       body(door).
	    when().
	    post("/door/").then().log().all().assertThat().statusCode(201);

		given().log().all().
				accept(MediaType.APPLICATION_JSON).
		when().get("/door/id/{doorId}",1).then().assertThat().statusCode(200);

		delete("/door/").then().assertThat().statusCode(200);
	}	

}
