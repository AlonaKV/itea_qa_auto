package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginAndRegistrationPage;
import pages.SearchResultsPage;

/**
 * Created by shtrih on 03.08.16.
 */
public class AdvancedSearchTests {

        final static String email = "kolesnikova.alyona@gmail.com";
        final static String password = "Qwerty+15987";
        final static String searchTerm = "HR";

        @Test
        public void advancedSearchPositiveTest () {
            LoginAndRegistrationPage loginAndRegistrationPage = new LoginAndRegistrationPage();
            Assert.assertNotNull(loginAndRegistrationPage, "Login page is not loaded.");
            HomePage homePage = loginAndRegistrationPage.login(email, password);
            Assert.assertNotNull(homePage, "Home page is not loaded.");
            SearchResultsPage searchResultsPage = homePage.clickAdvancedSearchLink();
            searchResultsPage.performSearch(searchTerm);
            //Assert that 10 items returned in results list
            //Assert that each item from results list contains searchTerm
        }

    }
