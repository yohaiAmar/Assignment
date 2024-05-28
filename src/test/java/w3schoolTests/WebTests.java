package w3schoolTests;

import flows.WebFlows;
import org.testng.annotations.Test;
import webProperties.Setup;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class WebTests extends Setup {

    @Test
    public void validateContactNameByCompany() {
        WebFlows.validateContactByCompany("Island Trading","Helen Bennett");
    }

    @Test
    public void validateContactNameByCompanyByXpath() {
        WebFlows.validateContactNameByCompanyByXpath("Island Trading","Helen Bennett");
    }



}
