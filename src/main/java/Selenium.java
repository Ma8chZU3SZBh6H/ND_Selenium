import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Selenium {
    public static WebDriver driver;

    public static void setup(){
        System.setProperty("webdriver.chrome.driver", "webdriver/chromedriver_win32.exe");
        driver = new ChromeDriver();
        driver.get("http://kitm.epizy.com/filmai.php?i=1");
    }

    public static void input(String keys, String input){
        WebElement number = driver.findElement(By.xpath("/html/body/div/form/input["+input+"]"));
        number.sendKeys(keys);
    }

    public static void register(String _number, String _pavadinimas, String _zanras, String _aktoriai, String _rezisierius, String _trukme){
        input(_number, "1");
        input(_pavadinimas, "2");
        input(_zanras, "3");
        input(_aktoriai, "4");
        input(_rezisierius, "5");
        input(_trukme, "6");
    }

    public static void success(){
        register("1","test","test","test","test","45");
    }

    public static void fail(){
        register("0","0","0","0","0","0");
    }

    public static void button(String number){
        WebElement button = driver.findElement(By.xpath("/html/body/div/form/p[1]/button["+number+"]"));
        button.click();
    }

    public static void test(Boolean fail, String button){
        if (fail) fail();
        else success();
        button(button);
    }

    public static boolean check(String expected){
        try {
            driver.findElement(By.className("msg-"+expected));
            return true;
        }
        catch (Exception e){
            return false;
        }
    }

    public static boolean checkResults(Boolean expected_result){
        if (!expected_result){
            if (Selenium.check("good")){
                return true;
            }
            else{
                return false;
            }
        }
        else{
            if (Selenium.check("bad")){
                return true;
            }
            else{
                return false;
            }
        }
    }

    public static void printResults(String name, Boolean expected){
        if (Selenium.checkResults(expected)){
            System.out.println(name+" GOOD");
        }
        else{
            System.out.println(name+" BAD");
        }
    }
}
