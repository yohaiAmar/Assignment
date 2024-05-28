package flows;

import webProperties.Setup;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class WebFlows extends Setup {

    public static void validateContactByCompany(String companyTitle,String expectedContact){
        // column is 0 , i wouldnt locate it like that at all but those methods are forced
        // columns: 0 = Company / 1 = Contact / 2 = Country
        boolean result = tableInteractions.verifyTableCellText(w3SchoolPage.getTable(), 0,companyTitle, 1, expectedContact);
        System.out.println("Tests.testVerifyTableCellText >> " + result);
        assertTrue(result, "didnt find the contact ");
    }

    public static void validateContactNameByCompanyByXpath(String companyTitle,String expectedContact){
        // columns: 0 = Company /  1 = Contact /  2 = Country
        String actualText = tableInteractions.getTableCellTextByXpath(w3SchoolPage.getTable(), 0, companyTitle, 1);
        assertEquals(actualText, expectedContact, "Expected text does not match actual text.");
    }


}
