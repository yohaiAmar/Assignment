package apiProperties.pojos;

import org.json.simple.JSONObject;

import static apiProperties.ApiBase.createUser;


public class CreateUser {
    String id;
    String name;
    String email;
    String gender;
    String status;

    JSONObject object = new JSONObject();
    public JSONObject build(){
        return object;
    }

    public CreateUser setId(String id) {
        this.id = id;
        object.put("id",id);
        return createUser;
    }

    public CreateUser setName(String name) {
        this.name = name;
        object.put("name",name);
        return createUser;
    }

    public CreateUser setEmail(String email) {
        this.email = email;
        object.put("email",email);
        return createUser;
    }

    public CreateUser setGender(String gender) {
        this.gender = gender;
        object.put("gender",gender);
        return createUser;
    }

    public CreateUser setStatus(String status) {
        this.status = status;
        object.put("status",status);
        return createUser;
    }




}
