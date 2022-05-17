package yandexApiTest;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import static io.restassured.RestAssured.given;

public class TestCase1 {
    @Test
    @Timeout(10)
    public void createFolder(){
        RestAssured.baseURI ="https://cloud-api.yandex.net/v1/disk";
        RequestSpecification request = given();
        JSONObject requestParams = new JSONObject();
        requestParams.put("path","12333");
        request.header("Content-Type", "application/json");
        request.header("Authorization","OAuth AQAAAAA2st_CAADLW5TP1mAo4UEzlb-ppP50raY");
        request.body(requestParams.toString());
        Response response = request.put("/resources");
        int statusCode = response.getStatusCode();
        Assertions.assertEquals(statusCode, 200);
    }

}
