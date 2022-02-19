package TestRunners;

import Environment.Setup;
import Pages.CreateUser;
import Pages.UserCycle;
import Utilities.Utils;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.IOException;

public class Run extends Setup {
    Utils utils;

    @Test(priority = 1, description = "Creating first user")
    public void signUpUser1() throws IOException, ParseException, InterruptedException {
        driver.get("http://automationpractice.com");
        CreateUser createUser = new CreateUser(driver);
        createUser.createU1();
    }

    @Test(priority = 2, description = "Cycling with first user")
    public void firstCycle() throws InterruptedException, IOException, ParseException {
        driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
        utils = new Utils(driver);
        utils.readFromJSON(0);
        UserCycle userCycle = new UserCycle(driver);
        userCycle.userCycleAll(utils.getEmail(), utils.getPassword());
    }

    @Test(priority = 3, description = "Creating second user")
    public void signUpUser2() throws IOException, ParseException, InterruptedException {
        driver.get("http://automationpractice.com");
        CreateUser createUser = new CreateUser(driver);
        createUser.createU2();
    }

    @Test(priority = 4, description = "Cycling with second user")
    public void secondCycle() throws IOException, ParseException, InterruptedException {
        driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
        utils = new Utils(driver);
        utils.readFromJSON(1);
        UserCycle userCycle = new UserCycle(driver);
        userCycle.userCycleAll(utils.getEmail(), utils.getPassword());
    }
}
