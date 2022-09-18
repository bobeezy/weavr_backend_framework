package models;

/**
 * @author lionel mangoua
 * Date: 18/09/22
 */

public class CreateTodosModel {

    private String title;
    private String due_on;
    private String status;

    public CreateTodosModel(String title,
                            String due_on,
                            String status) {
        this.title = title;
        this.due_on = due_on;
        this.status = status;
    }

    //setters
    public void setTitle(String title) {
        this.title = title;
    }

    public void setDueOn(String due_on) {
        this.due_on = due_on;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    //getters
    public String getTitle() {
        return title;
    }

    public String getDueOn() {
        return due_on;
    }

    public String getStatus() {
        return status;
    }
}