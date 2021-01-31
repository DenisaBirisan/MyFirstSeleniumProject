import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Products {

    private WebDriver driver;


    @Before
    public void setupDriver(){
        System.setProperty("webdriver.chrome.driver","resources/chromedriver.exe");
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://testfasttrackit.info/selenium-test/");
    }

    @Test
    public void clickOnProduct() {
        Actions actions = new Actions(driver);
        WebElement target = driver.findElement(By.cssSelector("li.level0:nth-child(2) > a:nth-child(1)"));
        actions.moveToElement(target).perform();
        driver.findElement(By.cssSelector(".nav-2-3 > a:nth-child(1)")).click();
        driver.findElement(By.cssSelector(".products-grid > li:nth-child(1) > div:nth-child(2) > div:nth-child(5) > a:nth-child(1)")).click();
        WebElement element=driver.findElement(By.cssSelector(".product > strong:nth-child(1)"));
        Assert.assertTrue(element.isDisplayed());

    }

    @Test
    public void selectSizeL() {
        Actions actions = new Actions(driver);
        WebElement target = driver.findElement(By.cssSelector("li.level0:nth-child(2) > a:nth-child(1)"));
        actions.moveToElement(target).perform();
        driver.findElement(By.cssSelector(".nav-2-3 > a:nth-child(1)")).click();
        driver.findElement(By.cssSelector("li.item:nth-child(2) > div:nth-child(2) > div:nth-child(4) > a:nth-child(1)")).click();
        driver.findElement(By.cssSelector("#swatch79 > span:nth-child(1)")).click();
        WebElement element=driver.findElement(By.cssSelector("#select_label_size"));
        Assert.assertTrue(element.isDisplayed());

    }

    @Test
    public void viewProductsAsList() {
        Actions actions = new Actions(driver);
        WebElement target = driver.findElement(By.cssSelector("li.level0:nth-child(2) > a:nth-child(1)"));
        actions.moveToElement(target).perform();
        driver.findElement(By.cssSelector(".nav-2-3 > a:nth-child(1)")).click();
        driver.findElement(By.cssSelector(".category-products > div:nth-child(1) > div:nth-child(1) > p:nth-child(1) > a:nth-child(3)")).click();
        WebElement message=driver.findElement(By.cssSelector("li.item:nth-child(3) > div:nth-child(2) > div:nth-child(1) > div:nth-child(4)"));
        Assert.assertTrue(message.isDisplayed());



    }
    @After
    public void close(){
        driver.close();
    }


}