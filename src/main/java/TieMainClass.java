import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TieMainClass {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup(); //1.Подключить хром драйвер
        WebDriver driver = new ChromeDriver();   //2.Создать новый драйвер
        driver.get("https://icp.administracionelectronica.gob.es/icpplus/index.html");
        //Locators:
        By dropDownCityLocator = By.xpath("//select[@name='form']/option[4]");
        By buttonAceptar = By.xpath("//input[@id='btnAceptar']");

        By oficinaDropDownLocator = By.xpath("//select[@id='sede']/optgroup/option[3]");
        //By plasticCardLocator = By.xpath("//select[@id='tramiteGrupo[0]']/option[3]"); //?
        //By plasticCardLocator = By.xpath("/html/body/div[1]/div[2]/main/div/div/section/div[2]/form[1]/div[3]/div[1]/div[2]/div/div/fieldset/div[1]/select/option[3]");
        By plasticCardLocator = By.cssSelector("select.mf-input__l");
        By plCardOption = By.cssSelector("option[value='4094']");

        //не проверено
        By nextButtonLocator = By.xpath("/html/body/div[1]/div[2]/main/div/div/section/div[2]/form/div/div[2]/input[1]");
        By btnEnviarLocator = By.xpath("//*[@id='btnEnviar']");
        By nieLocator = By.xpath("//*[@id=\'txtIdCitado\']");
        By nameLocator = By.xpath("//*[@id=\'txtDesCitado\']");

        //page 1 - choose Alicante -ok
        driver.findElement(dropDownCityLocator).click();
        driver.findElement(buttonAceptar).click();
        //page 2 - choose Office + TIE
        driver.findElement(oficinaDropDownLocator).click();
        WebElement plCard = driver.findElement(plasticCardLocator); //выбрать дропдаун
        plCard.click();
        plCard.findElement(plCardOption).click(); //выбрать нужный пункт в дропдаун <-stop
        driver.findElement(buttonAceptar).click();
        //Page 3 - Click Next
        driver.findElement(nextButtonLocator).click();
        //Page 4 - Заполнить данные
        WebElement nie = driver.findElement(nieLocator);
        nie.sendKeys("Y9610134N");
        WebElement name = driver.findElement(nameLocator);
        nie.sendKeys("Olga Gubkina");


    }

}