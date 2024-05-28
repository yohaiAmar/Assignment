package apiProperties.pojos;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GetUsers {

    @JsonProperty(value = "id")
    String id;
    @JsonProperty(value = "name")
    String name;
    @JsonProperty(value = "email")
    String email;
    @JsonProperty(value = "gender")
    String gender;
    @JsonProperty(value = "status")
    String status;


    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getGender() {
        return gender;
    }

    public String getStatus() {
        return status;
    }


}
