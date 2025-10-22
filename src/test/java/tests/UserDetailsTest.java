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
        Response response = userApi.userDetails(1);
        Assert.assertEquals(response.getStatusCode(), 200, "Page request should return 200 OK");
        response.prettyPrint();
    }

    @Test
    public void getUsersByPId2() {
      //  System.out.println("getUsersByPage");
        Response response = userApi.userDetails(5);
        Assert.assertEquals(response.getStatusCode(), 200, "Page request should return 200 OK");
        response.prettyPrint();
    }

    @Test
    public void getUsersByPId3() {
      //  System.out.println("getUsersByPage");
        Response response = userApi.userDetails(12);
        Assert.assertEquals(response.getStatusCode(), 200, "Page request should return 200 OK");
        response.prettyPrint();
    }

    @Test
    public void getUsersByPage4() {
        System.out.println("getUsersByPage");
        Response response = userApi.userDetails(100);
        Assert.assertNull(response.jsonPath().get("data"));
        Assert.assertEquals(response.getStatusCode(), 404, "not found");
        response.prettyPrint();
    }

//    @Test
//    public void DataIsEmpty(){
//        Response response = userApi.userDetails(100);
//        Assert.assertEquals(response.getStatusCode(), 200, "not found");
//      //  Assert.assertFalse(response.jsonPath().getList("data").isEmpty());
//        List<Object> dataList = response.jsonPath().getList("data");
//        boolean isEmpty = dataList == null || dataList.isEmpty();
//    }
}
