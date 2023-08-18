package com.example.testescomrestassured;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;


class TestesComRestAssuredApplicationTests {

    @Test
    void helloWorldRestAssured() {
        Response response = RestAssured.request(Method.GET, "https://restapi.wcaquino.me/ola");
        System.out.println(response.asString());
    }

}
