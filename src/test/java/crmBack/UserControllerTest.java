package crmBack;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class UserControllerTest extends Authentication {

    RequestSpecification requestSpec = new RequestSpecBuilder()
            .setBaseUri("http://10.10.15.160:8080/api")
            .addHeader("Content-Type","application/json")
            .setContentType(ContentType.JSON)
            .log(LogDetail.ALL)
            .build();

    ResponseSpecification responseSpecGet = new ResponseSpecBuilder()
            .expectStatusCode(200)
            .log(LogDetail.STATUS)
            .build();

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



    @Test
    public void getAllActiveUsersByROS() {
        given()
                .spec(requestSpec)
                .basePath("/users")
                .header("Authorization","CRM_HA " + tokenAuthROS())
                .param("lang","en")
                .param("statuses","ACTIVE")
                .when().get()
                .then()
                .spec(responseSpecGet);
    }
    @DisplayName("Получение данных о всех удаленных пользователях")
    @Test
    public void getAllRemovedUsersByROS(){
        given()
                .spec(requestSpec)
                .basePath("/users")
                .header("Authorization","CRM_HA " + tokenAuthROS())
                .param("lang","en")
                .param("statuses","REMOVED")
                .when().get()
                .then().log().status()
                .statusCode(200);
    }
    @Test
    public void putUserByROS() {
        given()
                .spec(requestSpec)
                .basePath("/users/70014")
                .header("Authorization","CRM_HA " + tokenAuthROS())
                .body(requestBodyPut)
                .when().put()
                .then().log().status()
                .statusCode(200);
    }

    @Test
    public void postCreateUserByROS() {
        given()
                .spec(requestSpec)
                .basePath("/users")
                .header("Authorization","CRM_HA " + tokenAuthROS())
                .body(requestBodyPut)
                .when().post()
                .then().log().status()
                .statusCode(200);
    }
    @Test
    public void deleteUserByROS(){
        given()
                .spec(requestSpec)
                .basePath("/users")
                .header("Authorization","CRM_HA " + tokenAuthROS())
                .param("lang","en")
                .param("statuses","REMOVED")
                .when().get()
                .then().log().status()
                .statusCode(200);
    }
    public void restoreStatusByROS(){
        given()
                .spec(requestSpec)
                .basePath("/users/70014")
                .header("Authorization","CRM_HA " + tokenAuthROS())
                .body(requestBodyPut)
                .when().put()
                .then().log().status()
                .statusCode(200);
    }
    @Test
    public void getAllExternalUsersByROS(){
        given()
                .spec(requestSpec)
                .basePath("/users/external?=")
                .header("Authorization","CRM_HA " + tokenAuthROS())
                .param("lang","en")
                .when().get()
                .then().log().status()
                .statusCode(200);
    }
    @Test
    public void getAllExternalUsersByROSadmin(){
        given()
                .spec(requestSpec)
                .basePath("/users/external?=")
                .header("Authorization","CRM_HA " + tokenAuthROSadmin())
                .param("lang","en")
                .when().get()
                .then().log().status()
                .statusCode(200);
    }

}
