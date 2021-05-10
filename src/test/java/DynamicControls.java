import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DynamicControls extends BaseTest {

    @Test

    public void dynamicControls(){
        driver.get("http://the-internet.herokuapp.com/dynamic_controls");
        Actions actions = new Actions(driver);
        actions.contextClick(driver.findElement(By.id("checkbox"))).build().perform();
        driver.findElement(By.cssSelector("[onclick = 'swapCheckbox()']")).click();
        String checkboxIsGoneText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message"))).getText();
        Assert.assertEquals(checkboxIsGoneText, "It's gone!", "Check box was not removed");
        Assert.assertTrue(wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("checkbox"))), "Checkbox is still displayed");
        wait.until(ExpectedConditions.attributeToBe(By.tagName("input"), "disabled","true"));
        driver.findElement(By.cssSelector("[onclick = 'swapInput()']")).click();
        String inputIsEnablesText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message"))).getText();
        Assert.assertEquals(inputIsEnablesText, "It's enabled!", "Input is not enabled");
        wait.until(ExpectedConditions.attributeToBe(By.tagName("input"), "disabled",""));

    }

}
