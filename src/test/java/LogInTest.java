import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class LogInTest extends BaseTest{

    @Test
    public void logIn(){
        driver.get("http://the-internet.herokuapp.com/login");
        WebElement username = driver.findElement(By.id("username"));
        username.sendKeys("tomsmith");
        assertEquals(username.getAttribute("value"), "tomsmith", "User was not inserted");
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.className("radius")).click();
        String logInMessage = driver.findElement(By.id("flash")).getText();
        assertEquals(logInMessage,
                "You logged into a secure area!\n" +
                        "×" ,
                "Log In Failed");
    }
}
