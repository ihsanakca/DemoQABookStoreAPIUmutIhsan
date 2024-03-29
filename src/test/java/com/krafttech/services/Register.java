package com.krafttech.services;

import com.github.javafaker.Faker;
import com.krafttech.utilities.ConfigurationReader;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Register {

    Response response;
    Faker faker = new Faker();
    public String userName;
    public String userID;

    public void userRegister() {
        String password = ConfigurationReader.get("commonPassword");
        userName = faker.name().fullName();

       /*
       {
  "userName": "ddddddddd",
  "password": "ddddddddd"
        }
        */

        Map<String, Object> body = new HashMap<>();
        body.put("userName", userName);
        body.put("password", password);

        response = RestAssured.given().contentType(ContentType.JSON)
                .body(body).log().all()
                .when()
                .post("/Account/v1/User").prettyPeek();

        userID = response.path("userID");
        System.out.println("userID = " + userID);
        System.out.println("response.path(\"username\") = " + response.path("username"));
        ConfigurationReader.set("username",response.path("username"));
        ConfigurationReader.set("userID",response.path("userID"));

    }
    public void verifyRegisterStatusCode(){
        response.then().statusCode(201);
    }


}
