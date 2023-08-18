package com.example.testescomrestassured.exercícios;

import static io.restassured.RestAssured.*;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertEquals;

public class OlaMundoTeste {

    @Test
    public void testeOlaMundo(){
        Response response = request(Method.GET, "https://restapi.wcaquino.me/ola");
        Assert.assertTrue(response.getBody().asString().equals("Ola Mundo!"));
        Assert.assertTrue(response.getStatusCode() == 200);
        assertEquals( 200, response.getStatusCode());

        ValidatableResponse validacao = response.then().log().all();
        validacao.statusCode(200);
    }

    @Test
    public void devoConhecerOutrasFormasRestAssured(){
        Response response = request(Method.GET, "https://restapi.wcaquino.me/ola");
        ValidatableResponse validacao = response.then().log().all();
        validacao.statusCode(200);

        get("https://restapi.wcaquino.me/ola").then().statusCode(200);

        given()
                //pré condições
        .when() //ações
                .get("https://restapi.wcaquino.me/ola")
        .then() //assertivas - validações
                .statusCode(200);
    }

    @Test
    public void devoConhecerMatchersHamcrest(){
        Assert.assertThat("Maria", Matchers.is("Maria"));
        Assert.assertThat(128, Matchers.is(128));
        Assert.assertThat(128, Matchers.isA(Integer.class));
        Assert.assertThat(128, Matchers.greaterThan(120));
        Assert.assertThat(128, Matchers.lessThan(130));

        List<Integer> impares = Arrays.asList(1,3,5,7,9);
        Assert.assertThat(impares, hasSize(5));
        assertThat(impares, hasSize(5));
    }
}
