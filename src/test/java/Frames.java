import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.awt.*;

public class Frames extends BaseTest{

    @Test
    public void iFrames(){
        driver.get("http://the-internet.herokuapp.com/frames");
        driver.findElement(By.xpath("//a[contains(text(),'iFrame')]")).click();
        driver.switchTo().frame(0);
        String frameText= driver.findElement(By.id("tinymce")).getText();
        Assert.assertEquals(frameText, "Your content goes here.", "frame contains wrong text");


    }
}
