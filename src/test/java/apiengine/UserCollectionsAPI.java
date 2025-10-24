package apiengine;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.util.List;

import static io.restassured.RestAssured.given;

public class UserCollectionsAPI {
    public Response userRegister(String requestBody){
        return RestAssured.given()
                .header("Content-Type", "application/json")
                .header("accept", "application/json")
                .header("x-api-key","reqres-free-v1")
                .body(requestBody).log().all()
                .when().post(Endpoints.REGISTER);

    }
    public Response userLogin(String requestBody){
        return RestAssured.given()
                .baseUri(Endpoints.BASE_URL)
                .header("Content-Type", "application/json")
                .header("accept", "application/json")
                .header("x-api-key","reqres-free-v1")
                .body(requestBody).log().all()
                .when().post(Endpoints.LOGIN);

    }

    public Response usersList(int pageNumber){
        return RestAssured.given()
                .baseUri(Endpoints.BASE_URL)
                .header("Content-Type", "application/json")
                .header("x-api-key","reqres-free-v1")
                .when().get(Endpoints.USERSBYPAGE+pageNumber);

    }

    public Response userDetails(int userId){
        return RestAssured.given()
                .baseUri(Endpoints.BASE_URL)
                .header("Content-Type", "application/json")
                 .header("x-api-key","reqres-free-v1").log().all()
                .when().get(Endpoints.USERSBYID +userId);

    }
    public Response userDetails2(int userId){
        return RestAssured.given()
                .baseUri(Endpoints.BASE_URL)
                .header("Content-Type", "application/json")
                .header("x-api-key","reqres-free-v1").log().all()
                .when().get(Endpoints.USERSBYID+ "/" + userId);

    }

    public Response deleteUser(int userId){
        return RestAssured.given()
                .baseUri(Endpoints.BASE_URL)
                .header("Content-Type", "application/json")
                .header("x-api-key","reqres-free-v1").log().all()
                .when().delete(Endpoints.USERSBYID +userId);

    }

    public boolean isDataEmpty(Response response){
        List<Object> data = response.jsonPath().getList("data");
        return data == null || data.isEmpty();
    }
}
