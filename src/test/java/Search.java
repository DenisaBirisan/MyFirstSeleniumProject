import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Search {
    private WebDriver driver;


    @Before
    public void setupDriver(){
        System.setProperty("webdriver.chrome.driver","resources/chromedriver.exe");
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://testfasttrackit.info/selenium-test/");
    }

    @Test
    public void searchItem() {
        driver.findElement(By.cssSelector("#search")).sendKeys("BIJUERIE");
        driver.findElement(By.cssSelector("html#top.js.no-touch.localstorage.no-ios body.cms-index-index.cms-home div.wrapper div.page header#header.page-header div.page-header-container div#header-search.skip-content form#search_mini_form div.input-box button.button.search-button")).click();
        WebElement message=driver.findElement(By.cssSelector(".page-title > h1:nth-child(1)"));
        Assert.assertEquals("SEARCH RESULTS FOR 'BIJUERIE'",message.getText());
    }
    @After
    public void close(){
        driver.close();
    }

}