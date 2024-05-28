package flows;

import io.restassured.response.Response;
import apiProperties.ApiSetup;
import apiProperties.enums.Gender;
import apiProperties.enums.Statuses;
import apiProperties.pojos.GetUsers;

import java.util.List;

import static org.testng.Assert.*;

public class ApiFlows extends ApiSetup {

    // using some enums, to show best practices... I really rushed it


    public static String resource = "/public/v2/users";

    public static void createEqualAmountOfWorkers(){
        response = httpRequest.get(resource).prettyPeek();
        assertEquals(response.getStatusCode(), 200, "didnt get the users in createEqualAmountOfWorkers");
        List<GetUsers> users = response.jsonPath().getList("", GetUsers.class);
        List<GetUsers> maleUsers = users.stream().filter(user -> user.getGender().equals(Gender.MALE.toString())).toList();
        List<GetUsers> femaleUsers = users.stream().filter(user -> user.getGender().equals(Gender.FEMALE.toString())).toList();
        System.out.println(users.size() + " amount of users createEqualAmountOfWorkers");
        if (maleUsers.size() > femaleUsers.size()) {
            for (int i = 0; i < maleUsers.size() - femaleUsers.size(); i++) {
                response = httpRequest.header("content-type", "application/json")
                        .body(createUser.setStatus("active")
                                .setEmail(getRandomString() + "@gmail.com") // generate random email
                                .setGender(Gender.FEMALE.toString())
                                .setId("1")
                                .setName(getRandomString()).build()).post(resource); // generate random name
                response.prettyPrint();
                assertEquals(response.getStatusCode(), 201);
            }
        } else if (femaleUsers.size() > maleUsers.size()) {
            for (int i = 0; i < femaleUsers.size() - maleUsers.size(); i++) {
                response = httpRequest.header("content-type", "application/json")
                        .body(createUser.setStatus("active")
                                .setEmail(getRandomString() + "@gmail.com") // generate random email
                                .setGender(Gender.MALE.toString())
                                .setId("1")
                                .setName(getRandomString()).build()).post(resource); // generate random name
                response.prettyPrint();
                assertEquals(response.getStatusCode(), 201);
            }
        }
        response = httpRequest.get(resource);
        response.prettyPrint();
        List<GetUsers> secondUserList = response.jsonPath().getList("", GetUsers.class);
        List<GetUsers> secondMaleUsers = secondUserList.stream().filter(user -> user.getGender().equals("male")).toList();
        List<GetUsers> secondFemaleUsers = secondUserList.stream().filter(user -> user.getGender().equals("female")).toList();
        assertEquals(secondMaleUsers.size(), secondFemaleUsers.size(), "amount of users still wasnt equal");
    }

    public static void deleteInactiveUsers(){
        response = httpRequest.get(resource).prettyPeek();
        assertEquals(response.getStatusCode(), 200);
        List<GetUsers> users = response.jsonPath().getList("", GetUsers.class);
        assertFalse(users.isEmpty());
        System.out.println(users.size() + " size in delete inactive users");
        for (GetUsers user : users) {
            if (user.getStatus().equals(Statuses.INACTIVE.toString())) {
                var id = user.getId();
                response = httpRequest.delete(resource + "/" + id);
                assertEquals(response.getStatusCode(), 200);
            }
        }
        response = httpRequest.get(resource);
        List<GetUsers> validateUsers = response.jsonPath().getList("", GetUsers.class);
        for (GetUsers user : validateUsers) {
            if (user.getStatus().equals(Statuses.INACTIVE.toString())) {
                fail("found a user with inactive status >> " + user.getName());
            }
        }
    }

    public static void emailEndings(){
        Response response = httpRequest.get(resource);
        List<GetUsers> users = response.jsonPath().getList("", GetUsers.class);
        assertFalse(users.isEmpty());
        System.out.println(users.size() + " users size in changing emails");
        assertEquals(response.getStatusCode(), 200);
        for (GetUsers user : users) {
            if (!user.getEmail().endsWith("co.il")) {
                var id = user.getId();
                System.err.println(user.getEmail());
                String[] split = user.getEmail().split("\\.");
                String fixedMail = split[0] + ".co.il";
                Response secondResponse = httpRequest.header("Content-Type", "application/json")
                        .body(createUser.setEmail(fixedMail).build()).patch(resource + "/" + id);
                secondResponse.prettyPrint();
                assertEquals(secondResponse.getStatusCode(), 200, secondResponse.getBody().toString());
            }
        }
        Response responseForValidation = httpRequest.get(resource).prettyPeek();
        assertEquals(responseForValidation.getStatusCode(), 200);
        List<GetUsers> usersValidation = responseForValidation.jsonPath().getList("", GetUsers.class);
        assertFalse(usersValidation.isEmpty());
        System.out.println(usersValidation.size());
        for (GetUsers users1 : usersValidation) {
            System.out.println(users1.getName() + " user in changeEmailValidation");
            if (!users1.getEmail().endsWith("co.il")) {
                fail("user >" + users1.getName() + " still got a different email domain ending > " + users1.getEmail());
            }
        }
    }
}
