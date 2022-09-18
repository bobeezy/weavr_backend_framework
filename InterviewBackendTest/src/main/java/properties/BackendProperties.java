package properties;

public class BackendProperties {

    public static String BaseURL() {
        return "https://gorest.co.in";
    }

    public static int UnauthorizedStatusCode() {
        return 401;
    }

    public static int SuccessCode() {
        return 200;
    }

    public static int CreatedSuccessCode() {
        return 201;
    }

    public static String userIdPath() {
        return "data.id";
    }

    public static String userNamePath() {
        return "data.name";
    }

    public static String userEmailPath() {
        return "data.email";
    }

    public static String userGenderPath() {
        return "data.gender";
    }

    public static String userStatusPath() {
        return "data.status";
    }

    public static String postIdPath() {
        return "data.id";
    }

    public static String postUserIdPath() {
        return "data.user_id";
    }

    public static String postTitlePath() {
        return "data.title";
    }

    public static String postBodyPath() {
        return "data.body";
    }

    public static String commentIdPath() {
        return "data.id";
    }

    public static String commentPostIdPath() {
        return "data.post_id";
    }

    public static String commentNamePath() {
        return "data.name";
    }

    public static String commentEmailPath() {
        return "data.email";
    }

    public static String commentBodyPath() {
        return "data.body";
    }

    public static String ValidAccessToken() {
        return "0f3ec1965e086978fa318db859f51424bb66409d9ba2669ebb898ac39b1b3e5c";
    }

    public static String InvalidAccessToken() {
        return "token";
    }

    public static String PublicUserURI() {
        return "/public-api/users";
    }

    public static String createUserURI() {
        return "/public/v1/users";
    }

    public static String getAllUsersURI() {
        return "/public/v1/users";
    }

    public static String userByURI(int userId) {
        return "/public/v1/users/" + userId;
    }

    public static String userPostURI(int userId) {
        return "/public/v1/users/" + userId + "/posts";
    }

    public static String getAllPostsURI() {
        return "/public/v1/users";
    }

    public static String postByURI(int postId) {
        return "/public/v1/users/" + postId + "/posts";
    }

    public static String userCommentURI(int userId) {
        return "/public/v1/posts/" + userId + "/comments";
    }

    public static String getAllCommentsURI() {
        return "/public/v1/comments";
    }

    public static String commentByURI(int postId) {
        return "/public/v1/users/" + postId + "/posts";
    }

    public static String commentByPostIdURI(int postId) {
        return "/public/v1/posts/" + postId + "/comments";
    }

    public static String userCommentURI(String userId) {
        return "/public/v1/users/" + userId + "/comments";
    }

    public static String userTodosURI(String userId) {
        return "/public/v1/users/" + userId + "/todos";
    }
}