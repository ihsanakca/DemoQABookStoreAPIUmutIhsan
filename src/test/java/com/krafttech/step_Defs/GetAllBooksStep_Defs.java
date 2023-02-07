package com.krafttech.step_Defs;

import com.krafttech.services.GetAllBooks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class GetAllBooksStep_Defs {
    GetAllBooks getAllBooks = new GetAllBooks();

    @Given("User should see book list")
    public void user_should_see_book_list() {
        getAllBooks.bookList();
    }

    @Then("User verify the booksStatusCode")
    public void user_verify_the_booksStatusCode() {
        getAllBooks.verifyBookList();
    }

}
