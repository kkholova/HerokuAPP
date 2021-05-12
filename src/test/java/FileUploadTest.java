import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;

public class FileUploadTest extends BaseTest {

    @Test
    public void fileUpload() {

        driver.get("http://the-internet.herokuapp.com/upload");
        File file = new File("src/test/resources/SomeFile.txt");
        driver.findElement(By.id("file-upload")).sendKeys(file.getAbsolutePath());
//        все реcурсы должны лежать в гите
        driver.findElement(By.id("file-submit")).click();
//        add loader
//        applitools.com
        String fileName = driver.findElement(By.id("uploaded-files")).getText();
        Assert.assertEquals(fileName, "SomeFile.txt", "File was not uploaded");

    }
}
