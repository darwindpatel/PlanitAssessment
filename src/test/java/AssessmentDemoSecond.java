import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class AssessmentDemoSecond {

    @Test
    public void secondTestCase() {
            System.setProperty("webdriver.chrome.driver", "/Users/darwinpatel/Desktop/Apps/Chromdriver/chromedriver");
            WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("http://jupiter.cloud.planittesting.com");
            driver.findElement(By.linkText("Contact")).click();
            driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

            //enter mandatory fields
            driver.findElement(By.id("forename")).sendKeys("Darvin Patel");
            driver.findElement(By.id("email")).sendKeys("darvindpatel@gmail.com");
            driver.findElement(By.id("message")).sendKeys("Excellent products, would buy again!");

            driver.findElement(By.xpath("/html/body/div[2]/div/form/div/a")).click();
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        //expected error text
        String exp = "Thanks Darvin Patel, we appreciate your feedback.";
        //identify actual error message
        WebElement message = driver.findElement(By.className("alert-success"));
        String act = message.getText();
        System.out.println("Message is: " + act);
        //verify error message with Assertion
        Assert.assertEquals(exp, act);



    }

}


