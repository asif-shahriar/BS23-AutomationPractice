package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class UserCycle {
    WebDriver driver;
    WebDriverWait wait;

    public UserCycle(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "email")
    WebElement loginEmail;
    @FindBy(xpath = "//input[@id='passwd']")
    WebElement loginPass;
    @FindBy(id = "SubmitLogin")
    WebElement btnLogin;
    @FindBy(xpath = "//a[@title ='Dresses']")
    List<WebElement> menuDress;
    @FindBy(xpath = "//a[@title = 'Casual Dresses']")
    List<WebElement> submenuCasualDress;
    @FindBy(xpath = "//a[contains(text(),'Printed Dress')]")
    WebElement printDress;
    @FindBy(xpath = "//span[contains(text(),'Add to cart')]")
    WebElement btnCart;
    @FindBy(className = "cross")
    WebElement btnCross;
    @FindBy(xpath = "//a[@title= 'T-shirts']")
    List<WebElement> tshirt;
    @FindBy(className = "color-option")
    List<WebElement> filterColor;
    @FindBy(className = "color_pick")
    List<WebElement> blueColor;
    @FindBy(xpath = "//span[contains(text(),'Proceed to checkout')]")
    WebElement btnCheckOut;
    @FindBy(xpath = "//body/div[@id='page']/div[2]/div[1]/div[3]/div[1]/p[2]/a[1]")
    WebElement btnCheckOut1;
    @FindBy(name = "processAddress")
    WebElement btnCheckOut2;
    @FindBy(name = "processCarrier")
    WebElement btnCheckOut3;
    @FindBy(id = "uniform-cgv")
    WebElement checkBox;
    @FindBy(className = "cheque")
    WebElement payCheque;
    @FindBy(xpath = "//span[contains(text(),'I confirm my order')]")
    WebElement confirmOrder;
    @FindBy(xpath = "//p[contains(text(),'Your order on My Store is complete.')]")
    WebElement status;
    @FindBy(className = "logout")
    WebElement signOut;


    public void userCycleAll(String email, String password) throws InterruptedException {
        loginEmail.sendKeys(email);
        loginPass.sendKeys(password);
        btnLogin.click();
        Thread.sleep(2500);
        Actions actions = new Actions(driver);
        actions.moveToElement(menuDress.get(1)).perform();
        Thread.sleep(2000);
        actions.moveToElement(submenuCasualDress.get(1));
        actions.click().build().perform();
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(printDress));
        printDress.click();
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(btnCart));
        btnCart.click();
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(btnCross));
        btnCross.click();
        tshirt.get(1).click();
        filterColor.get(1).click();
        blueColor.get(1).click();
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(btnCart));
        btnCart.click();
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(btnCheckOut));
        btnCheckOut.click();
        Thread.sleep(2000);
        btnCheckOut1.click();
        Thread.sleep(2000);
        btnCheckOut2.click();
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(checkBox));
        checkBox.click();
        btnCheckOut3.click();
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(payCheque));
        payCheque.click();
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(confirmOrder));
        confirmOrder.click();
        String s = status.getText();
        Assert.assertEquals(s, "Your order on My Store is complete.");
        signOut.click();
    }
}
