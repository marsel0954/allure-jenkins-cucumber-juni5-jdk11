package tests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static io.restassured.RestAssured.given;

public class RestTest1 {
    @Test
    public void lastTry() {
        RestAssured.baseURI ="http://10.10.15.160:8080/api";
        RequestSpecification request = RestAssured.given();

        JSONObject requestParams = new JSONObject();
        requestParams.put("email","m.gazizov@andersenlab.com");
        requestParams.put("password","9t5JX9nR4pE8");
        request.header("Content-Type", "application/json");
        request.body(requestParams.toString());
        Response response = request.post("/login");
        int statusCode = response.getStatusCode();
        Assertions.assertEquals(statusCode, 200);
        System.out.println("The status code recieved: " + statusCode);
    }

    public void token(){
    }









    @Test
    public void takeToken() {
        RestAssured.baseURI="http://10.10.15.160:8080/api";
        String danjson = "{\n" +
                "  \"email\": \"m.gazizov@andersenlab.com\",\n" +
                "  \"password\": \"9t5JX9nR4pE8\"\n" +
                "}";
        RestAssured.given().body(danjson)
                .post()
                .then()
                .log()
                .all()
                .assertThat()
                .statusCode(201);
    }



    @Test
    public void postToker() {
        String someRandomString = String.format("%1$TH%1$TM%1$TS", new Date());
        JSONObject requestBody = new JSONObject();
        requestBody.put("Login", someRandomString);
        requestBody.put("Password", someRandomString);
        RequestSpecification request = given();
        request.header("Content-Type", "application/json");
        request.body(requestBody.toString());
        Response response = request.post("http://10.10.15.160:8080/api/login");
        int statusCode = response.getStatusCode();
        Assertions.assertEquals(statusCode, 200);
        System.out.println("The status code recieved: " + statusCode);
    }
    @Test
    public void getUsers() {
        given()
                .baseUri("http://10.10.15.160:8080/api")
                .basePath("/users?lang=en&statuses=ACTIVE")
                .contentType(ContentType.JSON)
                .when().get()
                .then().statusCode(401);
    }

}
