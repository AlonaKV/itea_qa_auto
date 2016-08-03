package tests;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static com.jayway.restassured.RestAssured.given;

public class LoginRestTest {

    final private static String authKey = "Basic a29sZXNuaWtvdmEuYWx5b25hQGdtYWlsLmNvbTpRd2VydHkrMTU5ODc=";
    @BeforeTest

    public void befor(){

        RestAssured.baseURI = "https://www.linkedin.com/";
        RestAssured.requestContentType(ContentType.JSON);
        //RestAssured.authentication = basic("kolesnikova.alyona@gmail.com","Qwerty+15987");
    }

    @Test
    public void successfulLoginResponseCode(){
        Response response = given().header("Authorization", authKey)
                .when().get();
        Assert.assertEquals(200, response.getStatusCode(), "Status code is wrong");
        //Assert.assertTrue(response.asString().contains(), "Test case title not found in output");
    }

    @Test
    public void successfulGetCaseResponseCode(){
        given()
                .header("Authorization", authKey)
                .expect()
                .statusCode(200)
                .response()
                .when()
                .get();
    }
}
