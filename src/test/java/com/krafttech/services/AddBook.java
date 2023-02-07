package com.krafttech.services;

import com.krafttech.utilities.ConfigurationReader;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

public class AddBook {
    Response response;

    public void addBooks(){
        Map<String,Object> tokenMap=new HashMap<>();
        tokenMap.put("Authorization","Bearer "+ ConfigurationReader.get("token"));

        String body="{\n" +
                "  \"userId\": \""+ ConfigurationReader.get("userID") +"\",\n" +
                "  \"collectionOfIsbns\": [\n" +
                "    {\n" +
                "      \"isbn\": \""+ConfigurationReader.get("isbn2")+"\"\n" +
                "    }\n" +
                "  ]\n" +
                "}";

        response= RestAssured.given().contentType(ContentType.JSON)
                .headers(tokenMap)
                .body(body)
                .when().log().all()
                .post("/BookStore/v1/Books").prettyPeek();
    }

    public void verifyAddBooks(){
        response.then().statusCode(201);
    }
}
