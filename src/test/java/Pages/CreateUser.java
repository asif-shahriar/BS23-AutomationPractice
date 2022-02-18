package Pages;


import Utilities.Utils;
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
    @FindBy(id = "id_gender1")
    WebElement btnRadio;
    @FindBy(id = "id_gender2")
    WebElement btnRadioFemale;
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


    public void createU1() throws IOException, ParseException, InterruptedException {
        btnSignUp.click();
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(inputEmail));
        inputEmail.sendKeys("johndoe68@test.test");
        btnCreate.click();
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(btnRadio));
        btnRadio.click();
        firstName.sendKeys("John");
        lastName.sendKeys("Doe");
        pass.sendKeys("332211");
        address.sendKeys("221B Baker Street");
        city.sendKeys("Manhattan");
        Thread.sleep(3000);
        Select select = new Select(state);
        select.selectByValue(String.valueOf(4));
        postCode.sendKeys("20202");
        phone.sendKeys("555444333");
        myAlias.clear();
        myAlias.sendKeys("Sherlock");
        btnSubmit.click();
        utils = new Utils(driver);
        String email = "johndoe68@test.test";
        String password = "332211";
        utils.inputJSONArray(email, password);
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(btnSignOut));
        btnSignOut.click();
    }

    public void createU2() throws IOException, ParseException, InterruptedException {
        btnSignUp.click();
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(inputEmail));
        inputEmail.sendKeys("janedoe68@test.test");
        btnCreate.click();
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(btnRadioFemale));
        btnRadio.click();
        firstName.sendKeys("Jane");
        lastName.sendKeys("Doe");
        pass.sendKeys("332211");
        address.sendKeys("221B Baker Street");
        city.sendKeys("Downtown");
        Thread.sleep(3000);
        Select select = new Select(state);
        select.selectByValue(String.valueOf(3));
        postCode.sendKeys("30112");
        phone.sendKeys("555444222");
        myAlias.clear();
        myAlias.sendKeys("Sherlock but female");
        utils = new Utils(driver);
        String email = "janedoe68@test.test";
        String password = "332211";
        utils.inputJSONArray(email, password);
        btnSubmit.click();
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(btnSignOut));
        btnSignOut.click();
    }
}
