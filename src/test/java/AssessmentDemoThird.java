import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class AssessmentDemoThird {

    @Test
    public void thirdTestCase() {
            System.setProperty("webdriver.chrome.driver", "/Users/darwinpatel/Desktop/Apps/Chromdriver/chromedriver");
            WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("http://jupiter.cloud.planittesting.com");
            driver.findElement(By.linkText("Shop")).click();
            driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

            int item;
            for(item=0;item<2;item++) {
                driver.findElement(By.xpath("/html/body/div[2]/div/ul/li[2]/div/p/a")).click();
            }

            for(item=0;item<5;item++) {
                driver.findElement(By.xpath("/html/body/div[2]/div/ul/li[4]/div/p")).click();
            }

            for(item=0;item<3;item++) {
                driver.findElement(By.xpath("/html/body/div[2]/div/ul/li[7]/div/p/a")).click();
            }

            driver.findElement(By.partialLinkText("Cart")).click();

        //expected error text

        String expPriceStuffedFrog = "$10.99";
        expPriceStuffedFrog = expPriceStuffedFrog.substring(1);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebElement quantitySF = driver.findElement(By.xpath("/html/body/div[2]/div/form/table/tbody/tr[1]/td[3]/input"));
        String quantityStuffedFrog = quantitySF.getAttribute("value");
        String expStuffedFrog = String.valueOf(Float.parseFloat(expPriceStuffedFrog) * Float.parseFloat(quantityStuffedFrog));
        //identify actual error message
        WebElement totalStuffedFrog = driver.findElement(By.xpath("/html/body/div[2]/div/form/table/tbody/tr[1]/td[4]"));
        WebElement priceStuffedFrog = driver.findElement(By.xpath("/html/body/div[2]/div/form/table/tbody/tr[1]/td[2]"));

        String actStuffedFrog = totalStuffedFrog.getText();
        String actPriceStuffedFrog = priceStuffedFrog.getText();

        System.out.println("Stuffed Frog subtotal is: " + actStuffedFrog);
        System.out.println("Stuffed Frog price is: " + actPriceStuffedFrog);

        //verify error message with Assertion
        expStuffedFrog = "$"+expStuffedFrog;
        Assert.assertEquals(expStuffedFrog, actStuffedFrog);
        expPriceStuffedFrog = "$"+expPriceStuffedFrog;
        Assert.assertEquals(expPriceStuffedFrog, actPriceStuffedFrog);

        //expected error text
        String expPriceFluffyBunny = "$9.99";
        expPriceFluffyBunny = expPriceFluffyBunny.substring(1);

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebElement quantityFB = driver.findElement(By.xpath("/html/body/div[2]/div/form/table/tbody/tr[2]/td[3]/input"));
        String quantityFluffyBunny = quantityFB.getAttribute("value");
        float floatRounding = (float) (Math.round(Float.parseFloat(expPriceFluffyBunny) * Float.parseFloat(quantityFluffyBunny) * 100.0) / 100.0);
        String expFluffyBunny = String.valueOf(floatRounding);

        //identify actual error message
        WebElement totalFluffyBunny = driver.findElement(By.xpath("/html/body/div[2]/div/form/table/tbody/tr[2]/td[4]"));
        WebElement priceFluffyBunny = driver.findElement(By.xpath("/html/body/div[2]/div/form/table/tbody/tr[2]/td[2]"));

        String actFluffyBunny = totalFluffyBunny.getText();
        String actPriceFluffyBunny = priceFluffyBunny.getText();

        System.out.println("Fluffy Bunny subtotal is: " + actFluffyBunny);
        System.out.println("Fluffy Bunny price is: " + actPriceFluffyBunny);

        //verify error message with Assertion
        expFluffyBunny = "$"+expFluffyBunny;
        Assert.assertEquals(expFluffyBunny, actFluffyBunny);
        expPriceFluffyBunny = "$"+expPriceFluffyBunny;
        Assert.assertEquals(expPriceFluffyBunny, actPriceFluffyBunny);

        //expected error text
        String expPriceValentineBear = "$14.99";
        expPriceValentineBear = expPriceValentineBear.substring(1);

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebElement quantityVB = driver.findElement(By.xpath("/html/body/div[2]/div/form/table/tbody/tr[3]/td[3]/input"));
        String quantityValentineBear = quantityVB.getAttribute("value");
        String expValentineBear = String.valueOf(Float.parseFloat(expPriceValentineBear) * Float.parseFloat(quantityValentineBear));

        //identify actual error message
        WebElement totalValentineBear = driver.findElement(By.xpath("/html/body/div[2]/div/form/table/tbody/tr[3]/td[4]"));
        WebElement priceValentineBear = driver.findElement(By.xpath("/html/body/div[2]/div/form/table/tbody/tr[3]/td[2]"));

        String actValentineBear = totalValentineBear.getText();
        String actPriceValentineBear = priceValentineBear.getText();

        System.out.println("Valentine Bear subtotal is: " + actValentineBear);
        System.out.println("Valentine Bear price is: " + actPriceValentineBear);

        //verify error message with Assertion
        expValentineBear = "$"+expValentineBear;
        Assert.assertEquals(expValentineBear, actValentineBear);
        expPriceValentineBear = "$"+expPriceValentineBear;
        Assert.assertEquals(expPriceValentineBear, actPriceValentineBear);

        //Final checkout total

        actStuffedFrog = actStuffedFrog.substring(1);
        actFluffyBunny = actFluffyBunny.substring(1);
        actValentineBear = actValentineBear.substring(1);


        String expTotalAmount = String.valueOf(Float.parseFloat(actStuffedFrog) + Float.parseFloat(actFluffyBunny) + Float.parseFloat(actValentineBear));
        WebElement totalCheckout = driver.findElement(By.xpath("/html/body/div[2]/div/form/table/tfoot/tr[1]/td/strong"));
        String actTotalAmount = totalCheckout.getText();
        actTotalAmount = actTotalAmount.substring(7);
        System.out.println("Total Checkout Amount is : " + actTotalAmount);
        System.out.println("Total Checkout Amount through expected total: " + expTotalAmount);
        Assert.assertEquals(expTotalAmount, actTotalAmount);

    }

}


