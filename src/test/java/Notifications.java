import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Notifications extends BaseTest {

    @Test
    public void notifications() {
        driver.get("http://the-internet.herokuapp.com/notification_message_rendered");
        WebElement click = driver.findElement(By.linkText("Click here"));
        click.click();
        String actionMessage = driver.findElement(By.id("flash")).getText();
        String text1 = "Action unsuccesful, please try again";
        String text2 = "Action successful";

        Assert.assertTrue(actionMessage.contains(text1) || actionMessage.contains(text2), "Wrong action message is displayed");

//        if(actionMessage.contains(text1)||actionMessage.contains(text2)){
//            System.out.println("Passed");;
//        } else{
//            System.out.println("not passed");;
//        }
//
   }

}
