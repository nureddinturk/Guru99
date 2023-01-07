package PageObjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class LoginPage {

    WebDriver driver;
    String baseURL;

    public LoginPage(WebDriver driver) {
this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    @FindBy(css = "input[name='uid']")
    private WebElement usernameBox;

    @FindBy(xpath = "//input[@type='password']")
    private WebElement passwordBox;

    @FindBy(xpath = "//td[contains(text(),'Manger Id : mngr469674')]")
    private WebElement loginText;

    @FindBy(name = "btnLogin")
    private WebElement loginButton;

    public String getURL() throws IOException {
        Properties prod = new Properties();
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\java\\TestData\\config.properties");
        prod.load(fis);
        return baseURL = prod.getProperty("baseURL");
    }

    public void landing() throws IOException {
        driver.get(getURL());
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public void verifyLanding() {
        if (driver.getTitle().contains("Guru99")) {
            System.out.println("User is on the main page");
        }
    }

    public void login(String username, String password) throws InterruptedException {
        usernameBox.sendKeys(username);
        passwordBox.sendKeys(password);
loginButton.click();
        }


    public void verifyLogin() {
        Assert.assertTrue(loginText.getText().contains("Manger Id"));
            driver.close();
            driver.quit();
        }
        public void verifyLoginFailed() {
            Alert alert = driver.switchTo().alert();
            Assert.assertTrue(alert.getText().contains("not valid"));
            System.out.println(alert.getText());
            alert.dismiss();
            driver.close();
            driver.quit();
            }

}
