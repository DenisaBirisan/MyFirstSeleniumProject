import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Cart {

    private WebDriver driver;

    @Before
    public void setupDriver(){
        System.setProperty("webdriver.chrome.driver","resources/chromedriver.exe");
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://testfasttrackit.info/selenium-test/");
    }

    @Test
    public void addToCart() {
        Actions actions = new Actions(driver);
        WebElement target = driver.findElement(By.cssSelector("li.level0:nth-child(2) > a:nth-child(1)"));
        actions.moveToElement(target).perform();
        driver.findElement(By.cssSelector(".nav-2-3 > a:nth-child(1)")).click();
        driver.findElement(By.cssSelector("li.last:nth-child(1) > div:nth-child(2) > div:nth-child(4) > a:nth-child(1)")).click();
        driver.findElement(By.cssSelector("#swatch27 > span:nth-child(1) > img:nth-child(1)")).click();
        driver.findElement(By.cssSelector("#swatch79 > span:nth-child(1)")).click();
        driver.findElement(By.cssSelector("button.btn-cart:nth-child(1) > span:nth-child(1) > span:nth-child(1)")).click();
        WebElement cartMessage=driver.findElement(By.cssSelector(".success-msg > ul:nth-child(1) > li:nth-child(1) > span:nth-child(1)"));
        Assert.assertEquals("Chelsea Tee was added to your shopping cart.",cartMessage.getText());

    }

    @Test
    public void addToCartFromProductDetails() {
        driver.findElement(By.cssSelector("li.level0:nth-child(2) > a:nth-child(1)")).click();
        driver.findElement(By.cssSelector("li.item:nth-child(1) > div:nth-child(2) > div:nth-child(4) > a:nth-child(1)")).click();
        driver.findElement(By.cssSelector("#swatch78 > span:nth-child(1)")).click();
        driver.findElement(By.cssSelector("#swatch20 > span:nth-child(1) > img:nth-child(1)")).click();
        driver.findElement(By.cssSelector("#swatch80 > span:nth-child(1)"));
        driver.findElement(By.cssSelector("button.btn-cart:nth-child(1) > span:nth-child(1) > span:nth-child(1)")).click();
        WebElement cartMessage=driver.findElement(By.cssSelector(".success-msg > ul:nth-child(1) > li:nth-child(1) > span:nth-child(1)"));
        Assert.assertTrue(cartMessage.isDisplayed());

    }

    @Test
    public void emptyCart() {
        Actions actions = new Actions(driver);
        WebElement target = driver.findElement(By.cssSelector("li.level0:nth-child(2) > a:nth-child(1)"));
        actions.moveToElement(target).perform();
        driver.findElement(By.cssSelector(".nav-2-3 > a:nth-child(1)")).click();
        driver.findElement(By.cssSelector("li.last:nth-child(1) > div:nth-child(2) > div:nth-child(4) > a:nth-child(1)")).click();
        driver.findElement(By.cssSelector("#swatch27 > span:nth-child(1) > img:nth-child(1)")).click();
        driver.findElement(By.cssSelector("#swatch79 > span:nth-child(1)")).click();
        driver.findElement(By.cssSelector("button.btn-cart:nth-child(1) > span:nth-child(1) > span:nth-child(1)")).click();
        driver.findElement(By.cssSelector("#empty_cart_button > span:nth-child(1) > span:nth-child(1)")).click();
        WebElement emptyCartMessage=driver.findElement(By.cssSelector(".page-title > h1:nth-child(1)"));
        Assert.assertTrue(emptyCartMessage.isDisplayed());



    }
    @After
    public void close(){
        driver.close();
    }
}