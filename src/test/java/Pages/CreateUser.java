package Pages;


import Utilities.Utils;
import com.github.javafaker.Faker;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;

public class CreateUser {
    WebDriver driver;
    WebDriverWait wait;
    Utils utils;
    Faker faker;

    public CreateUser(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[contains(text(),'Sign in')]")
    WebElement btnSignUp;
    @FindBy(xpath = "//input[@id='email_create']")
    WebElement inputEmail;
    @FindBy(id = "SubmitCreate")
    WebElement btnCreate;
    @FindBy(id = "customer_firstname")
    WebElement firstName;
    @FindBy(id = "customer_lastname")
    WebElement lastName;
    @FindBy(id = "passwd")
    WebElement pass;
    @FindBy(id = "address1")
    WebElement address;
    @FindBy(id = "city")
    WebElement city;
    @FindBy(id = "id_state")
    WebElement state;
    @FindBy(id = "postcode")
    WebElement postCode;
    @FindBy(id = "phone_mobile")
    WebElement phone;
    @FindBy(id = "alias")
    WebElement myAlias;
    @FindBy(id = "submitAccount")
    WebElement btnSubmit;
    @FindBy(className = "logout")
    WebElement btnSignOut;


    public void registerUser() throws IOException, ParseException, InterruptedException {
        btnSignUp.click();
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(inputEmail));

        faker = new Faker();
        String first = faker.name().firstName();
        String last = faker.name().lastName();
        String fakeEmail = first.toLowerCase() + last.toLowerCase() + "@bs23assignment.test";
        String fakePhone = faker.phoneNumber().cellPhone();
        String randomPassword = faker.internet().password();
        String zipcode = "" + (int) (Math.random() * (99999 - 10000 + 1) + 10000);

        inputEmail.sendKeys(fakeEmail);
        btnCreate.click();
        firstName.sendKeys(first);
        lastName.sendKeys(last);
        pass.sendKeys(randomPassword);
        address.sendKeys(faker.address().streetAddress());
        city.sendKeys(faker.address().cityName());
        Thread.sleep(3000);
        Select select = new Select(state);
        select.selectByValue(String.valueOf(4));
        postCode.sendKeys(zipcode);
        phone.sendKeys(fakePhone);
        myAlias.clear();
        myAlias.sendKeys("Sherlock");
        btnSubmit.click();
        utils = new Utils(driver);
        utils.inputJSONArray(fakeEmail, randomPassword);
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(btnSignOut));
        btnSignOut.click();
    }
}
