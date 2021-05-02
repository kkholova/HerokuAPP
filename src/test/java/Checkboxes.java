import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class Checkboxes extends BaseTest{

    @Test
    public void checkboxes(){
        driver.get("http://the-internet.herokuapp.com/checkboxes");
        List<WebElement> checkboxes = driver.findElements(By.cssSelector("[type = checkbox]"));
        Assert.assertFalse(checkboxes.get(0).isSelected(),"First checkbox already ticked");
        checkboxes.get(0).click();
        Assert.assertTrue(checkboxes.get(0).isSelected(),"First checkbox already ticked");
        Assert.assertTrue(checkboxes.get(1).isSelected(),"Second checkbox is unticked");
        checkboxes.get(1).click();
        Assert.assertFalse(checkboxes.get(1).isSelected(),"Second checkbox is ticked");
    }
}
