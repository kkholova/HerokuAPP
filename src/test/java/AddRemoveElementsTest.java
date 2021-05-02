import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import java.util.List;
import static org.testng.Assert.assertEquals;

public class AddRemoveElementsTest extends BaseTest{


    @Test
    public void elementsCanBeAddedAndRemoved() {
        driver.get("http://the-internet.herokuapp.com/add_remove_elements/");
        WebElement addButton = driver.findElement(By.cssSelector("[onclick = 'addElement()']"));
        addButton.click();
        addButton.click();
        List<WebElement> deleteButton = driver.findElements(By.cssSelector("[onclick = 'deleteElement()']"));
        assertEquals(deleteButton.size(), 2, "Quantity do not match");
        deleteButton.get(1).click();
        deleteButton = driver.findElements(By.cssSelector("[onclick = 'deleteElement()']"));
        assertEquals(deleteButton.size(), 1, "Quantity do not match");
    }


}
