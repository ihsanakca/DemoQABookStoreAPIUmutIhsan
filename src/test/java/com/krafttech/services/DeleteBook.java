package com.krafttech.services;

import com.krafttech.utilities.ConfigurationReader;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;


public class DeleteBook {
    Response response;

    public void deleteABook(){

        String body="{\n" +
                "  \"isbn\": \""+ ConfigurationReader.get("isbn7") +"\",\n" +
                "  \"userId\": \""+ConfigurationReader.get("userID")+"\"\n" +
                "}";

        Map<String,Object> tokenMap=new HashMap<>();
        tokenMap.put("Authorization","Bearer "+ ConfigurationReader.get("token"));

        response= RestAssured.given().contentType(ContentType.JSON)
                .headers(tokenMap)
                .body(body)
                .when().log().all()
                .delete("/BookStore/v1/Book").prettyPeek();
    }

    public void verifyDelete(){
        response.then().statusCode(204);
    }
}
