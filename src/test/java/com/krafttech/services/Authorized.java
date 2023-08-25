package com.krafttech.services;

import com.krafttech.utilities.ConfigurationReader;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;


import java.util.HashMap;
import java.util.Map;

public class Authorized {

    Response response;

    public void userAuthorized(){
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

        Map<String,Object> tokenMap=new HashMap<>();
        tokenMap.put("Authorization","Bearer "+ConfigurationReader.get("token"));

        response= RestAssured.given().contentType(ContentType.JSON)
                .headers(tokenMap)
                .body(body)
                .when().log().all()
                .post("/Account/v1/Authorized").prettyPeek();
    }

    public void verifyAuthorizedStatusCode(){
        response.then().statusCode(200);
    }
}


