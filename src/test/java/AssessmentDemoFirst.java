import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

public class AssessmentDemoFirst {

    @Test
    public void firstTestCase() {
            System.setProperty("webdriver.chrome.driver", "/Users/darwinpatel/Desktop/Apps/Chromdriver/chromedriver");
            WebDriver driver = new ChromeDriver();      //initialise chrome browser
            driver.manage().window().maximize();        //maxmise window

            driver.get("http://jupiter.cloud.planittesting.com");       //visit the given URL
            driver.findElement(By.linkText("Contact")).click();         //visit contact page through linkText locator
            driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);     //allow wait to load elements
            driver.findElement(By.xpath("/html/body/div[2]/div/form/div/a")).click();   //click submit button to generate error fields

            String exp = "We welcome your feedback - but we won't get it unless you complete the form correctly.";  //expected error text
            WebElement message = driver.findElement(By.className("alert-error"));       //identify actual error message
            String act = message.getText();     //grab actual text

            System.out.println("Error message is: " + act);
            Assert.assertEquals(exp, act);      //verify error message with Assertion

            //enter form fields | locate elements by id | input values using senKeys()
            driver.findElement(By.id("forename")).sendKeys("Darvin Patel");
            driver.findElement(By.id("email")).sendKeys("darvindpatel@gmail.com");
            driver.findElement(By.id("message")).sendKeys("Excellent products, would buy again!");

            String exp2 = "We welcome your feedback - tell it how it is.";      //expected text
            WebElement message2 = driver.findElement(By.className("alert-info"));        //identify actual text message
            String act2 = message2.getText();   //grab the new message

            System.out.println("Message is: " + act2);
            Assert.assertEquals(exp2, act2);    //verify error message with Assertion

    }

}


