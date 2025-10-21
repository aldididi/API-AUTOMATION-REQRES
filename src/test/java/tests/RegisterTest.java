package tests;

import apiengine.UserCollectionsAPI;
import base.TestBase;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import payloads.Payload;

import static io.restassured.RestAssured.given;

public class RegisterTest extends TestBase {
    String token;
    UserCollectionsAPI userApi = new UserCollectionsAPI();

    @Test
    public void userRegister(){
        System.out.println("register user");
        String reqBody = Payload.userRegister("eve.holt@reqres.in", "pistol");
        Response response = userApi.userRegister(reqBody);
        Assert.assertEquals(response.getStatusCode(), 200, "Success Regist");
        System.out.println(response.asPrettyString());
    }

    @Test
    public void userRegisterMissingEmail(){
        String reqBody = Payload.userRegisterMissingEmail("","pistol");
        Response response = userApi.userRegister(reqBody);
        Assert.assertEquals(response.getStatusCode(), 400, "Missing email");
    }

    @Test
    public void userRegisterMissingPassword(){
        String reqBody = Payload.userRegisterMissingPassword("","pistol");
        Response response = userApi.userRegister(reqBody);
        Assert.assertEquals(response.getStatusCode(), 400, "Missing password");
    }
    @Test
    public void userRegisterNonDefined(){
        String reqBody = Payload.userNonDefinedRegis("asdasdsad","asdasdsd");
        Response response = userApi.userRegister(reqBody);
        Assert.assertEquals(response.getStatusCode(), 400, "Only defined users succeed registration");
    }


//    @Test
//    public void getUsersByPage() {
//        System.out.println("getUsersByPage");
//        RestAssured.given().baseUri("https://reqres.in/api")
//                .header("Content-Type", "application/json")
//                .when().get("/users?page=4")
//                .then().assertThat().statusCode(200).log().all();
//    }
}
