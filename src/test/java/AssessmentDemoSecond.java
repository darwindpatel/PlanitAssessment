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
            WebDriver driver = new ChromeDriver();  //initialize chrome browser
            driver.manage().window().maximize();    //maximize window
            driver.get("http://jupiter.cloud.planittesting.com");   //visit the URL
            driver.findElement(By.linkText("Contact")).click();     //click on contact page using linkText
            driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

            //enter mandatory fields
            driver.findElement(By.id("forename")).sendKeys("Darvin Patel");
            driver.findElement(By.id("email")).sendKeys("darvindpatel@gmail.com");
            driver.findElement(By.id("message")).sendKeys("Excellent products, would buy again!");

            driver.findElement(By.xpath("/html/body/div[2]/div/form/div/a")).click();
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

            String exp = "Thanks Darvin Patel, we appreciate your feedback.";    //expected error text
            WebElement message = driver.findElement(By.className("alert-success")); //identify actual error message
            String act = message.getText();
            System.out.println("Message is: " + act);
            Assert.assertEquals(exp, act);  //verify error message with Assertion

    }

}


