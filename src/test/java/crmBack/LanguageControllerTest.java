//package crmBack;
//
//import io.restassured.builder.RequestSpecBuilder;
//import io.restassured.builder.ResponseSpecBuilder;
//import io.restassured.filter.log.LogDetail;
//import io.restassured.http.ContentType;
//import io.restassured.specification.RequestSpecification;
//import io.restassured.specification.ResponseSpecification;
//import org.junit.Ignore;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.Timeout;
//
//import static io.restassured.RestAssured.given;
//
//public class LanguageControllerTest extends Authentication {
//
//    RequestSpecification requestSpec = new RequestSpecBuilder()
//            .setBaseUri("http://10.10.15.160:8080/api")
//            .setBasePath("/language")
//            .setContentType(ContentType.JSON)
//            .addHeader("Content-Type","application/json")
//            .log(LogDetail.ALL)
//            .build();
//
//    ResponseSpecification responseSpec = new ResponseSpecBuilder()
//            .expectStatusCode(200)
//            .log(LogDetail.STATUS)
//            .build();
//
//    @Test
//    @Timeout(10)
//    @Ignore
//
//
//    public void getAllLanguageByROSadmin() {
//        given()
//                .spec(requestSpec)
//                .basePath("/language")
//                .header("Authorization","CRM_HA " + tokenAuthROSadmin())
//                .when().get()
//                .then()
//                .spec(responseSpec);
//    }
//   /* @Test
//    public void getAllLanguageByROSadminWithOutSpec(){
//        given()
//                .baseUri()
//                .basePath()
//                .header()
//                .header()
//                .when().get()
//                .then()
//                .statusCode(200);
//    }*/
//    @Test
//    @Timeout(10)
//    @Ignore
//
//
//    public void getAllLanguageByROS() {
//        given()
//                .spec(requestSpec)
//                .header("Authorization","CRM_HA " + tokenAuthROS())
//                .param("lang", "en")
//                .when().get()
//                .then()
//                .spec(responseSpec);
//    }
//
//    @Test
//    @Timeout(10)
//    @Ignore
//
//
//    public void getAllLanguageBySOS() {
//        given()
//                .spec(requestSpec)
//                .header("Authorization","CRM_HA " + tokenAuthSOS())
//                .param("lang", "en")
//                .when().get()
//                .then()
//                .spec(responseSpec);
//    }
//
//    @Test
//    @Timeout(10)
//    @Ignore
//
//
//    public void getAllLanguageByVP() {
//        given()
//                .spec(requestSpec)
//                .header("Authorization","CRM_HA " + tokenAuthVP())
//                .param("lang", "en")
//                .when().get()
//                .then()
//                .spec(responseSpec);
//    }
//
//    @Test
//    @Timeout(10)
//    @Ignore
//
//
//    public void putLanguageByROSadmin() {
//        given()
//                .spec(requestSpec)
//                .header("Authorization","CRM_HA " + tokenAuthROSadmin())
//                .param("lang", "en")
//                .when().get()
//                .then()
//                .spec(responseSpec);
//    }
//
//    @Test
//    @Timeout(10)
//    @Ignore
//
//
//    public void putLanguageByROS() {
//        given()
//                .spec(requestSpec)
//                .header("Authorization","CRM_HA " + tokenAuthROS())
//                .param("lang", "en")
//                .when().put()
//                .then()
//                .spec(responseSpec);
//    }
//
//    @Test
//    @Timeout(10)
//    @Ignore
//
//
//    public void putLanguageBySOS() {
//        given()
//                .spec(requestSpec)
//                 .header("Authorization","CRM_HA " + tokenAuthSOS())
//                .param("lang", "en")
//                .when().put()
//                .then()
//                .spec(responseSpec);
//    }
//
//    @Test
//    @Timeout(10)
//    @Ignore
//
//
//    public void putLanguageByVP() {
//        given()
//                .spec(requestSpec)
//                .header("Authorization","CRM_HA " + tokenAuthVP())
//                .param("lang", "en")
//                .when().put()
//                .then()
//                .spec(responseSpec);
//    }
//
//}
