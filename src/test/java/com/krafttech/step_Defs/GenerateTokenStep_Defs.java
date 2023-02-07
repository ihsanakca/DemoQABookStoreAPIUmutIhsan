package com.krafttech.step_Defs;

import com.krafttech.services.GenerateToken;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class GenerateTokenStep_Defs {
GenerateToken generateToken=new GenerateToken();
    @Given("input valid credentials")
    public void input_valid_credentials() {
        generateToken.generateToken();
    }
    @Then("verify tokenStatusCode")
    public void verify_tokenStatusCode() {
       generateToken.verifyGenerateTokenStatusCode();
    }
}