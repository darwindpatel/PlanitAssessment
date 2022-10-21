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
            WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("http://jupiter.cloud.planittesting.com");
            driver.findElement(By.linkText("Contact")).click();
            driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
            driver.findElement(By.xpath("/html/body/div[2]/div/form/div/a")).click();

            //expected error text
            String exp = "We welcome your feedback - but we won't get it unless you complete the form correctly.";
            //identify actual error message
            WebElement message = driver.findElement(By.className("alert-error"));
            String act = message.getText();
            System.out.println("Error message is: " + act);
            //verify error message with Assertion
            Assert.assertEquals(exp, act);
            driver.findElement(By.id("forename")).sendKeys("Darvin Patel");
            driver.findElement(By.id("email")).sendKeys("darvindpatel@gmail.com");
            driver.findElement(By.id("message")).sendKeys("Excellent products, would buy again!");

            //expected text
            String exp2 = "We welcome your feedback - tell it how it is.";
            //identify actual text message
            WebElement message2 = driver.findElement(By.className("alert-info"));
            String act2 = message2.getText();
            System.out.println("Message is: " + act2);
            //verify error message with Assertion
            Assert.assertEquals(exp2, act2);

    }

}


