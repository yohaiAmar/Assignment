package apiProperties;

import io.restassured.RestAssured;
import io.restassured.authentication.OAuthSignature;
import io.restassured.filter.log.LogDetail;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.Random;

@Listeners(webProperties.Listeners.class)
public class ApiSetup extends ApiBase {

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


    @BeforeClass
    public void setup(){
        RestAssured.baseURI = "https://gorest.co.in";
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails(LogDetail.ALL);
        httpRequest = RestAssured.given().auth().oauth2(getData("restGoApiToken"), OAuthSignature.HEADER);
        InitPojos.initialize();
    }


    // just to generate a random email for the user
    public static String getRandomString() {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder stringBuilder = new StringBuilder();
        Random rnd = new Random();
        while (stringBuilder.length() < 10) { // length of the random string.
            int index = (int) (rnd.nextFloat() * chars.length());
            stringBuilder.append(chars.charAt(index));
        }
        return stringBuilder.toString();

    }



}
