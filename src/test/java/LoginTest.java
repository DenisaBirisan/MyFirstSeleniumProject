import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {
    private WebDriver driver;


    @Before
    public void setupDriver(){
        System.setProperty("webdriver.chrome.driver","resources/chromedriver.exe");
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://testfasttrackit.info/selenium-test/");
    }

    @Test
    public void login(){
        driver.findElement(By.cssSelector(".skip-account > span:nth-child(2)")).click();
        driver.findElement(By.cssSelector("div.links:nth-child(1) > ul:nth-child(1) > li:nth-child(6) > a:nth-child(1)")).click();
        driver.findElement((By.cssSelector("#email"))).sendKeys("deni@yahoo.com");
        driver.findElement((By.cssSelector("#pass"))).sendKeys("123456");
        driver.findElement(By.cssSelector("#send2")).click();
        WebElement helloMessage=driver.findElement(By.cssSelector(".hello > strong:nth-child(1)"));
        Assert.assertTrue(helloMessage.isDisplayed());
        Assert.assertEquals("Hello, Deni Test!",helloMessage.getText());



    }

    @Test
    public void loginInvalidEmail(){
        driver.findElement(By.cssSelector(".skip-account > span:nth-child(2)")).click();
        driver.findElement(By.cssSelector("div.links:nth-child(1) > ul:nth-child(1) > li:nth-child(6) > a:nth-child(1)")).click();
        driver.findElement((By.cssSelector("#email"))).sendKeys("d@yahoo.com");
        driver.findElement((By.cssSelector("#pass"))).sendKeys("123456");
        driver.findElement(By.cssSelector("#send2")).click();
        WebElement invalidEmailMessage=driver.findElement(By.cssSelector(".error-msg > ul:nth-child(1) > li:nth-child(1) > span:nth-child(1)"));
        Assert.assertTrue(invalidEmailMessage.isDisplayed());

    }

    @Test
    public void loginWrongPassword(){
        driver.findElement(By.cssSelector(".skip-account > span:nth-child(2)")).click();
        driver.findElement(By.cssSelector("div.links:nth-child(1) > ul:nth-child(1) > li:nth-child(6) > a:nth-child(1)")).click();
        driver.findElement((By.cssSelector("#email"))).sendKeys("deni.b@yahoo.com");
        driver.findElement((By.cssSelector("#pass"))).sendKeys("111111");
        driver.findElement(By.cssSelector("#send2")).click();
        WebElement invalidPassMessage=driver.findElement(By.cssSelector(".error-msg > ul:nth-child(1) > li:nth-child(1) > span:nth-child(1)"));
        Assert.assertTrue(invalidPassMessage.isDisplayed());

    }



    @Test
    public void loginNoEmail(){
        driver.findElement(By.cssSelector(".skip-account > span:nth-child(2)")).click();
        driver.findElement(By.cssSelector("div.links:nth-child(1) > ul:nth-child(1) > li:nth-child(6) > a:nth-child(1)")).click();
        driver.findElement((By.cssSelector("#pass"))).sendKeys("123456");
        driver.findElement(By.cssSelector("#send2")).click();
        WebElement noEmailMessage=driver.findElement(By.cssSelector("#advice-required-entry-email"));
        Assert.assertTrue(noEmailMessage.isDisplayed());
    }

    @Test
    public void loginNoPassword(){
        driver.findElement(By.cssSelector(".skip-account > span:nth-child(2)")).click();
        driver.findElement(By.cssSelector("div.links:nth-child(1) > ul:nth-child(1) > li:nth-child(6) > a:nth-child(1)")).click();
        driver.findElement((By.cssSelector("#email"))).sendKeys("deni.b@yahoo.com");
        driver.findElement(By.cssSelector("#send2")).click();
        WebElement noPassMessage=driver.findElement(By.cssSelector("#advice-required-entry-pass"));
        Assert.assertTrue(noPassMessage.isDisplayed());

    }

    @After
    public void close(){
        driver.close();
    }






}



