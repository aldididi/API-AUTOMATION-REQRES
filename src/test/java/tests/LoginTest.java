package tests;

import apiengine.UserCollectionsAPI;
import base.TestBase;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import payloads.Payload;

public class LoginTest extends TestBase {
    String token;
    UserCollectionsAPI userApi = new UserCollectionsAPI();


    @Test
    public void userLogin(){
        System.out.println("login user");
        String reqBody = Payload.userValidLogin("eve.holt@reqres.in", "pistol");
        Response response = userApi.userLogin(reqBody);
        Assert.assertEquals(response.getStatusCode(), 200, "Success Login");
        System.out.println(response.asPrettyString());
    }

    @Test
    public void loginWrongPassword() {
        String reqBody = Payload.userMissingEmailLogin("eve.holt@reqres.in", "pistol12");
        Response response = userApi.userLogin(reqBody);
        Assert.assertEquals(response.statusCode(), 400, "wrong password");
        System.out.println(response.asPrettyString());
    }

    @Test
    public void loginMissingEmail() {
        String reqBody = Payload.userMissingEmailLogin("", "pistol");
        Response response = userApi.userLogin(reqBody);
        Assert.assertEquals(response.statusCode(), 400, "Expected 400 for missing email");
        System.out.println(response.asPrettyString());
    }

    @Test
    public void loginMissingPassword(){
        String reqBody = Payload.userMissingPasswordLogin("eve.holt@reqres.in", "");
        Response response = userApi.userLogin(reqBody);
        Assert.assertEquals(response.statusCode(), 400, "Expected 400 for missing password");
        System.out.println(response.asPrettyString());
    }


}
