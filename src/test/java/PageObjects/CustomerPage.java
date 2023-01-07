package PageObjects;

import com.github.javafaker.Faker;
import io.cucumber.java.en.*;
import io.restassured.path.json.JsonPath;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class CustomerPage {
    WebDriver driver;


    public CustomerPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    @FindBy(partialLinkText = "New Customer")
    private WebElement newCustomer;

    @FindBy(xpath = "//input[contains(@name,'name')]")
    private WebElement name;

    @FindBy(xpath = "//input[@name='rad1'][1]")
    private WebElement male;

    @FindBy(xpath = "//input[@name='rad1'][1]//following-sibling::input[1]")
    private WebElement female;

    @FindBy(xpath = "//textarea[@name='addr']")
    private WebElement address;

    @FindBy(xpath = "//input[contains(@name,'city')]")
    private WebElement city;

    @FindBy(css = "input[name='state']")
    private WebElement state;

    @FindBy(css = "input[name='telephoneno']")
    private WebElement phoneNumber;

    @FindBy(name = "pinno")
    private WebElement pin;

    @FindBy(name = "emailid")
    private WebElement email;

    @FindBy(css = "input[name='password']")
    private WebElement password;

    @FindBy(css = "input[value='Submit']")
    private WebElement submitButton;

    @FindBy(id = "dob")
    private WebElement birthdate;

    @FindBy(xpath = "//p[@class='heading3']")
    private WebElement heading;


    public void goToNewCustomerPage() {
        newCustomer.click();
    }

    public void verifyCustomerPage() {
        if (driver.getTitle().contains("New Customer")) {
            System.out.println("New customer page navigation was success");
        }
    }

    public void enterCustomerInfo() throws FileNotFoundException {
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir") +
                "\\src\\test\\java\\TestData\\newCustomer.json");
        JsonPath jsonPath = new JsonPath(fis);
        name.sendKeys(jsonPath.getString("name"));
        address.sendKeys(jsonPath.getString("address"));
        city.sendKeys(jsonPath.getString("city"));
        state.sendKeys(jsonPath.getString("state"));
        pin.sendKeys(jsonPath.getString("PIN"));
        phoneNumber.sendKeys(jsonPath.getString("phone"));
        Faker faker = new Faker();

        email.sendKeys(faker.internet().emailAddress());
        password.sendKeys(jsonPath.getString("pass"));
        if (jsonPath.getString("gender").equalsIgnoreCase("male")) {
            male.click();
        } else {
            female.click();
        }
        birthdate.sendKeys(jsonPath.getString("birthdate"));
        submitButton.click();
    }

    public void verifyNewCustomer() throws InterruptedException {
        if(heading.getText().contains("Successfully")) {
            System.out.println(heading.getText());
        }





    }
}

