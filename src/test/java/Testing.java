import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Testing {

    @BeforeTest
    public void setup(){
        Selenium.setup();
    }


    @Test(priority = 1)
    public void Register(){
        Selenium.test(false, "1");
    }

    @Test(priority = 2)
    public void RegisterFail(){
        Selenium.test(true, "1");
    }

    @Test(priority = 3)
    public void Delete(){
        Selenium.test(false, "4");
    }

    @Test(priority = 4)
    public void Modify(){
        Selenium.test(false, "2");
    }

    @Test(priority = 5)
    public void ModifyFail(){
        Selenium.test(true, "2");
    }

    @AfterTest
    public void CloseBrowser(){
        Selenium.driver.close();
    }
}
