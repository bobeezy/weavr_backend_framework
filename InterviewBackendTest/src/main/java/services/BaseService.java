package services;

import io.restassured.RestAssured;
import io.restassured.config.EncoderConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.specification.RequestSpecification;
import properties.BackendProperties;

import static io.restassured.RestAssured.given;

public class BaseService {

    public static int userId = 0;
    public static String userName = "";
    public static String userEmail = "";
    public static String userGender = "";
    public static String userStatus = "";
    public static int postId = 0;
    public static int postUserId = 0;
    public static String postTitle = "";
    public static String postBody = "";

    public static int commentId = 0;
    public static String commentName = "";
    public static String commentEmail = "";
    public static String commentBody = "";

    protected static RequestSpecification defaultRequestSpecification(){
        return restAssured()
                .header("Content-type", "application/json")
                .header("Authorization", "Bearer 0f3ec1965e086978fa318db859f51424bb66409d9ba2669ebb898ac39b1b3e5c"); //TODO works
//                .header("Authorization", "0f3ec1965e086978fa318db859f51424bb66409d9ba2669ebb898ac39b1b3e5c"); //TODO 401
//                .header("Authorization", "tqgiwz-unv8OWaZXfyNqSzEqIp8nYBUi3Pgo"); //TODO 401
//                .header("Authorization", "Bearer fa80cece96297cd1ee8f66607d62a94723a4ddd79769451e5a6ef9efba66ca61"); //TODO 422
    } //"tqgiwz-unv8OWaZXfyNqSzEqIp8nYBUi3Pgo"  //0f3ec1965e086978fa318db859f51424bb66409d9ba2669ebb898ac39b1b3e5c

    protected static RequestSpecification restAssured() {
        RestAssured.baseURI = BackendProperties.BaseURL();
        RestAssured.useRelaxedHTTPSValidation();
        RestAssured.urlEncodingEnabled = false;

        return given()
                .config(RestAssuredConfig.config()
                        .encoderConfig(EncoderConfig.encoderConfig().appendDefaultContentCharsetToContentTypeIfUndefined(false)))
                .log().all();
    }

//    protected static RequestSpecification restAssured() {
//        RestAssured.baseURI = BackendProperties.BaseURL();
//        RestAssured.useRelaxedHTTPSValidation();
//        RestAssured.urlEncodingEnabled = false;
//
//        return given()
//                .config(RestAssuredConfig.config()
//                        .encoderConfig(EncoderConfig.encoderConfig().appendDefaultContentCharsetToContentTypeIfUndefined(false)));
//    }
}
