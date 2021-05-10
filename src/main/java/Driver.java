import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Driver {
    public static WebDriver driver;
    public static Integer testsCount = 1;

    public static void driverStart(){
        System.setProperty("webdriver.chrome.driver", "webdriver/chromedriver_linux64");
        driver = new ChromeDriver();
        driver.get("http://kitm.epizy.com/filmai.php?i=1");
    }

    public static void driverClose(){
        driver.close();
    }

    public static void setInput(String keys, String input){
        WebElement number = driver.findElement(By.xpath("/html/body/div/form/input["+input+"]"));
        number.sendKeys(keys);
    }

    public static void setInputs(String _number, String _pavadinimas, String _zanras, String _aktoriai, String _rezisierius, String _trukme){
        setInput(_number, "1");
        setInput(_pavadinimas, "2");
        setInput(_zanras, "3");
        setInput(_aktoriai, "4");
        setInput(_rezisierius, "5");
        setInput(_trukme, "6");
    }

    public static void setInputsSuccessfully(){
        setInputs("1","test","test","test","test","45");
    }

    public static void setInputsUnsuccessfully(){
        setInputs("0","0","0","0","0","0");
    }

    public static void clickButton(String number){
        WebElement button = driver.findElement(By.xpath("/html/body/div/form/p[1]/button["+number+"]"));
        button.click();
    }

    public static void test(Data.Statuses status, Data.Buttons button){
        try {
            if (status.ordinal() == 0) setInputsUnsuccessfully();
            else setInputsSuccessfully();

            clickButton(String.valueOf(button.ordinal()+1));

            driver.findElement(By.className("msg-" + (status.ordinal() == 0 ? "bad" : "good") ));

            System.out.println("Test " + testsCount + " = GOOD");
        }
        catch (Exception e){
            System.out.println("Test " + testsCount + " = BAD");
        }
        testsCount++;
    }

}
