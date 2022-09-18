import io.restassured.response.Response;
import models.CreateCommentModel;
import models.CreatePostModel;
import models.CreateUserModel;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import properties.BackendProperties;
import services.GoRestService;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.apache.http.HttpStatus.*;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;
import static services.BaseService.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CreateUserTests {

    private String _baseURL = "https://gorest.co.in/";
    private String _validAccessToken = "tqgiwz-unv8OWaZXfyNqSzEqIp8nYBUi3Pgo"; //0f3ec1965e086978fa318db859f51424bb66409d9ba2669ebb898ac39b1b3e5c
    private String _invalidAccessToken = "InvalidToken";
    final CreateUserModel createUserModel = new CreateUserModel("John" +  + Math.random() + " Wick" + Math.random(), "male", "qatest" + Math.random() + "@gmail.com", "active");

    @Test
    @Order(1)
    public void Users_CreateUser_Success(){

//        final CreateUserModel createUserModel = new CreateUserModel("Samuel7011 Eto'o1", "male", "Fuckitissue17011@gmail.com", "active");
//        final CreateUserModel createUserModel = new CreateUserModel("Gino" +  + Math.random() + " Paloma" + Math.random(), "female", "qatest" + Math.random() + "@gmail.com", "active");
        GoRestService.createUser(createUserModel)
                .then()
//                .statusCode(BackendProperties.CreatedSuccessCode())
                .statusCode(SC_CREATED)
                .body(BackendProperties.userIdPath(), notNullValue())
                .body(BackendProperties.userNamePath(), equalTo(createUserModel.getName()))
                .body(BackendProperties.userGenderPath(), equalTo(createUserModel.getGender()))
                .body(BackendProperties.userEmailPath(), equalTo(createUserModel.getEmail()))
                .body(BackendProperties.userStatusPath(), equalTo(createUserModel.getStatus()));

//        System.out.println("HTTP Status Code: " + GoRestService.createUser(createUserModel).statusCode());
        System.out.println("============");
//        System.out.println("BODY: " + GoRestService.createUser(createUserModel).prettyPrint());
    }

    @Test
    @Order(2)
    public void Users_UpdateUser_Success(){

//        final CreateUserModel createUserModel = new CreateUserModel("Samuel7011 Eto'o1", "male", "Fuckitissue17011@gmail.com", "active");
        final CreateUserModel updateUserModel = new CreateUserModel(userName, "female", userEmail, userStatus); //update Gender
        GoRestService.updateUser(updateUserModel, userId)
                .then()
                .statusCode(SC_OK)
                .body(BackendProperties.userIdPath(), notNullValue())
                .body(BackendProperties.userNamePath(), equalTo(updateUserModel.getName()))
                .body(BackendProperties.userGenderPath(), equalTo(updateUserModel.getGender()))
                .body(BackendProperties.userEmailPath(), equalTo(updateUserModel.getEmail()))
                .body(BackendProperties.userStatusPath(), equalTo(updateUserModel.getStatus()));

//        System.out.println("HTTP Status Code: " + GoRestService.createUser(createUserModel).statusCode());
        System.out.println("============");
//        System.out.println("BODY: " + GoRestService.createUser(createUserModel).prettyPrint());
    }

    @Test
    @Order(3)
    public void Users_CreatePost_Success(){

        final CreatePostModel createPostModel = new CreatePostModel("LIONEL TEST TITLE", "This is the body of the post.");
        GoRestService.createPost(createPostModel, userId)
                .then()
                .statusCode(SC_CREATED)
                .body(BackendProperties.postIdPath(), notNullValue())
                .body(BackendProperties.postUserIdPath(), equalTo(userId))
                .body(BackendProperties.postTitlePath(), equalTo(createPostModel.getTitle()))
                .body(BackendProperties.postBodyPath(), equalTo(createPostModel.getBody()));

//        System.out.println("HTTP Status Code: " + GoRestService.createUser(createUserModel).statusCode());
        System.out.println("============");
//        System.out.println("BODY: " + GoRestService.createUser(createUserModel).prettyPrint());
    }

    @Test
    @Order(4)
    public void Users_CreateComment_Success(){

        final CreateCommentModel createCommentModel = new CreateCommentModel(postId, "Lionel", "testUser@gmail.com", "This is the body.");
        GoRestService.createComment(createCommentModel, postId)
                .then()
                .statusCode(SC_CREATED)
                .body(BackendProperties.commentIdPath(), notNullValue())
                .body(BackendProperties.commentPostIdPath(), equalTo(postId))
                .body(BackendProperties.commentNamePath(), equalTo(createCommentModel.getName()))
                .body(BackendProperties.commentEmailPath(), equalTo(createCommentModel.getEmail()))
                .body(BackendProperties.commentBodyPath(), equalTo(createCommentModel.getBody()));
    }

    @Test
    @Order(5)
    public void Users_GetUserById_Success(){

        GoRestService.getUserById(userId)
                .then()
                .statusCode(SC_OK)
                .body(BackendProperties.userIdPath(), notNullValue());
    }

    @Test
    @Order(6)
    public void Users_GetPostById_Success(){

        GoRestService.getPostById(userId)
                .then()
                .statusCode(SC_OK)
                .body(BackendProperties.userIdPath(), notNullValue());
    }

    @Test
    @Order(7)
    public void Users_GetCommentById_Success(){

        GoRestService.getCommentById(postId)
                .then()
                .statusCode(SC_OK)
                .body(BackendProperties.userIdPath(), notNullValue());
    }

//    @Test
//    @Order(6)
//    public void Users_GetPostByUserId_Success(){
//
//        GoRestService.getPostById(userId)
//                .then()
//                .statusCode(SC_OK)
//                .body(BackendProperties.userIdPath(), notNullValue());
//    }

    @Test
    @Order(8)
    public void Users_DeleteUserById_Success(){

        GoRestService.deleteUserById(userId)
                .then()
                .statusCode(SC_NO_CONTENT);
    }

    @Test
    @Order(9)
    public void Users_GetAllUsers_Success(){

        GoRestService.getAllUsers()
                .then()
                .statusCode(SC_OK)
                .body(BackendProperties.userIdPath(), notNullValue());
    }

    @Test
    public void Users_GetAllPosts_Success(){

        GoRestService.getAllPosts()
                .then()
                .statusCode(SC_OK)
                .body(BackendProperties.userIdPath(), notNullValue());
    }

    @Test
    public void Users_GetAllComments_Success(){

        GoRestService.getAllComments()
                .then()
                .statusCode(SC_OK)
                .body(BackendProperties.userIdPath(), notNullValue());
    }
}
