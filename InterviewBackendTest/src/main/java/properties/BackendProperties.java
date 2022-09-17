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

    public static String CreateUserURI() {
        return "/public/v1/users";
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

    public static String userURI(String userId) {
        return "/public/v1/users/" + userId;
    }

    public static String userPostURI(String userId) {
        return "/public/v1/users/" + userId + "/posts";
    }

    public static String userCommentURI(String userId) {
        return "/public/v1/users/" + userId + "/comments";
    }

    public static String userTodosURI(String userId) {
        return "/public/v1/users/" + userId + "/todos";
    }
}