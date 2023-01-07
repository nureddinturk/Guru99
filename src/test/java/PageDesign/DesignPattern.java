package PageDesign;

import PageObjects.CustomerPage;
import PageObjects.LoginPage;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class DesignPattern {

    WebDriver driver;
    PageDriver pageDriver = new PageDriver();


    public DesignPattern() throws IOException {
        this.driver = pageDriver.getDriver();
    }
    public LoginPage loginPage;

    public LoginPage getLoginPage() {
        this.driver = driver;
        return loginPage = new LoginPage(driver);
    }

    public CustomerPage customerPage;

    public CustomerPage getCustomerPage() {
        this.driver = driver;
        return customerPage = new CustomerPage(driver);
    }

}
