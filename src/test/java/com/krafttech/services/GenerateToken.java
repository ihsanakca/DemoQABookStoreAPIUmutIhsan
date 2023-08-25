package com.krafttech.services;

import com.krafttech.utilities.ConfigurationReader;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

public class GenerateToken {
    Response response;

    public String token;

    public void generateToken(){
        /*
        {
  "userName": "string",
  "password": "string"
}
         */

        String password= ConfigurationReader.get("commonPassword");
        String userName=ConfigurationReader.get("username");

        Map<String ,Object> body=new HashMap<>();
        body.put("userName",userName);
        body.put("password",password);

        response= RestAssured.given().contentType(ContentType.JSON)
                .body(body).log().all()
                .when()
                .post("/Account/v1/GenerateToken").prettyPeek();

        token=response.path("token");
        System.out.println("token = " + token);
        ConfigurationReader.set("token",token);
    }

    public void verifyGenerateTokenStatusCode(){
        response.then().statusCode(200);
    }
}
