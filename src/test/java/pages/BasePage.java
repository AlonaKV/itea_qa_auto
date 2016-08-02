package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    protected static WebDriver driver = new FirefoxDriver();

    public BasePage() {
        this.driver = driver;
    }
}
