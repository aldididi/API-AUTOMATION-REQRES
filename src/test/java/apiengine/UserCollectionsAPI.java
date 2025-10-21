package apiengine;
import io.restassured.RestAssured;
import io.restassured.response.Response;
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
                .baseUri("https://reqres.in/api")
                .header("Content-Type", "application/json")
                .when().get(Endpoints.USERSBYPAGE+pageNumber);

    }
}
