package crmBackTest;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class UserController {

    RequestSpecification requestSpec = new RequestSpecBuilder()
            .setBaseUri("http://10.10.15.160:8080/api")
            .setBasePath("/users")
            .setContentType(ContentType.JSON)
            .log(LogDetail.ALL)
            .build();

    ResponseSpecification responseSpecGet = new ResponseSpecBuilder()
            .expectStatusCode(200)
            .log(LogDetail.STATUS)
            .build();

    private static String requestBody = "{\n" +
            "  \"firstNameRu\": \"Иванds\" \n}";
    private static String requestBodyPut = "{\n" +
            "  \"firstNameRu\": \"Марта\",\n" +
            "  \"lastNameRu\": \"Винцкевич\",\n" +
            "  \"firstNameEn\": \"Marta\",\n" +
            "  \"lastNameEn\": \"vintskevich\",\n" +
            "  \"birthday\": \"1988-12-14\",\n" +
            "  \"skype\": \"sfff\",\n" +
            "  \"email\": \"m.vintskevich@andersenlab.com\",\n" +
            "  \"phone\": \"222\",\n" +
            "  \"status\": \"ACTIVE\",\n" +
            "  \"roleId\": 1004,\n" +
            "  \"officeId\": 1,\n" +
            "  \"trainingGroupIds\": [\n" +
            "    1\n" +
            "  ],\n" +
            "  \"trainingIds\": [\n" +
            "    1\n" +
            "  ],\n" +
            "  \"visibility\": true\n" +
            "}";



    public String bearerTokenAuthentication() {

        RestAssured.baseURI = "http://10.10.15.160:8080/api";
        RequestSpecification request = RestAssured.given();
        String logpass = "{\n" +
                "  \"email\": \"m.gazizov@andersenlab.com\",\n" +
                "  \"password\": \"9t5JX9nR4pE8\"\n" +
                "}";
        request.header("Content-Type", "application/json");

        Response responseFromGenerateToken = request.body(logpass).post("/login");

        responseFromGenerateToken.prettyPrint();

        String jsonString = responseFromGenerateToken.getBody().asString();

        JsonPath.from(jsonString).get("token");

        String tokenGenerated = JsonPath.from(jsonString).get("token");
        return tokenGenerated;

    }

    @Test
    public void getAllActiveUsers(){
        given()
                .log().all()
                .baseUri("http://10.10.15.160:8080/api")
                .basePath("/users")
                .header("Content-Type","application/json")
                .header("Authorization","CRM_HA " + bearerTokenAuthentication() )
                .param("lang","en")
                .param("statuses","ACTIVE")
                .when()
                .get()
                .then()
                .log().status()
                .statusCode(200);
    }
    @Test
    public void getAllActiveUsersWithSpecification() {
        given()
                .spec(requestSpec)
                .header("Authorization","CRM_HA " + bearerTokenAuthentication() )
                .param("lang","en")
                .param("statuses","ACTIVE")
                .when()
                .get()
                .then()
                .spec(responseSpecGet);
    }
    @DisplayName("Получение данных о всех удаленных пользователях")
    @Test
    public void getAllRemovedUsers(){
        given()
                .log().all()
                .baseUri("http://10.10.15.160:8080/api")
                .basePath("/users")
                .header("Content-Type","application/json")
                .header("Authorization","CRM_HA " + bearerTokenAuthentication() )
                .param("lang","en")
                .param("statuses","REMOVED")
                .when().get()
                .then().log().status()
                .statusCode(200);
    }
    @Test
    public void putUserRos() {
        given()
                .log().all()
                .baseUri("http://10.10.15.160:8080/api")
                .basePath("/users/70014")
                .header("Content-Type", "application/json")
                .header("Authorization","CRM_HA " + bearerTokenAuthentication() )
                /*.param("id", "70014")*/
                .body(requestBodyPut)
                .when().put()
                .then().log().status()
                .statusCode(200);
    }
    @Test
    public void putUserRos2() {
        given()
                .log().all()
                .baseUri("http://10.10.15.160:8080/api/")
                .basePath("/users/70014")
                .header("Content-Type", "application/json")
                .header("Authorization","CRM_HA " + bearerTokenAuthentication() )
                .body(requestBodyPut)
                .when().put()
                .then().log().status()
                .statusCode(200);
    }

    @Test
    public void postCreateUser() {
        given()
                .log().all()
                .baseUri("http://10.10.15.160:8080/api")
                .basePath("/users")
                .header("Content-Type", "application/json")
                .header("Authorization","CRM_HA " + bearerTokenAuthentication())
                .contentType(ContentType.JSON)
                .body(requestBodyPut)
                .when().post()
                .then().log().status()
                .statusCode(200);
    }
}
