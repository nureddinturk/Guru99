package PageDesign;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PageDriver {
        public WebDriver driver;
        public WebDriver getDriver() throws IOException {

         Properties prod = new Properties();
            FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\java\\TestData\\config.properties");
            prod.load(fis);
            String browser= prod.getProperty("browser");
            if(browser.equalsIgnoreCase("chrome")) {
                driver = new ChromeDriver();
            }
       return driver;
        }

    public void shutDown() throws IOException {
        driver.close();
            driver.quit();
    }


    }
