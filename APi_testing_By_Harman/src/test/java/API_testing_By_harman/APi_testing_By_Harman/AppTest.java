package API_testing_By_harman.APi_testing_By_Harman;
import static io.restassured.RestAssured.given;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.RestAssured.*;

import io.restassured.matcher.RestAssuredMatchers.*;
import io.restassured.response.Response;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.hamcrest.Matchers.*;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void aTestTOCheckStatusCode()
    {
    	given()
        .when().get("http://localhost:8080/game?name=")
        .then().statusCode(200);
    	
    }
    
    @Test
    public void bTestTOCheckresponse() throws FileNotFoundException, IOException, ParseException
    {
    	String response = given()
                .when().get("http://localhost:8080/game?name=")
                .then().extract().asString();
		//System.out.println(response );

   ObjectMapper objectMapper = new ObjectMapper();

// parse the JSON response into a GameResponse object
GameResponse gameResponse = objectMapper.readValue(response, GameResponse.class);

// use the GameResponse object to access the response properties
int id = gameResponse.getId();
String textResponse = gameResponse.getText();

//System.out.println(id);
//System.out.println(textResponse);


// Getting value from the JSON file

JSONParser parser = new JSONParser();
Object obj = parser.parse(new FileReader("Schema.json"));

JSONObject jsonObject = (JSONObject) obj;

String name = (String) jsonObject.get("text");


//System.out.println("Name: " + name);

//Assserttion to check the response 
assertEquals(name,textResponse );
    	
    }
    
    
}
