package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class TableInteractions {

    // i wouldn't use those kinds of methods at all, this structure is not good, robust or flexible,
    // but you asked for it

    public String getTableCellText(WebElement table, int searchColumn, String searchText, int returnColumn) {
        String placeholder = null;
        List<WebElement> rows = table.findElements(By.xpath("./tbody/tr"));
        System.out.println(rows.size() + " rows size");
        for (WebElement row : rows) {
            List<WebElement> cells = row.findElements(By.xpath("./td"));
            System.out.println(cells.size() + " amount of cells");
            if (cells.size() > searchColumn && cells.get(searchColumn).getText().equals(searchText)) {
                placeholder = cells.get(returnColumn).getText();
                break;
            }
        }
        return placeholder;
    }

    public boolean verifyTableCellText(WebElement table, int searchColumn, String searchText, int returnColumn, String expectedText) {
        String actualText = getTableCellText(table, searchColumn, searchText, returnColumn);
        return actualText != null && actualText.equals(expectedText);
    }


    public String getTableCellTextByXpath(WebElement table, int searchColumn, String searchText, int returnColumn) {
        String xpath = ".//tr[td[" + (searchColumn + 1) + "][text()='" + searchText + "']]/td[" + (returnColumn + 1) + "]";
        return table.findElement(By.xpath(xpath)).getText();
    }

}
