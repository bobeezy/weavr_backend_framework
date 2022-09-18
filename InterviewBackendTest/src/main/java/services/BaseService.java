package services;

/**
 * @author lionel mangoua
 * Date: 18/09/22
 */

import io.restassured.RestAssured;
import io.restassured.config.EncoderConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import properties.BackendProperties;

public class BaseService {

    public static final Logger logger = LogManager.getLogger(BaseService.class);
    //user
    public static int userId = 0;
    public static String userName = "";
    public static String userEmail = "";
    public static String userGender = "";
    public static String userStatus = "";
    //post
    public static int postId = 0;
    public static int postUserId = 0;
    public static String postTitle = "";
    public static String postBody = "";
    //comment
    public static int commentId = 0;
    public static String commentName = "";
    public static String commentEmail = "";
    public static String commentBody = "";

    protected static RequestSpecification defaultRequestSpecification(){

        return restAssured()
                .header("Content-type", "application/json")
                .header("Authorization", BackendProperties.validAccessToken());
    }

    protected static RequestSpecification restAssured() {

        RestAssured.baseURI = BackendProperties.BaseURL();
        RestAssured.useRelaxedHTTPSValidation();
        RestAssured.urlEncodingEnabled = false;

        return given()
                .config(RestAssuredConfig.config()
                        .encoderConfig(EncoderConfig.encoderConfig().appendDefaultContentCharsetToContentTypeIfUndefined(false)))
                .log().all();
    }
}
