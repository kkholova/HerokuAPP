import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Inputs extends BaseTest{

    @Test
    public void inputs(){

        driver.get("http://the-internet.herokuapp.com/inputs");
        WebElement arrowUp = driver.findElement(By.tagName("input"));
        arrowUp.sendKeys("9");
        arrowUp.sendKeys(Keys.ARROW_UP);
        Assert.assertEquals(arrowUp.getAttribute("value"),"10");
        arrowUp.sendKeys(Keys.ARROW_DOWN);
        Assert.assertEquals(arrowUp.getAttribute("value"),"9");
        arrowUp.clear();
        arrowUp.sendKeys("Chars");
        Assert.assertEquals(arrowUp.getAttribute("value"),"", "It is possible to send non digits");


    }
}
