package com.krafttech.step_Defs;

import com.krafttech.services.Authorized;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class AuthorizedStep_Defs {
    Authorized authorized = new Authorized();

    @Given("User should be authorized with valid credentials")
    public void user_should_be_authorized_with_valid_credentials() {
        authorized.userAuthorized();
    }

    @Then("verify authorizedStatusCode")
    public void verify_authorizedStatusCode() {
        authorized.verifyAuthorizedStatusCode();
    }

}
