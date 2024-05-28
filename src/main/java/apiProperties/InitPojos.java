package apiProperties;

import apiProperties.pojos.CreateUser;

public class InitPojos extends ApiBase{

    public static void initialize(){
        createUser = new CreateUser();
    }
}
