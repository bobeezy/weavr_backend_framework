package models;

/**
 * @author lionel mangoua
 * Date: 18/09/22
 */

public class CreateCommentModel {

    private int user_id;
    private int post_id;
    private String name;
    private String email;
    private String body;

    public CreateCommentModel(int post_id,
                              String name,
                              String email,
                              String body) {
        this.post_id = post_id;
        this.name = name;
        this.email = email;
        this.body = body;
    }

    //setters
    public void setPostId(int post_id) {
        this.post_id = post_id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setBody(String body) {
        this.body = body;
    }

    //getters
    public int getPostId() {
        return post_id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getBody() {
        return body;
    }
}