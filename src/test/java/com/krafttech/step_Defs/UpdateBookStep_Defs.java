package com.krafttech.step_Defs;

import com.krafttech.services.UpdateBooks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class UpdateBookStep_Defs {
UpdateBooks updateBooks=new UpdateBooks();
    @Given("User should update the collection")
    public void user_should_update_the_collection() {
        updateBooks.updateBook();
    }

    @Then("User should verify the updateStatus Code")
    public void user_should_verify_the_updateStatus_Code() {
        updateBooks.verifyUpdateBookStatus();
    }

}
