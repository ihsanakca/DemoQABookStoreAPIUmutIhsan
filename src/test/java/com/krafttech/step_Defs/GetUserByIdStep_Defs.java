package com.krafttech.step_Defs;

import com.krafttech.services.GetUserById;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class GetUserByIdStep_Defs {
    GetUserById getUserById = new GetUserById();

    @Given("User should see the book list")
    public void user_should_see_the_book_list() {
        getUserById.getUser();
    }

    @Then("User should verfiy the BookStatusCode")
    public void user_should_verfiy_the_BookStatusCode() {
        getUserById.verifyUserById();
    }

}
