package services;

import io.restassured.response.Response;
import models.CreateUserModel;
import properties.BackendProperties;


public class GoRestService extends BaseService {

    public static Response createUser(final CreateUserModel createUserModel) {
        return defaultRequestSpecification()
                .body(createUserModel)
                .when()
                .post(BackendProperties.CreateUserURI());
    }

//    public static Response createUser(final CreateUserModel createUserModel) {
//        return defaultRequestSpecification()
//                .body(createUserModel)
//                .when()
//                .post("/public/v1/users");
//    }
}
