package com.example.testescomrestassured.exercícios;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.junit.jupiter.api.Test;

class TestesComRestAssuredApplicationTests {

    @Test
    void helloWorldRestAssured() {
        Response response = RestAssured.request(Method.GET, "https://restapi.wcaquino.me/ola");
        System.out.println(response.getBody().asString().equals("Ola Mundo!")); //equals retorna true ou false

        ValidatableResponse validacao = response.then();
        validacao.statusCode(200);
    }

}
