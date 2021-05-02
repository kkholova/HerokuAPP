import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpHeaders;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.List;
import java.util.Optional;

public class Hovers extends BaseTest {

    @Test

    public void hovers() {
        driver.get("http://the-internet.herokuapp.com/hovers");
        Actions action = new Actions(driver);
        List<WebElement> users = driver.findElements(By.className("figure"));
        action.moveToElement(users.get(0)).build().perform();
        Assert.assertEquals(users.get(0).getText(), "name: user1\n" +
                "View profile");
        action.moveToElement(users.get(1)).build().perform();
        Assert.assertEquals(users.get(1).getText(), "name: user2\n" +
                "View profile");
        action.moveToElement(users.get(2)).build().perform();
        Assert.assertEquals(users.get(2).getText(), "name: user3\n" +
                "View profile");
        WebElement viewProfile1 = driver.findElement(By.linkText("View profile"));
        viewProfile1.click();

        try
        {
            String pageSource = driver.getPageSource();
            Assert.assertTrue(pageSource.contains("Not Found"), "No error message");
        }
        catch (NoAlertPresentException Ex)
        {
        }




    }

}
