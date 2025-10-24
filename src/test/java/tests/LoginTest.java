package tests;

import apiengine.UserCollectionsAPI;
import org.example.base.BaseTest;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import payloads.Payload;

public class LoginTest extends BaseTest {
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
        String reqBody = Payload.userWrongPassword("eve.holt@reqres.in", "pistol12asdasd");
        Response response = userApi.userLogin(reqBody);
        Assert.assertEquals(response.statusCode(), 200, "wrong password but able to login");
        System.out.println(response.asPrettyString());
    }
    @Test
    public void loginWrongEmail() {
        String reqBody = Payload.userWrongEmail("eve.holt@reqres.inasd", "pistol12");
        Response response = userApi.userLogin(reqBody);
        Assert.assertEquals(response.statusCode(), 400, "user not found");
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
