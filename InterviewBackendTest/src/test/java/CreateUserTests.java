import io.restassured.response.Response;
import models.CreateUserModel;
import org.junit.jupiter.api.Test;
import properties.BackendProperties;
import services.GoRestService;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.apache.http.HttpStatus.SC_CREATED;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;

public class CreateUserTests {

    private String _baseURL = "https://gorest.co.in/";
    private String _validAccessToken = "tqgiwz-unv8OWaZXfyNqSzEqIp8nYBUi3Pgo"; //0f3ec1965e086978fa318db859f51424bb66409d9ba2669ebb898ac39b1b3e5c
    private String _invalidAccessToken = "InvalidToken";

    @Test
    public void Users_CreateUsers_Success(){

        final CreateUserModel createUserModel = new CreateUserModel("Samuel9911 Eto'o", "male", "Fuckitissue9111@gmail.com", "active");
//        final CreateUserModel createUserModel = new CreateUserModel("Gino" +  + Math.random() + " Paloma" + Math.random(), "female", "qatest" + Math.random() + "@gmail.com", "active");
        GoRestService.createUser(createUserModel)
                .then()
                .statusCode(BackendProperties.CreatedSuccessCode())
//                .statusCode(SC_CREATED)
                .body("data.id", notNullValue())
                .body("data.name", equalTo(createUserModel.getName()))
                .body("data.gender", equalTo(createUserModel.getGender()))
                .body("data.email", equalTo(createUserModel.getEmail()))
                .body("data.status", equalTo(createUserModel.getStatus()));

        System.out.println("HTTP Status Code: " + GoRestService.createUser(createUserModel).statusCode());
        System.out.println("============");
        System.out.println("BODY: " + GoRestService.createUser(createUserModel).prettyPrint());
    }

    @Test
    public void t_03_get_request_fetch_all_names() {

        Response resp = given().
                baseUri(_baseURL).
                auth().oauth2(_validAccessToken).
                when().get("/public-api/users").
                thenReturn();

//        Reporter.log("HTTP Status Code: " + resp.getStatusCode() + resp.getBody().asString());
        System.out.println("HTTP Status Code: " + resp.getStatusCode() + resp.getBody().asString());
//        int statusCode = resp.jsonPath().getInt("_meta.code");
//        Assert.assertEquals(statusCode,200,"Valid Token Test case. Status code should come as 200");
//        System.out.println("Status code: " + statusCode);
        System.out.println("Status code: " + resp.getStatusCode());

        System.out.println("HTTP Status Code: " + resp.getStatusCode());
        System.out.println("BODY: " + resp.getBody().asString());

        //Get list of all the first name

        List<String> list_all_first_name = resp.jsonPath().getList("data.name");
        System.out.println("List of all first name: " + list_all_first_name.toString());

    }
}
