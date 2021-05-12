import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.util.HashMap;
import java.util.List;

public class FileDownload extends BaseTest{

    @Test
// еще не готов
    public void fileDownload(){
        HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
        chromePrefs.put("profile.default_content_settings.popups", 0);
        chromePrefs.put("", System.getProperty("user.dir"));

        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", chromePrefs);

        driver.get("http://the-internet.herokuapp.com/download");
        List<WebElement> list =driver.findElements(By.xpath("//div[@class = 'example']//child::a"));
        WebElement file = list.get(3);
        file.click();
        File folder = new File(System.getProperty("user.dir"));

//List the files on that folder
        File[] listOfFiles = folder.listFiles();
        boolean found = false;
        File f = null;
        //Look for the file in the files
        // You should write smart REGEX according to the filename
        for (File listOfFile : listOfFiles) {
            if (listOfFile.isFile()) {
                String fileName = listOfFile.getName();
                System.out.println("File " + listOfFile.getName());
                if (fileName.matches("test.png")) {
                    f = new File(fileName);
                    found = true;
                }
            }
        }
        Assert.assertTrue(found, "Downloaded document is not found");





    }
}
