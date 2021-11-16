package crmBack;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Authentication {


    public String tokenAuthROS(){

        RestAssured.baseURI = "http://10.10.15.160:8080/api";
        RequestSpecification request = RestAssured.given();
        String logpass = "{\n" +
                "  \"email\": \"testuser_ros@andersenlab.com\",\n" +
                "  \"password\": \">B/yL4ngv6w8\"\n" +
                "}";
        request.header("Content-Type","application/json");
        Response responseFromGenerateToken = request.body(logpass).post("/login");
        responseFromGenerateToken.prettyPrint();
        String jsonString = responseFromGenerateToken.getBody().asString();
        JsonPath.from(jsonString).get("token");
        String tokenGeneratedROS = JsonPath.from(jsonString).get("token");
        return tokenGeneratedROS;
    }

    public String tokenAuthROSadmin(){

        RestAssured.baseURI = "http://10.10.15.160:8080/api";
        RequestSpecification request = RestAssured.given();
        String logpass = "{\n" +
                "  \"email\": \"huntflow-test-16@andersenlab.com\",\n" +
                "  \"password\": \"159753CFThn\"\n" +
                "}";
        request.header("Content-Type","application/json");
        Response responseFromGenerateToken = request.body(logpass).post("/login");
        responseFromGenerateToken.prettyPrint();
        String jsonString = responseFromGenerateToken.getBody().asString();
        JsonPath.from(jsonString).get("token");
        String tokenGeneratedROSadmin = JsonPath.from(jsonString).get("token");
        return tokenGeneratedROSadmin;
    }
    public String tokenAuthSOS(){

        RestAssured.baseURI = "http://10.10.15.160:8080/api";
        RequestSpecification request = RestAssured.given();
        String logpass = "{\n" +
                "  \"email\": \"testuser_sos@andersenlab.com\",\n" +
                "  \"password\": \"jQr<N)Jv5y`H\"\n" +
                "}";
        request.header("Content-Type","application/json");
        Response responseFromGenerateToken = request.body(logpass).post("/login");
        responseFromGenerateToken.prettyPrint();
        String jsonString = responseFromGenerateToken.getBody().asString();
        JsonPath.from(jsonString).get("token");
        String tokenGeneratedSOS = JsonPath.from(jsonString).get("token");
        return tokenGeneratedSOS;
    }
    public String tokenAuthVP(){

        RestAssured.baseURI = "http://10.10.15.160:8080/api";
        RequestSpecification request = RestAssured.given();
        String logpass = "{\n" +
                "  \"email\": \"testuser_mentor@andersenlab.com\",\n" +
                "  \"password\": \"*5r}CK4tQhJ8\"\n" +
                "}";
        request.header("Content-Type","application/json");
        Response responseFromGenerateToken = request.body(logpass).post("/login");
        responseFromGenerateToken.prettyPrint();
        String jsonString = responseFromGenerateToken.getBody().asString();
        JsonPath.from(jsonString).get("token");
        String tokenGeneratedVP = JsonPath.from(jsonString).get("token");
        return tokenGeneratedVP;
    }



}
