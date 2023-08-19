package com.example.testescomrestassured.steps;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BuscarMensagemSteps {
    Response response;


    @Quando("que realizo a requisicao de buscar  mensagem")
    public void que_realizo_a_requisicao_de_buscar_mensagem() {
        response = RestAssured.request(Method.GET, "https://restapi.wcaquino.me/ola");
    }
    @Entao("o httpStatus deve ser {int}")
    public void o_http_status_deve_ser(Integer int1) {
       assertEquals(response.getStatusCode(), int1);
    }
    @E("a mensagem deve ser {string}")
    public void a_mensagem_deve_ser(String string) {
        assertEquals("Ola Mundo!", response.getBody().asString());
    }
}
