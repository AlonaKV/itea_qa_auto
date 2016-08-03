package tests;


import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginAndRegistrationPage;

/**
 * All possible tests for user Registration
 */
public class LoginAndRegistrationTests {

    @Test
    public void registrationWithEmptyFieldsTest() {
        LoginAndRegistrationPage registrationPage = new LoginAndRegistrationPage();
        registrationPage.clickJoinNowButton();
        String alterText = registrationPage.getAlertText();
        Assert.assertTrue(alterText.contains("Please enter"));
        registrationPage.ShutDown();
    }

    @DataProvider(name = "emptyFieldsValuesCombination")
    public static Object[][] createData() {
        return new Object[][]{
                {"", "Last", "a@gmail.com", "P@ssword"},
                {"First", "", "a@gmail.com", "Pssword"},
                {"First", "Last", "", "Pssword"},
                {"First", "Last", "a@gmail.com", ""},
                {"", "", "", ""},
        };
    }

    @Test(dataProvider = "emptyFieldsValuesCombination")
    public void registrationAllEmptyFieldsCombinationTest(String first, String last, String email, String password) {
        LoginAndRegistrationPage registrationPage = new LoginAndRegistrationPage();
        registrationPage.fillAndSubmitRegistrationForm(first, last, email, password);
        String alterText = registrationPage.getAlertText();
        Assert.assertTrue(alterText.contains("Please enter"));
        registrationPage.ShutDown();
    }

    @Test
    public void successfulLoginTest () {
        LoginAndRegistrationPage loginregistrationPage = new LoginAndRegistrationPage();
        Assert.assertNotNull(loginregistrationPage, "Login page is not loaded.");
        HomePage userPage = loginregistrationPage.login("kolesnikova.alyona@gmail.com", "Qwerty+15987");
        Assert.assertNotNull(userPage, "Home page is not loaded.");
    }

        //try {
        //    Thread.sleep(5000);
        //} catch (InterruptedException e) {
        //  e.printStackTrace();
        // }

    }