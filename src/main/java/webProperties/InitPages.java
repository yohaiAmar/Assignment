package webProperties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pageObjects.TableInteractions;
import pageObjects.W3SchoolPage;

public class InitPages extends Base{

    public static void initPage(WebDriver driver){
        w3SchoolPage = PageFactory.initElements(driver, W3SchoolPage.class);
        tableInteractions = PageFactory.initElements(driver, TableInteractions.class);
    }

}
