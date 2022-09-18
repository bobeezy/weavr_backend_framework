package models;

/**
 * @author lionel mangoua
 * Date: 18/09/22
 */

public class CreateUserModel {

    private String name;
    private String gender;
    private String email;
    private String status;

    public CreateUserModel(String name,
                           String gender,
                           String email,
                           String status) {
        this.name = name;
        this.gender = gender;
        this.email = email;
        this.status = status;
    }

    //setters
    public void setName(String name) {
        this.name = name;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    //getters
    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public String getEmail() {
        return email;
    }

    public String getStatus() {
        return status;
    }
}