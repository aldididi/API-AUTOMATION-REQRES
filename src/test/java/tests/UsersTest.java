package tests;

import apiengine.UserCollectionsAPI;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import payloads.Payload;

public class UsersTest {
    UserCollectionsAPI userApi = new UserCollectionsAPI();
    @Test
    public void getUsersByPage() {
        System.out.println("getUsersByPage");
        Response response = userApi.usersList(2);
        Assert.assertEquals(response.getStatusCode(), 200, "Page request should return 200 OK");
        response.prettyPrint();
    }

    @Test
    public void getUsersByPage2() {
        System.out.println("getUsersByPage");
        Response response = userApi.usersList(4);
        Assert.assertEquals(response.getStatusCode(), 200, "Page request should return 200 OK");
        response.prettyPrint();
    }

}
