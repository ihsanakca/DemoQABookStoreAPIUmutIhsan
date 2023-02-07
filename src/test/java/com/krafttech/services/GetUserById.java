package com.krafttech.services;

import com.krafttech.utilities.ConfigurationReader;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

public class GetUserById {

    Response response;
    public void getUser(){
        Map<String,Object> tokenMap=new HashMap<>();
        tokenMap.put("Authorization","Bearer "+ ConfigurationReader.get("token"));

        response= RestAssured.given().contentType(ContentType.JSON)
                .pathParam("id",ConfigurationReader.get("userID"))
                .headers(tokenMap)
                .when().log().all()
                .get("/Account/v1/User/{id}").prettyPeek();
    }
    public void verifyUserById(){
        response.then().statusCode(200);
    }
}
