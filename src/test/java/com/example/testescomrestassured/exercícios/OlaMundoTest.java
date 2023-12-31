package com.example.testescomrestassured.exercícios;

import static io.restassured.RestAssured.*;

import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertEquals;

public class OlaMundoTest {

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
        assertThat(impares, contains(1,3,5,7,9));
        assertThat(impares, containsInAnyOrder(3,1,9,5,7));
        assertThat(impares, hasItem(7));
        assertThat(impares, hasItems(7,9));

        assertThat("Maria", is(not("João")));
        assertThat("Maria", anyOf(is("Maria"), is("Joaquina")));
        assertThat("Joaquina", allOf(startsWith("Joa"), endsWith("ina"), containsString("qui")));

    }

    @Test
    public void devoValidarBody(){
        given()
        .when()
            .get("https://restapi.wcaquino.me/ola")
        .then()
            .statusCode(200)
            .body(is("Ola Mundo!"))
            .body(containsString("Mundo"))
            .body(is(not(nullValue())));
    }

}
