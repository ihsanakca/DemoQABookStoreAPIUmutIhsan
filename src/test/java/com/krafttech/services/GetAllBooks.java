package com.krafttech.services;

import com.krafttech.utilities.ConfigurationReader;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

public class GetAllBooks {
Response response;
    public void bookList(){
        Map<String,Object> tokenMap=new HashMap<>();
        tokenMap.put("Authorization","Bearer "+ ConfigurationReader.get("token"));

        response=RestAssured.given()
                .contentType(ContentType.JSON)
                .headers(tokenMap)
                .when().log().all()
                .get("/BookStore/v1/Books").prettyPeek();

//        ConfigurationReader.set("isbn1",response.path("books[0].isbn"));
//        ConfigurationReader.set("isbn2",response.path("books[1].isbn"));
//        ConfigurationReader.set("isbn3",response.path("books[2].isbn"));
//        ConfigurationReader.set("isbn4",response.path("books[3].isbn"));
//        ConfigurationReader.set("isbn5",response.path("books[4].isbn"));
//        ConfigurationReader.set("isbn6",response.path("books[5].isbn"));
//        ConfigurationReader.set("isbn7",response.path("books[6].isbn"));
//        ConfigurationReader.set("isbn8",response.path("books[7].isbn"));

        for (int i = 0; i < 8; i++) {
            ConfigurationReader.set("isbn"+(i+1)+"",response.path("books["+i+"].isbn"));
        }

    }


    public void verifyBookList(){
        response.then().statusCode(200);
    }
}
