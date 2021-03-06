import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WishListTest {
    private WebDriver driver;


    @Before
    public void setupDriver(){
        System.setProperty("webdriver.chrome.driver","resources/chromedriver.exe");
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://testfasttrackit.info/selenium-test/");
    }

    @Test
    public void addToWishlist(){
        driver.findElement(By.cssSelector("li.level0:nth-child(5) > a:nth-child(1)")).click();
        driver.findElement(By.cssSelector("a.button")).click();
        driver.findElement(By.cssSelector(".link-wishlist")).click();
        WebElement messaje=driver.findElement(By.cssSelector(".page-title > h1:nth-child(1)"));
        Assert.assertTrue(messaje.isDisplayed());

    }
    @After
    public void close(){
        driver.close();
    }




}
