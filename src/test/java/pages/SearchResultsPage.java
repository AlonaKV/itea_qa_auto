package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by shtrih on 03.08.16.
 */
public class SearchResultsPage extends BasePage{

        @FindBy(id = "advs")
        private WebElement searchForm;

        @FindBy(id = "advs-keywords")
        private WebElement keywordsField;

        @FindBy(name = "submit")
        private WebElement searchButton;



        public SearchResultsPage() {
            PageFactory.initElements(driver, this);
            implicitWaitForElement(searchForm);
        }

        private List<String> getTitelsList(){
            ArrayList titelsTextList = new ArrayList<String>();
            Iterator<WebElement> i = titelsTextList.iterator();
            while (i.hasNext()){
                WebElement titelTextElement = i.next();
                String titleText = titelTextElement.getText();
                titelsTextList.add(titleText);
            }
            return titelsTextList;
        }

        public void performSearch (String searchTerm) {
            keywordsField.sendKeys(searchTerm);
            searchButton.submit();
        }

    }
