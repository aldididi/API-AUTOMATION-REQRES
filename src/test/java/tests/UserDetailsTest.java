package tests;

import apiengine.UserCollectionsAPI;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import payloads.Payload;

import java.util.List;

public class UserDetailsTest {
    UserCollectionsAPI userApi = new UserCollectionsAPI();

    @Test
    public void getUsersByPId() {
        System.out.println("getUsersByPId");
        int[] idUser = {1, 5, 12, 450};

        for (int id : idUser) {
            System.out.println("Testing user ID: " + id);

            try {
                Response response = userApi.userDetails(id);
                int statusCode = response.getStatusCode();

                if (statusCode == 200) {
                    System.out.println("User ID " + id + " found");
                    response.prettyPrint();


                    int returnedId = response.jsonPath().getInt("data.id");
                    Assert.assertEquals(returnedId, id, "User ID in response should match requested ID");

                } else if (statusCode == 404) {
                    System.out.println("User ID " + id + " not found");
                } else {
                    Assert.fail("Unexpected status code for user " + id + ": " + statusCode);
                }
            } catch (Exception e) {
                System.out.println("Exception while fetching user " + id + ": " + e.getMessage());
            }
        }
    }



//    @Test
//    public void getUserById() {
//        System.out.println("getUsersByPId");
//
//        int[] idUser = {1, 5, 12};
//
//        for (int id : idUser) {
//            Response response = userApi.userDetails2(id);
//            System.out.println("Testing user ID: " + id);
//            Assert.assertEquals(response.getStatusCode(), 200, "Page request should return 200 OK");
//            response.prettyPrint();
//        }
//    }
}
