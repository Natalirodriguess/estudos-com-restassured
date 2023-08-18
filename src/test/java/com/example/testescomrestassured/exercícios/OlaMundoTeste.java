package com.example.testescomrestassured.exercícios;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class OlaMundoTeste {

    @Test
    public void testeOlaMundo(){
        Response response = RestAssured.request(Method.GET, "https://restapi.wcaquino.me/ola");
        Assert.assertTrue(response.getBody().asString().equals("Ola Mundo!"));
        Assert.assertTrue(response.getStatusCode() == 200);
        assertEquals( 200, response.getStatusCode());

        ValidatableResponse validacao = response.then().log().all();
        validacao.statusCode(200);
    }

    @Test
    public void devoConhecerOutrasFormasRestAssured(){
        Response response = RestAssured.request(Method.GET, "https://restapi.wcaquino.me/ola");
        ValidatableResponse validacao = response.then().log().all();
        validacao.statusCode(200);

        RestAssured.get("https://restapi.wcaquino.me/ola").then().statusCode(200);
    }
}
