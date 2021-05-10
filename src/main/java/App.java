import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class App {


    @BeforeTest
    public void setup(){
        Driver.driverStart();
    }

    @Test(priority = 1)
    public void Add(){
        Driver.test(Data.Statuses.SUCCEEDED, Data.Buttons.SIUSTI);
    }

    @Test(priority = 2)
    public void AddFail(){
        Driver.test(Data.Statuses.FAILED, Data.Buttons.SIUSTI);
    }

    @Test(priority = 3)
    public void Delete(){
        Driver.test(Data.Statuses.SUCCEEDED, Data.Buttons.TRINTI);
    }

    @Test(priority = 4)
    public void Modify(){
        Driver.test(Data.Statuses.SUCCEEDED, Data.Buttons.REDAGUOTI);
    }

    @Test(priority = 5)
    public void ModifyFail(){
        Driver.test(Data.Statuses.FAILED, Data.Buttons.REDAGUOTI);
    }

    @AfterTest
    public void CloseBrowser(){
        Driver.driverClose();
    }
}
