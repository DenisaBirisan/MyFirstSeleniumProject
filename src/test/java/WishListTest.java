import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WishListTest {
//Adăugati un test(o noua metoda) prin care să deschideți homepage-ul site-ului, apoi să navigați
// la categoria "Sale", apoi să deschideți pagina de detalii a primului produs și să încercați să îl adăugați
// în WishList, apăsând butonul Add to Wishlist. Pe viitor, după ce veți învăța să faceți și verificări, veți
// putea reveni pentru a vă asigura că adăugarea în wishlist poate fi realizată doar de utilizatorii
// autentificați. Apelati metoda aceasta in metoda main pentru a rula testul.

    public void addToWishlist(){
        WebDriver driver=new ChromeDriver();
        driver.get("http://testfasttrackit.info/selenium-test/");
        driver.findElement(By.cssSelector("li.level0:nth-child(5) > a:nth-child(1)")).click();
        driver.findElement(By.cssSelector("a.button")).click();
        driver.findElement(By.cssSelector(".link-wishlist")).click();
        driver.close();

    }



}
