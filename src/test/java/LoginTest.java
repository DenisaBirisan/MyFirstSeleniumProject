import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {

//11.Adăugați în clasa LoginTest un test în care să automatizați pașii necesari pentru logarea cu succes a unui utilizator.

    public void login(){
        WebDriver driver=new ChromeDriver();
        driver.get("http://testfasttrackit.info/selenium-test/");
        driver.findElement(By.cssSelector(".skip-account > span:nth-child(2)")).click();
        driver.findElement(By.cssSelector("div.links:nth-child(1) > ul:nth-child(1) > li:nth-child(6) > a:nth-child(1)")).click();
        driver.findElement((By.cssSelector("#email"))).sendKeys("deni.b@yahoo.com");
        driver.findElement((By.cssSelector("#pass"))).sendKeys("123456");
        driver.findElement(By.cssSelector("#send2")).click();

        driver.close();

    }
}
