package tests;


import org.testng.Assert;
import org.testng.annotations.*;
import pages.HomePage;
import pages.LoginAndRegistrationPage;

import java.util.HashMap;

/**
 * All possible tests for user Registration
 */
public class LoginAndRegistrationTests {

    HashMap<String, String> singUpMap;

    @Factory(dataProvider = "registrate", dataProviderClass = LinkedinData.class)

    public LoginAndRegistrationTests(String first, String last, String email, String password){
        singUpMap = new HashMap<String, String>();
        singUpMap.put("firstname", first);
        singUpMap.put("lastname", last);
        singUpMap.put("email", email);
        singUpMap.put("password", password);
    }

    HashMap<String, String> loginUser;

    @Factory(dataProvider = "login", dataProviderClass = LinkedinData.class)

    public LoginAndRegistrationTests(String email, String password){
        loginUser = new HashMap<String, String>();
        loginUser.put("firstname", email);
        loginUser.put("password", password);
    }


    @Test
    public void registrationWithEmptyFieldsTest() {
        LoginAndRegistrationPage registrationPage = new LoginAndRegistrationPage();
        registrationPage.clickJoinNowButton();
        String alterText = registrationPage.getAlertText();
        Assert.assertTrue(alterText.contains("Please enter"));
    }

    @Test
    public void registrationAllEmptyFieldsCombinationTest() {
        LoginAndRegistrationPage registrationPage = new LoginAndRegistrationPage();
        registrationPage.fillAndSubmitRegistrationForm(singUpMap.get("firstname"), singUpMap.get("lastname"), singUpMap.get("email"), singUpMap.get("password"));
        String alterText = registrationPage.getAlertText();
        Assert.assertTrue(alterText.contains("Please enter"));
    }
    @Test
    public void successfulLoginTest () {
        LoginAndRegistrationPage loginregistrationPage = new LoginAndRegistrationPage();
        HomePage userPage = loginregistrationPage.login("kolesnikova.alyona@gmail.com", "Qwerty+15987");
        userPage.getUserFullName();
        Assert.assertEquals(userPage.getUserFullName(), "Alyona Kolesnikova");

        //try {
        //    Thread.sleep(5000);
        //} catch (InterruptedException e) {
        //  e.printStackTrace();
        // }

    }

}