package com.example.testescomrestassured.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features", // Caminho para as features
        glue = "com.example.testescomrestassured.steps",// Pacote onde estão definidos os steps
        dryRun = false
)
public class Runner {

}
