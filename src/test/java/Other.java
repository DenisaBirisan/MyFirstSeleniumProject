import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Other {
    public void addToCompare(){
            WebDriver driver=new ChromeDriver();
            driver.get("http://testfasttrackit.info/selenium-test/");
            driver.findElement(By.cssSelector("li.level0:nth-child(5) > a:nth-child(1)")).click();
            driver.findElement(By.cssSelector(".category-products > div:nth-child(1) > div:nth-child(1) > p:nth-child(1) > a:nth-child(3)")).click();
            driver.close();
    }

    public void showButton() {
        WebDriver driver = new ChromeDriver();
        driver.get("http://testfasttrackit.info/selenium-test/");
        driver.findElement(By.cssSelector("li.level0:nth-child(5) > a:nth-child(1)")).click();
        WebElement mySelectElement = driver.findElement(By.cssSelector(".category-products > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > select:nth-child(2)"));
        Select dropdown= new Select(mySelectElement);
        dropdown.selectByIndex(2);
        driver.close();
    }

    public void details(){
        WebDriver driver = new ChromeDriver();
        driver.get("http://testfasttrackit.info/selenium-test/");
        WebElement mySelectElement = driver.findElement(By.cssSelector("li.level0:nth-child(1) > a:nth-child(1)"));
        Select dropdown= new Select(mySelectElement);
        dropdown.selectByVisibleText("New Arrivals");
        driver.close();

    }

}
