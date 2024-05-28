package apiTests;

import flows.ApiFlows;
import org.testng.annotations.Test;
import apiProperties.ApiSetup;

public class ApiTesting extends ApiSetup {


    @Test(description = "create an equal amount of workers", priority = 1)
    public void createEqualAmountOfWorkers() {
        ApiFlows.createEqualAmountOfWorkers();
    }


    @Test(description = "delete inactive users", priority = 2)
    public void deleteInactiveUsers() {
        ApiFlows.deleteInactiveUsers();
    }


    @Test(description = "change all email endings to co.il", priority = 3)
    public void changeEmailEndings(){
        ApiFlows.emailEndings();
    }


}
