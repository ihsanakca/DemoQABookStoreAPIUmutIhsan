package com.krafttech.services;

import com.krafttech.utilities.ConfigurationReader;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

public class UpdateBooks {
Response response;
    public void updateBook(){
        String body="{\n" +
                "  \"userId\": \""+ ConfigurationReader.get("userID") +"\",\n" +
                "  \"isbn\": \""+ConfigurationReader.get("isbn7")+"\"\n" +
                "}";

        Map<String,Object> tokenMap=new HashMap<>();
        tokenMap.put("Authorization","Bearer "+ ConfigurationReader.get("token"));

        response= RestAssured.given().contentType(ContentType.JSON)
                .pathParam("isbn",ConfigurationReader.get("isbn2"))
                .headers(tokenMap)
                .body(body)
                .when().log().all()
                .put("/BookStore/v1/Books/{isbn}").prettyPeek();
    }

    public void verifyUpdateBookStatus(){
        response.then().statusCode(200);
    }
}
