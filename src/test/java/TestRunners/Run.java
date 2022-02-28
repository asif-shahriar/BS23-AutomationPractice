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

    @Test(description = "Creating multiple registered user cycle")
    public void signUpUser1() throws IOException, ParseException, InterruptedException {
        for (int i = 0; i < 2; i++) {
            driver.get("http://automationpractice.com");
            CreateUser createUser = new CreateUser(driver);
            createUser.registerUser();
            driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
            utils = new Utils(driver);
            utils.readFromJSON(i);
            UserCycle userCycle = new UserCycle(driver);
            userCycle.userCycleAll(utils.getEmail(), utils.getPassword());
        }
    }
}
