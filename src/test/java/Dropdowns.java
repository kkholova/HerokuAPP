import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class Dropdowns extends BaseTest{

    @Test
    public void dropdowns(){
        driver.get("http://the-internet.herokuapp.com/dropdown");
        WebElement dropdown = driver.findElement(By.id("dropdown"));
        Select select = new Select(dropdown);
        select.selectByVisibleText("Option 1");
        String textOfFirstDrop =select.getFirstSelectedOption().getText();
        Assert.assertEquals(textOfFirstDrop, "Option 1", "Wrong text in first option");

        select.selectByVisibleText("Option 2");
        String textOfSecondDrop =select.getFirstSelectedOption().getText();
        Assert.assertEquals(textOfSecondDrop, "Option 2");

        List<WebElement> allOptions = select.getOptions();
        Assert.assertEquals(allOptions.get(0).getText(), "Please select an option", "Empty value text is missed");
        Assert.assertEquals(allOptions.get(1).getText(), "Option 1", "1st option text is missed");
        Assert.assertEquals(allOptions.get(2).getText(), "Option 2", "2d option text is missed");



    }
}
