package services;

/**
 * @author lionel mangoua
 * Date: 18/09/22
 */

import io.restassured.response.Response;
import models.CreateCommentModel;
import models.CreatePostModel;
import models.CreateTodosModel;
import models.CreateUserModel;
import properties.BackendProperties;

public class GoRestService extends BaseService {

    public static Response createUser(final CreateUserModel createUserModel) {
        Response response = defaultRequestSpecification()
                .body(createUserModel)
                .when()
                .post(BackendProperties.createUserURI())
                .then().extract().response();
        logger.info("\nResponse body: " + response.body().prettyPrint());
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
        logger.info("\nResponse body: " + response.body().prettyPrint());
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
        logger.info("\nResponse body: " + response.body().prettyPrint());
        commentId = response.body().path(BackendProperties.commentIdPath());
        commentName = response.body().path(BackendProperties.commentNamePath());
        commentEmail = response.body().path(BackendProperties.commentEmailPath());
        commentBody = response.body().path(BackendProperties.commentBodyPath());
        logger.info("commentId: " + commentId);
        return response;
    }

    public static Response createTodos(final CreateTodosModel createTodosModel, int userId) {
        Response response = defaultRequestSpecification()
                .body(createTodosModel)
                .when()
                .post(BackendProperties.createTodosURI(userId))
                .then().extract().response();
        logger.info("\nResponse body: " + response.body().prettyPrint());
        todosId = response.body().path(BackendProperties.todosIdPath());
        todosUserId = response.body().path(BackendProperties.todosUserIdPath());
        todosTitle = response.body().path(BackendProperties.todosTitlePath());
        todosDueOn = response.body().path(BackendProperties.todosDueOnPath());
        todosStatus = response.body().path(BackendProperties.todosStatusPath());
        logger.info("todosId: " + todosId);
        return response;
    }

    public static Response updateUser(final CreateUserModel createUserModel, int userId) {
        Response response = defaultRequestSpecification()
                .body(createUserModel)
                .when()
                .put(BackendProperties.getUserByIdURI(userId))
                .then().extract().response();
        logger.info("\nResponse body: " + response.body().prettyPrint());
        userId = response.body().path(BackendProperties.userIdPath());
        logger.info("userId: " + userId);
        return response;
    }

    public static Response getUserById(int userId) {
        Response response = defaultRequestSpecification()
                .when()
                .get(BackendProperties.getUserByIdURI(userId))
                .then().extract().response();
        logger.info("\nResponse body: " + response.body().prettyPrint());
        return response;
    }

    public static Response getPostById(int postId) {
        Response response = defaultRequestSpecification()
                .when()
                .get(BackendProperties.getPostByIdURI(postId))
                .then().extract().response();
        logger.info("\nResponse body: " + response.body().prettyPrint());
        return response;
    }

    public static Response getCommentById(int postId) {
        Response response = defaultRequestSpecification()
                .when()
                .get(BackendProperties.getCommentByPostIdURI(postId))
                .then().extract().response();
        logger.info("\nResponse body: " + response.body().prettyPrint());
        return response;
    }

    public static Response getTodosById(int user_Id) {
        Response response = defaultRequestSpecification()
                .when()
                .get(BackendProperties.getTodosByIdURI(user_Id))
                .then().extract().response();
        logger.info("\nResponse body: " + response.body().prettyPrint());
        return response;
    }

    public static Response getAllUsers() {
        Response response = defaultRequestSpecification()
                .when()
                .get(BackendProperties.getAllUsersURI())
                .then().extract().response();
        logger.info("\nResponse body: " + response.body().prettyPrint());
        return response;
    }

    public static Response getAllPosts() {
        Response response = defaultRequestSpecification()
                .when()
                .get(BackendProperties.getAllPostsURI())
                .then().extract().response();
        logger.info("\nResponse body: " + response.body().prettyPrint());
        return response;
    }

    public static Response getAllComments() {
        Response response = defaultRequestSpecification()
                .when()
                .get(BackendProperties.getAllCommentsURI())
                .then().extract().response();
        logger.info("\nResponse body: " + response.body().prettyPrint());
        return response;
    }

    public static Response getAllTodos() {
        Response response = defaultRequestSpecification()
                .when()
                .get(BackendProperties.getAllTodosURI())
                .then().extract().response();
        logger.info("\nResponse body: " + response.body().prettyPrint());
        return response;
    }

    public static Response deleteUserById(int userId) {
        Response response = defaultRequestSpecification()
                .when()
                .delete(BackendProperties.getUserByIdURI(userId))
                .then().extract().response();
        logger.info("\nResponse body: " + response.body().prettyPrint());
        return response;
    }

    //common Methods
    public static Response getMethod(String basePath) {
        Response response = defaultRequestSpecification()
                .when()
                .get(basePath)
                .then().extract().response();
        logger.info("\nResponse body: " + response.body().prettyPrint());
        return response;
    }

    public static Response deleteMethod(String basePath) {
        Response response = defaultRequestSpecification()
                .when()
                .delete(basePath)
                .then().extract().response();
        logger.info("\nResponse body: " + response.body().prettyPrint());
        return response;
    }
}
