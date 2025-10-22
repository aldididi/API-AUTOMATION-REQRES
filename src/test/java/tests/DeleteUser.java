package tests;

import apiengine.UserCollectionsAPI;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DeleteUser {
    UserCollectionsAPI userApi = new UserCollectionsAPI();

    @Test
    public void deletUserByID() {
        System.out.println("deletUserByID");
        Response response = userApi.deleteUser(2);
        Assert.assertEquals(response.getStatusCode(), 204, "user deleted");
        response.prettyPrint();
    }
}
