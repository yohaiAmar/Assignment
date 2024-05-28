package webProperties;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.time.Duration;

@Listeners(webProperties.Listeners.class)
public class Setup extends Base{

    public static String getData(String nodeName) {
        DocumentBuilder dBuilder;
        Document doc = null;
        File fXmlFile = new File("configuration/Configuration.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        try {
            dBuilder = dbFactory.newDocumentBuilder();
            doc = dBuilder.parse(fXmlFile);
        } catch (Exception e) {
            System.out.println("Exception in reading XML file: " + e);
        }
        doc.getDocumentElement().normalize();
        return doc.getElementsByTagName(nodeName).item(0).getTextContent();
    }

    // bringing up from xml just to show potential, best practice is not to store any data in the code itself
    // in regular job, you pull everything from the database

    @BeforeClass
    public void setup(){
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        InitPages.initPage(driver);
        driver.get(getData("absoluteUrl"));
        driver.manage().window().maximize();
    }


    @AfterClass
    public void exit(){
        driver.quit();
    }



}
