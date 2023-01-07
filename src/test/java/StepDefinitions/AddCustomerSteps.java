package StepDefinitions;

import PageDesign.DesignPattern;
import PageObjects.CustomerPage;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;

import java.io.FileNotFoundException;
import java.io.IOException;

public class AddCustomerSteps {

    public WebDriver driver;
    public DesignPattern designPattern;
    public CustomerPage customerPage;

    public AddCustomerSteps(DesignPattern designPattern) throws IOException {
        this.designPattern = designPattern;
        this.customerPage = designPattern.getCustomerPage();
    }
    @When("user clicks on new customer button")
    public void user_clicks_on_new_customer_button() {
customerPage.goToNewCustomerPage();
    }

    @Then("verify that user is on New Customer Entry Page")
    public void verify_that_user_is_on_new_customer_entry_page() {
        customerPage.verifyCustomerPage();
    }

    @When("user enters new customer info")
    public void user_enters_new_customer_info() throws FileNotFoundException {
       customerPage.enterCustomerInfo();
    }
    @Then("new customer is added successfully")
    public void new_customer_is_added_successfully() throws InterruptedException {
       customerPage.verifyNewCustomer();
    }
}
