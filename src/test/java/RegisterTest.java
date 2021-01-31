import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class RegisterTest {
    private WebDriver driver;

    @Before
    public void setupDriver(){
        System.setProperty("webdriver.chrome.driver","resources/chromedriver.exe");
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://testfasttrackit.info/selenium-test/");
    }

    @Test
    public void register(){
        driver.findElement(By.cssSelector(".skip-account > span:nth-child(2)")).click();
        WebElement mySelectElement = driver.findElement(By.cssSelector(".skip-account"));
        Select dropdown= new Select(mySelectElement);
        dropdown.selectByIndex(4);
        driver.findElement(By.cssSelector("#firstname")).sendKeys("Den");
        driver.findElement(By.cssSelector("#lastname")).sendKeys("Den");
        driver.findElement(By.cssSelector("#email_address")).sendKeys("denden@yahoo.com");
        driver.findElement(By.cssSelector("#password")).sendKeys("123456");
        driver.findElement(By.cssSelector("#confirmation")).sendKeys("123456");
        driver.findElement(By.cssSelector("#is_subscribed")).click();
    }

    @Test
    public void registerWrongEmailFormat(){
        driver.findElement(By.cssSelector(".skip-account > span:nth-child(2)")).click();
        driver.findElement(By.cssSelector("div.links:nth-child(1) > ul:nth-child(1) > li:nth-child(5) > a:nth-child(1)")).click();
        driver.findElement(By.cssSelector("#lastname")).sendKeys("Den");
        driver.findElement(By.cssSelector("#email_address")).sendKeys("denden.com");
        driver.findElement(By.cssSelector("#password")).sendKeys("123456");
        driver.findElement(By.cssSelector("#confirmation")).sendKeys("123456");
        driver.findElement(By.cssSelector("#is_subscribed")).click();
        WebElement element=driver.findElement(By.cssSelector(".page-title > h1:nth-child(1)"));
        Assert.assertTrue(element.isDisplayed());
    }

    @Test
    public void registerShortPassword(){
        driver.findElement(By.cssSelector(".skip-account > span:nth-child(2)")).click();
        driver.findElement(By.cssSelector("div.links:nth-child(1) > ul:nth-child(1) > li:nth-child(5) > a:nth-child(1)")).click();
        driver.findElement(By.cssSelector("#firstname")).sendKeys("Den");
        driver.findElement(By.cssSelector("#lastname")).sendKeys("Den");
        driver.findElement(By.cssSelector("#email_address")).sendKeys("denden@yahoo.com");
        driver.findElement(By.cssSelector("#password")).sendKeys("12");
        driver.findElement(By.cssSelector("#confirmation")).sendKeys("12");
        driver.findElement(By.cssSelector("button.validation-passed")).click();
        WebElement message= driver.findElement(By.cssSelector("#advice-validate-password-password"));
        Assert.assertTrue(message.isDisplayed());    }

    @Test
    public void registerWorngConfirmation(){
        driver.findElement(By.cssSelector(".skip-account > span:nth-child(2)")).click();
        driver.findElement(By.cssSelector("div.links:nth-child(1) > ul:nth-child(1) > li:nth-child(5) > a:nth-child(1)")).click();

        driver.findElement(By.cssSelector("#firstname")).sendKeys("Den");
        driver.findElement(By.cssSelector("#lastname")).sendKeys("Den");
        driver.findElement(By.cssSelector("#email_address")).sendKeys("denden@yahoo.com");
        driver.findElement(By.cssSelector("#password")).sendKeys("123456");
        driver.findElement(By.cssSelector("#confirmation")).sendKeys("1234567");
        driver.findElement(By.cssSelector("button.validation-passed > span:nth-child(1) > span:nth-child(1)")).click();
        WebElement message= driver.findElement(By.cssSelector("#advice-validate-cpassword-confirmation"));
        Assert.assertTrue(message.isDisplayed());

    }

    @Test
    public void registerNoFirstName(){

        driver.findElement(By.cssSelector(".skip-account > span:nth-child(2)")).click();
        driver.findElement(By.cssSelector("div.links:nth-child(1) > ul:nth-child(1) > li:nth-child(5) > a:nth-child(1)")).click();
        driver.findElement(By.cssSelector("#lastname")).sendKeys("Den");
        driver.findElement(By.cssSelector("#email_address")).sendKeys("denden@yahoo.com");
        driver.findElement(By.cssSelector("#password")).sendKeys("123456");
        driver.findElement(By.cssSelector("#confirmation")).sendKeys("123456");
        driver.findElement(By.cssSelector("button.validation-passed > span:nth-child(1) > span:nth-child(1)")).click();
        WebElement message=driver.findElement(By.cssSelector("#advice-required-entry-firstname"));
        Assert.assertTrue(message.isDisplayed());

    }
    @After
    public void close(){
        driver.close();
    }




}
