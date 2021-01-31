import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Menu {

    private WebDriver driver;


    @Before
    public void setupDriver(){
        System.setProperty("webdriver.chrome.driver","resources/chromedriver.exe");
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://testfasttrackit.info/selenium-test/");
    }
    @Test
    public void clickSubcategory() {
        Actions actions = new Actions(driver);
        WebElement target = driver.findElement(By.cssSelector("li.level0:nth-child(2) > a:nth-child(1)"));
        actions.moveToElement(target).perform();
        driver.findElement(By.cssSelector(".nav-2-3 > a:nth-child(1)")).click();
        WebElement message=driver.findElement(By.cssSelector(".page-title > h1:nth-child(1)"));
        Assert.assertEquals("TEES, KNITS AND POLOS",message.getText());

    }

    @After
    public void close(){
        driver.close();
    }


}