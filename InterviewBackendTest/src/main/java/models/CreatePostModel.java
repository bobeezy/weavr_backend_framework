package models;

/**
 * @author lionel mangoua
 * Date: 18/09/22
 */

public class CreatePostModel {

    private String title;
    private String body;

    public CreatePostModel(String title,
                           String body) {
        this.title = title;
        this.body = body;
    }

    //setters
    public void setTitle(String title) {
        this.title = title;
    }

    public void setBody(String body) {
        this.body = body;
    }

    //getters
    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }
}