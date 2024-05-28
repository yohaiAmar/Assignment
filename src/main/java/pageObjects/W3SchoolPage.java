package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class W3SchoolPage {

    @FindBy(xpath = "//table[@id='customers']")
    private WebElement tableElement;

    // i wanted to implement everything differently, but you forced different methods

//    private int locateColumn(String columnTitle){
//        int index = 0;
//        List<WebElement> columns = tableElement.findElements(By.xpath("./tbody/tr[1]/th"));
//        for (int i = 0; i < columns.size(); i++) {
//            if (columns.get(i).getText().equals(columnTitle)){
//                index = i;
//                break;
//            }
//        }
//        return index + 1;
//    }

    public WebElement getTable(){
        return tableElement;
    }

}
