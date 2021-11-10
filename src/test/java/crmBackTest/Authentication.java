package crmBackTest;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.Test;

public class Authentication {
    public void authenticationUser(){}

    @Test
    public void bearerTokenAuthentication(){

        RestAssured.baseURI = "http://10.10.15.160:8080/api";
        RequestSpecification request = RestAssured.given();
        String logpass = "{\n" +
                "  \"email\": \"m.gazizov@andersenlab.com\",\n" +
                "  \"password\": \"9t5JX9nR4pE8\"\n" +
                "}";
        request.header("Content-Type","application/json");

        Response responseFromGenerateToken = request.body(logpass).post("/login");

        responseFromGenerateToken.prettyPrint();

        String jsonString = responseFromGenerateToken.getBody().asString();

        JsonPath.from(jsonString).get("token");

        String tokenGenerated = JsonPath.from(jsonString).get("token");

        request.header("Autorization","CRM_HA "+tokenGenerated)
                .header("Content-Type","application/json");

    }


}
