import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class TieMainClass {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup(); //1.Подключить хром драйвер
        WebDriver driver = new ChromeDriver();   //2.Создать новый драйвер
        driver.get("https://icp.administracionelectronica.gob.es/icpplus/index.html");

        //page 1 - choose Alicante -ok
        driver.findElement(By.xpath("//select[@name='form']/option[4]")).click();
        driver.findElement(By.xpath("//input[@id='btnAceptar']")).click();

        //page 2 - choose Office + TIE
        driver.findElement(By.xpath("//select[@id='sede']/optgroup/option[3]")).click();
        By plasticCardLocator = By.cssSelector("select.mf-input__l");
        try {
            Thread.sleep(2000);
            WebElement plCard = driver.findElement(plasticCardLocator); //выбрать дропдаун
            Select selectObject = new Select(plCard);
            selectObject.selectByValue("4112");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //Wait for button
        try {
            Thread.sleep(2000);
            driver.findElement(By.xpath("//input[@id='btnAceptar']")).click();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //Page 3 - Click Next
        try {
            Thread.sleep(5000);
            boolean b = driver.findElement(By.id("btnEntrar")).isDisplayed();
            System.out.println(b);
            b = driver.findElement(By.id("btnEntrar")).isEnabled();
            System.out.println(b);
            driver.findElement(By.id("btnEntrar")).sendKeys("eee");
            System.out.println(b);
            driver.findElement(By.id("btnEntrar")).click();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //Page 4 - Заполнить данные
        //Olga
        driver.findElement(By.id("txtIdCitado")).sendKeys("Y9610134N");
        driver.findElement(By.id("txtDesCitado")).sendKeys("Olga Gubkina");
        driver.findElement(By.xpath("//*[@id='btnEnviar']")).click();

        //Mari
        driver.findElement(By.id("txtIdCitado")).sendKeys("Y9610170W");
        driver.findElement(By.id("txtDesCitado")).sendKeys("Mariia Borisova");
        driver.findElement(By.xpath("//*[@id='btnEnviar']")).click();

        try {
            Thread.sleep(2000);
            driver.findElement(By.id("btnEnviar")).click();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}