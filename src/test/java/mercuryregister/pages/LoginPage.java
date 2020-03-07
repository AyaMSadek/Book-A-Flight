package mercuryregister.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

    @FindBy(css = "body > div > table > tbody > tr > td:nth-child(2) > table > tbody > tr:nth-child(4) > td > table > tbody > tr > td:nth-child(2) > table > tbody > tr:nth-child(3) > td > p:nth-child(2) > font > a:nth-child(1)")
    private WebElement signInLink;
    @FindBy(css = "body > div > table > tbody > tr > td:nth-child(2) > table > tbody > tr:nth-child(4) > td > table > tbody > tr > td:nth-child(2) > table > tbody > tr:nth-child(5) > td > form > table > tbody > tr:nth-child(1) > td:nth-child(2) > input")
    private WebElement userNameField;
    @FindBy(css = "body > div > table > tbody > tr > td:nth-child(2) > table > tbody > tr:nth-child(4) > td > table > tbody > tr > td:nth-child(2) > table > tbody > tr:nth-child(5) > td > form > table > tbody > tr:nth-child(2) > td:nth-child(2) > input[type=password]")
    private WebElement passwordField;
    @FindBy(css = "body > div > table > tbody > tr > td:nth-child(2) > table > tbody > tr:nth-child(4) > td > table > tbody > tr > td:nth-child(2) > table > tbody > tr:nth-child(5) > td > form > table > tbody > tr:nth-child(4) > td > input[type=image]")
    private WebElement submitButton;
    @FindBy(css = "body > div > table > tbody > tr > td:nth-child(2) > table > tbody > tr:nth-child(4) > td > table > tbody > tr > td:nth-child(2) > table > tbody > tr:nth-child(3) > td > p:nth-child(1) > font")
    private WebElement userNameAsserted;
    @FindBy(css = "body > div > table > tbody > tr > td:nth-child(2) > table > tbody > tr:nth-child(2) > td > table > tbody > tr > td:nth-child(1) > a")
    private WebElement signInButton;


    WebDriver driver;
    public LoginPage(WebDriver driver){
        this.driver=driver;
    }

    public void userClicksOnSignInLink() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        By signInLinkQuery = By.cssSelector("body > div > table > tbody > tr > td:nth-child(2) > table > tbody > tr:nth-child(4) > td > table > tbody > tr > td:nth-child(2) > table > tbody > tr:nth-child(3) > td > p:nth-child(2) > font > a:nth-child(1)");
        wait.until(ExpectedConditions.presenceOfElementLocated(signInLinkQuery));
        signInLink.click();
    }

    public void userClicksOnSignInButton() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        By signInButtonQuery = By.cssSelector("body > div > table > tbody > tr > td:nth-child(2) > table > tbody > tr:nth-child(2) > td > table > tbody > tr > td:nth-child(1) > a");
        wait.until(ExpectedConditions.presenceOfElementLocated(signInButtonQuery));
        signInButton.click();
    }

    public void userLoginsWithUserNameAndPassword(String user, String password) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        By userNameFieldQuery = By.cssSelector("body > div > table > tbody > tr > td:nth-child(2) > table > tbody > tr:nth-child(4) > td > table > tbody > tr > td:nth-child(2) > table > tbody > tr:nth-child(5) > td > form > table > tbody > tr:nth-child(1) > td:nth-child(2) > input");
        wait.until(ExpectedConditions.presenceOfElementLocated(userNameFieldQuery));
        userNameField.sendKeys(user);

        By passwordFieldQuery = By.cssSelector("body > div > table > tbody > tr > td:nth-child(2) > table > tbody > tr:nth-child(4) > td > table > tbody > tr > td:nth-child(2) > table > tbody > tr:nth-child(5) > td > form > table > tbody > tr:nth-child(2) > td:nth-child(2) > input[type=password]");
        wait.until(ExpectedConditions.presenceOfElementLocated(passwordFieldQuery));
        passwordField.sendKeys(password);

        By submitButtonQuery = By.cssSelector("body > div > table > tbody > tr > td:nth-child(2) > table > tbody > tr:nth-child(4) > td > table > tbody > tr > td:nth-child(2) > table > tbody > tr:nth-child(5) > td > form > table > tbody > tr:nth-child(4) > td > input[type=image]");
        wait.until(ExpectedConditions.presenceOfElementLocated(submitButtonQuery));
        submitButton.click();
    }


    public void assertThatUserNameIsCorrect(String user) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        By userNameQuery = By.cssSelector("body > div > table > tbody > tr > td:nth-child(2) > table > tbody > tr:nth-child(4) > td > table > tbody > tr > td:nth-child(2) > table > tbody > tr:nth-child(3) > td > p:nth-child(1) > font");
        wait.until(ExpectedConditions.presenceOfElementLocated(userNameQuery));

        String actualString = userNameAsserted.getText();
        Assert.assertTrue(actualString.contains(user));
    }


    public void assertThatUserNameOrPasswordIsntCorrect() {
        String loginUrl ="http://newtours.demoaut.com/mercurysignon.php";
        Assert.assertEquals(loginUrl, driver.getCurrentUrl());
    }

    public void assertThatTheWebsitePageIsOpened() {
        String loginUrl ="http://newtours.demoaut.com/mercurysignon.php";
        Assert.assertEquals(loginUrl, driver.getCurrentUrl());
    }

    public void assertThatSignOnPageIsOpened() {
        String signOnUrl ="http://newtours.demoaut.com/mercurysignon.php";
        Assert.assertEquals(signOnUrl, driver.getCurrentUrl());
    }
}
