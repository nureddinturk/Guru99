package StepDefinitions;

import PageDesign.DesignPattern;
import PageObjects.LoginPage;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class LoginSteps {

    public WebDriver driver;
    public DesignPattern designPattern;
    public LoginPage loginPage;

    public LoginSteps(DesignPattern designPattern) throws IOException {
        this.designPattern = designPattern;
        this.loginPage = designPattern.getLoginPage();
    }
    @Given("user is on landing page")
    public void user_is_on_landing_page() throws IOException {
       loginPage.landing();
    }
    @And ("login page is successfully uploaded")
    public void login_page_is_successfully_uploaded() {
       loginPage.verifyLanding();
    }
    @When("^user enters (.+) and (.+)$")
    public void user_enters_username_and_password(String username, String pass) throws InterruptedException {
        loginPage.login(username, pass);
    }
    @Then("landing page is populated")
    public void landing_page_is_populated() {
        loginPage.verifyLogin();
    }

}
