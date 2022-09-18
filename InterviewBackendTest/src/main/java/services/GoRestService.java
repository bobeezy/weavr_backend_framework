package services;

/**
 * @author lionel mangoua
 * Date: 18/09/22
 */

import io.restassured.response.Response;
import models.CreateCommentModel;
import models.CreatePostModel;
import models.CreateUserModel;
import properties.BackendProperties;

public class GoRestService extends BaseService {

    public static Response createUser(final CreateUserModel createUserModel) {
        Response response = defaultRequestSpecification()
                .body(createUserModel)
                .when()
                .post(BackendProperties.createUserURI())
                .then().extract().response();
        logger.info("Response body: " + response.body().prettyPrint());
        userId = response.body().path(BackendProperties.userIdPath());
        userName = response.body().path(BackendProperties.userNamePath());
        userEmail = response.body().path(BackendProperties.userEmailPath());
        userGender = response.body().path(BackendProperties.userGenderPath());
        userStatus = response.body().path(BackendProperties.userStatusPath());
        logger.info("userId: " + userId);
        return response;
    }

    public static Response createPost(final CreatePostModel createPostModel, int userId) {
        Response response = defaultRequestSpecification()
                .body(createPostModel)
                .when()
                .post(BackendProperties.createPostURI(userId))
                .then().extract().response();
        System.out.println(); //TODO add logger
        logger.info("Response body: " + response.body().prettyPrint());
        postId = response.body().path(BackendProperties.postIdPath());
        postUserId = response.body().path(BackendProperties.postUserIdPath());
        postTitle = response.body().path(BackendProperties.postTitlePath());
        postBody = response.body().path(BackendProperties.postBodyPath());
        logger.info("postId: " + postId);
        return response;
    }

    public static Response createComment(final CreateCommentModel createCommentModel, int userId) {
        Response response = defaultRequestSpecification()
                .body(createCommentModel)
                .when()
                .post(BackendProperties.createCommentURI(userId))
                .then().extract().response();
        logger.info("Response body: " + response.body().prettyPrint());
        commentId = response.body().path(BackendProperties.commentIdPath());
        commentName = response.body().path(BackendProperties.commentNamePath());
        commentEmail = response.body().path(BackendProperties.commentEmailPath());
        commentBody = response.body().path(BackendProperties.commentBodyPath());
        logger.info("commentId: " + commentId);
        return response;
    }

    public static Response updateUser(final CreateUserModel createUserModel, int userId) {
        Response response = defaultRequestSpecification()
                .body(createUserModel)
                .when()
                .put(BackendProperties.getUserByIdURI(userId))
                .then().extract().response();
        logger.info("Response body: " + response.body().prettyPrint());
        userId = response.body().path(BackendProperties.userIdPath());
        logger.info("userId: " + userId);
        return response;
    }

    public static Response getAllUsers() {
        Response response = defaultRequestSpecification()
                .when()
                .get(BackendProperties.getAllUsersURI())
                .then().extract().response();
        logger.info("Response body: " + response.body().prettyPrint());
        return response;
    }

    public static Response getAllPosts() {
        Response response = defaultRequestSpecification()
                .when()
                .get(BackendProperties.getAllPostsURI())
                .then().extract().response();
        logger.info("Response body: " + response.body().prettyPrint());
        return response;
    }

    public static Response getUserById(int userId) {
        Response response = defaultRequestSpecification()
                .when()
                .get(BackendProperties.getUserByIdURI(userId))
                .then().extract().response();
        logger.info("Response body: " + response.body().prettyPrint());
        return response;
    }

    public static Response getPostById(int postId) {
        Response response = defaultRequestSpecification()
                .when()
                .get(BackendProperties.getPostByIdURI(postId))
                .then().extract().response();
        logger.info("Response body: " + response.body().prettyPrint());
        return response;
    }

    public static Response getAllComments() {
        Response response = defaultRequestSpecification()
                .when()
                .get(BackendProperties.getAllCommentsURI())
                .then().extract().response();
        logger.info("Response body: " + response.body().prettyPrint());
        return response;
    }

    public static Response getCommentById(int postId) {
        Response response = defaultRequestSpecification()
                .when()
                .get(BackendProperties.getCommentByPostIdURI(postId))
                .then().extract().response();
        logger.info("Response body: " + response.body().prettyPrint());
        return response;
    }

    public static Response deleteUserById(int userId) {
        Response response = defaultRequestSpecification()
                .when()
                .delete(BackendProperties.getUserByIdURI(userId))
                .then().extract().response();
        logger.info("Response body: " + response.body().prettyPrint());
        return response;
    }

//    public static Response GetMethod(String baseURL,String URI,String accessToken)
//    {
//        response = given().
//                baseUri(baseURL).
//                auth().oauth2(accessToken).
//                when().get(URI)
//                .then()
//                .extract().response();
//        return response;
//    }

//    public static Response createUser(final CreateUserModel createUserModel) {
//        return defaultRequestSpecification()
//                .body(createUserModel)
//                .when()
//                .post(BackendProperties.CreateUserURI())
//                .then().extract().response();
//    }

//    public static Response createUser(final CreateUserModel createUserModel) {
//        return defaultRequestSpecification()
//                .body(createUserModel)
//                .when()
//                .post("/public/v1/users");
//    }
}
