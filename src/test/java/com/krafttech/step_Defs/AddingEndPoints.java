package com.krafttech.step_Defs;

import com.krafttech.utilities.ConfigurationReader;
import io.cucumber.java.en.When;

public class AddingEndPoints {
    @When("The user should be able to add all endpoints as {string} and {string} and {string} and {string} and {string} and {string} and {string} and {string}")
    public void the_user_should_be_able_to_add_all_endpoints_as_and_and_and_and_and_and_and(String register, String generateToken, String authorized, String getAllBooks,
                                                                                            String addBook, String getUserByID, String updateBook, String deleteBook) {
        ConfigurationReader.set("registerUserEP",register);
        ConfigurationReader.set("generateTokenEP",generateToken);
        ConfigurationReader.set("authorizedEP",authorized);
        ConfigurationReader.set("getAllBooksEP",getAllBooks);
        ConfigurationReader.set("addBookEP",addBook);
        ConfigurationReader.set("getUserByIdEP",getUserByID);
        ConfigurationReader.set("updateBookEP",updateBook);
        ConfigurationReader.set("deleteBookEP",deleteBook);
    }
}
