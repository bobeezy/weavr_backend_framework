import models.CreateCommentModel;
import models.CreatePostModel;
import models.CreateUserModel;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import properties.BackendProperties;
import services.GoRestService;

import static org.apache.http.HttpStatus.*;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;
import static services.BaseService.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CreateUserTests {

//    private String _baseURL = "https://gorest.co.in/";
//    private String _validAccessToken = "tqgiwz-unv8OWaZXfyNqSzEqIp8nYBUi3Pgo"; //0f3ec1965e086978fa318db859f51424bb66409d9ba2669ebb898ac39b1b3e5c
//    private String _invalidAccessToken = "InvalidToken";
    final CreateUserModel createUserModel = new CreateUserModel("John" +  + Math.random() + " Wick" + Math.random(), "male", "qatest" + Math.random() + "@gmail.com", "active");

    @Test
    @Order(1)
    public void Users_CreateUser_Success(){

        GoRestService.createUser(createUserModel)
                .then()
                .statusCode(SC_CREATED)
                .body(BackendProperties.userIdPath(), notNullValue())
                .body(BackendProperties.userNamePath(), equalTo(createUserModel.getName()))
                .body(BackendProperties.userGenderPath(), equalTo(createUserModel.getGender()))
                .body(BackendProperties.userEmailPath(), equalTo(createUserModel.getEmail()))
                .body(BackendProperties.userStatusPath(), equalTo(createUserModel.getStatus()));

        logger.info("Successfully validated Users_CreateUser_Success \n");
    }

    @Test
    @Order(2)
    public void Users_UpdateUser_Success(){

        final CreateUserModel updateUserModel = new CreateUserModel(userName, "female", userEmail, userStatus); //update Gender
        GoRestService.updateUser(updateUserModel, userId)
                .then()
                .statusCode(SC_OK)
                .body(BackendProperties.userIdPath(), notNullValue())
                .body(BackendProperties.userNamePath(), equalTo(updateUserModel.getName()))
                .body(BackendProperties.userGenderPath(), equalTo(updateUserModel.getGender()))
                .body(BackendProperties.userEmailPath(), equalTo(updateUserModel.getEmail()))
                .body(BackendProperties.userStatusPath(), equalTo(updateUserModel.getStatus()));

        logger.info("Successfully validated Users_UpdateUser_Success \n");
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

        logger.info("Successfully validated Users_CreatePost_Success \n");
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

        logger.info("Successfully validated Users_CreateComment_Success \n");
    }

    @Test
    @Order(5)
    public void Users_GetUserById_Success(){

        GoRestService.getUserById(userId)
                .then()
                .statusCode(SC_OK)
                .body(BackendProperties.userIdPath(), notNullValue());

        logger.info("Successfully validated Users_GetUserById_Success \n");
    }

    @Test
    @Order(6)
    public void Users_GetPostById_Success(){

        GoRestService.getPostById(userId)
                .then()
                .statusCode(SC_OK)
                .body(BackendProperties.userIdPath(), notNullValue());

        logger.info("Successfully validated Users_GetPostById_Success \n");
    }

    @Test
    @Order(7)
    public void Users_GetCommentById_Success(){

        GoRestService.getCommentById(postId)
                .then()
                .statusCode(SC_OK)
                .body(BackendProperties.userIdPath(), notNullValue());

        logger.info("Successfully validated Users_GetCommentById_Success \n");
    }

    @Test
    @Order(8)
    public void Users_DeleteUserById_Success(){

        GoRestService.deleteUserById(userId)
                .then()
                .statusCode(SC_NO_CONTENT);

        logger.info("Successfully validated Users_DeleteUserById_Success \n");
    }

    @Test
    @Order(9)
    public void Users_GetAllUsers_Success(){

        GoRestService.getAllUsers()
                .then()
                .statusCode(SC_OK)
                .body(BackendProperties.userIdPath(), notNullValue());

        logger.info("Successfully validated Users_GetAllUsers_Success \n");
    }

    @Test
    public void Users_GetAllPosts_Success(){

        GoRestService.getAllPosts()
                .then()
                .statusCode(SC_OK)
                .body(BackendProperties.userIdPath(), notNullValue());

        logger.info("Successfully validated Users_GetAllPosts_Success \n");
    }

    @Test
    public void Users_GetAllComments_Success(){

        GoRestService.getAllComments()
                .then()
                .statusCode(SC_OK)
                .body(BackendProperties.userIdPath(), notNullValue());

        logger.info("Successfully validated Users_GetAllComments_Success \n");
    }
}
