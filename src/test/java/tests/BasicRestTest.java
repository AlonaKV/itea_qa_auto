package tests;


import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static com.jayway.restassured.RestAssured.given;

public class BasicRestTest {
    final private static String authKey = "Basic YWxvbmFfa29sZXNuaWtvdmFAbWFpbC5ydTpYV3d5S1IyMDJPRDU4WWhlNnJDRw";


    @BeforeTest
    public void before () {
        RestAssured.baseURI = "https://alkolesnikova.testrail.net";
        RestAssured.requestContentType(ContentType.JSON);
        //RestAssured.authentication = basic("alona_kolesnikova@mail.ru","Qwerty+15987");

    }

    @Test
    public void successfulGetCaseResponseCode1(){
        int testCaseId = 1;
        Response response = given().header("Authorization", authKey)
                .when().get("/index.php?/api/v2/get_case/{t}",testCaseId);
        String testCaseTitle = "Verify successful user login";
        Assert.assertEquals(200, response.getStatusCode(), "Status code is wrong");
        Assert.assertTrue(response.asString().contains(testCaseTitle), "Test case title not found in output");
    }

    @Test
    public void successfulGetCaseResponseCode2(){
        given()
                .header("Authorization", authKey)
                .expect()
                .statusCode(200)
                .response()
                .when()
                .get("/index.php?/api/v2/get_case/1");
    }

}
