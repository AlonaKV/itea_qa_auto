package tests;

import org.testng.annotations.DataProvider;

/**
 * Created by shtrih on 21.07.16.
 */
public class LinkedinData {

    @DataProvider(name = "registrate")
    public static Object[][] registrate() {
        return new Object[][]{
                {"", "Last", "a@gmail.com", "P@ssword"},
                {"First", "", "a@gmail.com", "Pssword"},
                {"First", "Last", "", "Pssword"},
                {"First", "Last", "a@gmail.com", ""},
                {"", "", "", ""},
        };
    }

    @DataProvider(name = "login")
    public static Object[][] login() {
        return new Object[][]{
                {"kolesnikova.alyona@gmail.com", "Qwerty+15987"},
        };
    }
}
