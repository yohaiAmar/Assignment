package apiProperties;

import apiProperties.pojos.CreateUser;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ApiBase {

    public static RequestSpecification httpRequest;
    public static Response response;
    public static CreateUser createUser;
}
