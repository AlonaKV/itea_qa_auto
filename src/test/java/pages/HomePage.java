package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by mykola on 7/19/2016.
 */
public class HomePage extends BasePage{

    public HomePage(){

        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".name")
    private WebElement userFullName;

    /**
     * Find user name in the user's home page.
     * @return - text from element that was found.
     */
    public  String getUserFullName() {
        return userFullName.getText();
    }
 }