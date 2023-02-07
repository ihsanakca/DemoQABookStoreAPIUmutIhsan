package com.krafttech.step_Defs;

import com.krafttech.services.DeleteBook;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class DeleteBookStep_Defs {
    DeleteBook deleteBook = new DeleteBook();

    @Given("User should delete a book")
    public void user_should_delete_a_book() {
        deleteBook.deleteABook();
    }

    @Then("User should verify deleteStatusCode")
    public void user_should_verify_deleteStatusCode() {
        deleteBook.verifyDelete();
    }

}
