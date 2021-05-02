import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SortableDataTables extends BaseTest {

    @Test
    public void sortableDataTables(){
            driver.get("http://the-internet.herokuapp.com/tables");
            WebElement cell1 = driver.findElement(By.xpath("//table//tr[3]/td[3]"));
        Assert.assertEquals(cell1.getText(), "jdoe@hotmail.com");
        WebElement sortClick = driver.findElement(By.xpath("//table[1]//span"));
        sortClick.click();
        WebElement cell2 = driver.findElement(By.xpath("//table[1]//tr[4]/td[5]"));
        Assert.assertEquals(cell2.getText(), "http://www.jsmith.com");
        WebElement cell3 = driver.findElement(By.xpath("//table[2]//tr[2]/td[4]"));
        Assert.assertEquals(cell3.getText(), "$51.00");


    }

}
