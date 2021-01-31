import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class RegisterTest {
//Adăugați în clasa RegisterTest un test(o noua metoda) în care să automatizați pașii necesari pentru înregistrarea cu
// succes a unui utilizator nou (deschideți homepage-ul, apăsați pe Account, apăsați pe Register, completați toate
// câmpurile de pe pagina Register - atenție ca email-ul să fie unic, bifați opțiunea pentru primirea newsleterr-ului).
// Folosiți identificatori diferiți pentru câmpurile de pe pagina Register (id, name, className). Pe viitor, după învățarea
// altor identificatori,veți reveni pentru a apăsa și butonul Register. Apelati metoda aceasta in metoda
// main din clasa pentru a rula testul.

    public void register(){
        WebDriver driver=new ChromeDriver();
        driver.get("http://testfasttrackit.info/selenium-test/");
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

        driver.close();
    }
}
