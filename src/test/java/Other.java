import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Other {

    private WebDriver driver;


    @Before
    public void setupDriver(){
        System.setProperty("webdriver.chrome.driver","resources/chromedriver.exe");
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://testfasttrackit.info/selenium-test/");
    }

    @Test
    public void addToCompare(){
            driver.findElement(By.cssSelector("li.level0:nth-child(5) > a:nth-child(1)")).click();
            driver.findElement(By.cssSelector(".category-products > div:nth-child(1) > div:nth-child(1) > p:nth-child(1) > a:nth-child(3)")).click();
            WebElement message=driver.findElement(By.cssSelector(".success-msg > ul:nth-child(1) > li:nth-child(1) > span:nth-child(1)"));
            Assert.assertEquals("The product Slim fit Dobby Oxford Shirt has been added to comparison list.",message.getText());
    }

    @Test
    public void showButton() {
        driver.findElement(By.cssSelector("li.level0:nth-child(5) > a:nth-child(1)")).click();
        WebElement mySelectElement = driver.findElement(By.cssSelector(".category-products > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > select:nth-child(2)"));
        Select dropdown= new Select(mySelectElement);
        dropdown.selectByIndex(2);
    }

    @Test
    public void details(){
        WebElement mySelectElement = driver.findElement(By.cssSelector("li.level0:nth-child(1) > a:nth-child(1)"));
        Select dropdown= new Select(mySelectElement);
        dropdown.selectByVisibleText("New Arrivals");

    }
    @After
    public void close(){
        driver.close();
    }


}
