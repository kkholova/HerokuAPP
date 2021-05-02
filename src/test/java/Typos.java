import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;


import java.util.List;

public class Typos extends BaseTest {

    @Test

    public void typos() {
        driver.get("http://the-internet.herokuapp.com/typos");
        List<WebElement> text = driver.findElements(By.tagName("p"));
         Assert.assertEquals(text.get(1).getText(), "Sometimes you'll see a typo, other times you won't.", "text has a typo");

    }
}
