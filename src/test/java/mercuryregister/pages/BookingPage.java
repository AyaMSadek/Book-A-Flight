package mercuryregister.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;

public class BookingPage {
    @FindBy(css = "body > div > table > tbody > tr > td:nth-child(2) > table > tbody > tr:nth-child(4) > td > table > tbody > tr > td:nth-child(2) > table > tbody > tr:nth-child(5) > td > form > table > tbody > tr:nth-child(4) > td:nth-child(2) > select")
    private WebElement departingFromDropdown;
    @FindBy(css = "body > div > table > tbody > tr > td:nth-child(2) > table > tbody > tr:nth-child(4) > td > table > tbody > tr > td:nth-child(2) > table > tbody > tr:nth-child(5) > td > form > table > tbody > tr:nth-child(5) > td:nth-child(2) > select:nth-child(1)")
    private WebElement monthDropdown;
    @FindBy(css = "body > div > table > tbody > tr > td:nth-child(2) > table > tbody > tr:nth-child(4) > td > table > tbody > tr > td:nth-child(2) > table > tbody > tr:nth-child(5) > td > form > table > tbody > tr:nth-child(5) > td:nth-child(2) > select:nth-child(2)")
    private WebElement dayDropdown;
    @FindBy(css = "body > div > table > tbody > tr > td:nth-child(2) > table > tbody > tr:nth-child(4) > td > table > tbody > tr > td:nth-child(2) > table > tbody > tr:nth-child(5) > td > form > table > tbody > tr:nth-child(10) > td:nth-child(2) > select")
    private WebElement airlineDropdown;
    @FindBy(css = "body > div > table > tbody > tr > td:nth-child(2) > table > tbody > tr:nth-child(4) > td > table > tbody > tr > td:nth-child(2) > table > tbody > tr:nth-child(5) > td > form > table > tbody > tr:nth-child(14) > td > input[type=image]")
    private WebElement continueButtonForFirstPage;
    @FindBy(css = "body > div > table > tbody > tr > td:nth-child(2) > table > tbody > tr:nth-child(4) > td > table > tbody > tr > td:nth-child(2) > table > tbody > tr:nth-child(5) > td > form > p > input[type=image]")
    private WebElement continueButtonForSecondPage;
    @FindBy(css = "body > div > table > tbody > tr > td:nth-child(2) > table > tbody > tr:nth-child(4) > td > table > tbody > tr > td:nth-child(2) > table > tbody > tr:nth-child(5) > td > form > table > tbody > tr:nth-child(2) > td > table > tbody > tr:nth-child(1) > td:nth-child(1) > b > font")
    private WebElement departingFromAsserted;
    @FindBy(css = "body > div > table > tbody > tr > td:nth-child(2) > table > tbody > tr:nth-child(4) > td > table > tbody > tr > td:nth-child(2) > table > tbody > tr:nth-child(5) > td > form > table > tbody > tr:nth-child(2) > td > table > tbody > tr:nth-child(1) > td:nth-child(2) > b")
    private WebElement dateAsserted;
    @FindBy(css = "body > div > table > tbody > tr > td:nth-child(2) > table > tbody > tr:nth-child(4) > td > table > tbody > tr > td:nth-child(2) > table > tbody > tr:nth-child(5) > td > form > table > tbody > tr:nth-child(2) > td > table > tbody > tr:nth-child(3) > td.data_left > font > b")
    private WebElement airlineAsserted;
    @FindBy(css = "body > div > table > tbody > tr > td:nth-child(2) > table > tbody > tr:nth-child(4) > td > table > tbody > tr > td:nth-child(2) > table > tbody > tr:nth-child(5) > td > form > table:nth-child(9) > tbody > tr:nth-child(7) > td.frame_action_xrows > input[type=radio]")
    private WebElement departAirline;
    @FindBy(css = "body > div > table > tbody > tr > td:nth-child(2) > table > tbody > tr:nth-child(4) > td > table > tbody > tr > td:nth-child(2) > table > tbody > tr:nth-child(5) > td > form > table:nth-child(10) > tbody > tr:nth-child(7) > td.frame_action_xrows > input[type=radio]")
    private WebElement returnAirline;


    WebDriver driver;
    public BookingPage(WebDriver driver) {
        this.driver = driver;
    }

    public void selectsAValueFromDepartingFromDropDown(String departingFromValue) {
        String departingFromDropdownCssSelector = "body > div > table > tbody > tr > td:nth-child(2) > table > tbody > tr:nth-child(4) > td > table > tbody > tr > td:nth-child(2) > table > tbody > tr:nth-child(5) > td > form > table > tbody > tr:nth-child(4) > td:nth-child(2) > select";
        WebDriverWait wait = new WebDriverWait(driver, 40);
        wait.until(ExpectedConditions.elementToBeClickable(departingFromDropdown));
        Actions action = new Actions(driver);
        action.moveToElement(departingFromDropdown).click().perform();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement valuesList = driver.findElement(By.cssSelector(departingFromDropdownCssSelector));
        List<WebElement> options = valuesList.findElements(By.tagName("option"));
        for (WebElement option : options) {
            if (option.getText().contains(departingFromValue)) {
                wait.until(ExpectedConditions.elementToBeClickable(option));
                option.click();
                break;
            }
        }
    }

    public void selectsAValueFromMonthDropDown(String month) {
        String monthDropdownCssSelector = "body > div > table > tbody > tr > td:nth-child(2) > table > tbody > tr:nth-child(4) > td > table > tbody > tr > td:nth-child(2) > table > tbody > tr:nth-child(5) > td > form > table > tbody > tr:nth-child(5) > td:nth-child(2) > select:nth-child(1)";
        WebDriverWait wait = new WebDriverWait(driver, 40);
        wait.until(ExpectedConditions.elementToBeClickable(monthDropdown));
        Actions action = new Actions(driver);
        action.moveToElement(monthDropdown).click().perform();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement valuesList = driver.findElement(By.cssSelector(monthDropdownCssSelector));
        List<WebElement> options = valuesList.findElements(By.tagName("option"));
        for (WebElement option : options) {
            if (option.getText().contains(month)) {
                wait.until(ExpectedConditions.elementToBeClickable(option));
                option.click();
                break;
            }
        }
    }

    public void selectsAValueFromDayDropDown(String day) {
        String dayDropdownCssSelector = "body > div > table > tbody > tr > td:nth-child(2) > table > tbody > tr:nth-child(4) > td > table > tbody > tr > td:nth-child(2) > table > tbody > tr:nth-child(5) > td > form > table > tbody > tr:nth-child(5) > td:nth-child(2) > select:nth-child(2)";
        WebDriverWait wait = new WebDriverWait(driver, 40);
        wait.until(ExpectedConditions.elementToBeClickable(dayDropdown));
        Actions action = new Actions(driver);
        action.moveToElement(dayDropdown).click().perform();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement valuesList = driver.findElement(By.cssSelector(dayDropdownCssSelector));
        List<WebElement> options = valuesList.findElements(By.tagName("option"));
        for (WebElement option : options) {
            if (option.getText().contains(day)) {
                wait.until(ExpectedConditions.elementToBeClickable(option));
                option.click();
                break;
            }
        }
    }

    public void userClicksOnContinueButtonForFirstPage() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        By continueButtonQuery = By.cssSelector("body > div > table > tbody > tr > td:nth-child(2) > table > tbody > tr:nth-child(4) > td > table > tbody > tr > td:nth-child(2) > table > tbody > tr:nth-child(5) > td > form > table > tbody > tr:nth-child(14) > td > input[type=image]");
        wait.until(ExpectedConditions.presenceOfElementLocated(continueButtonQuery));
        continueButtonForFirstPage.click();
    }

    public void selectsAValueFromAirlineDepartOptions(String airline) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        By airlineQuery = By.cssSelector("body > div > table > tbody > tr > td:nth-child(2) > table > tbody > tr:nth-child(4) > td > table > tbody > tr > td:nth-child(2) > table > tbody > tr:nth-child(5) > td > form > table:nth-child(9) > tbody > tr:nth-child(7) > td.frame_action_xrows > input[type=radio]");
        wait.until(ExpectedConditions.presenceOfElementLocated(airlineQuery));
        departAirline.click();
    }

    public void selectsAValueFromAirlineReturnOptions(String airline) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        By airlineQuery = By.cssSelector("body > div > table > tbody > tr > td:nth-child(2) > table > tbody > tr:nth-child(4) > td > table > tbody > tr > td:nth-child(2) > table > tbody > tr:nth-child(5) > td > form > table:nth-child(10) > tbody > tr:nth-child(7) > td.frame_action_xrows > input[type=radio]");
        wait.until(ExpectedConditions.presenceOfElementLocated(airlineQuery));
        returnAirline.click();
    }

    public void userClicksOnContinueButtonForSecondPage() throws InterruptedException {
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("window.scrollTo(100, document.body.scrollHeight)");
        Thread.sleep(1000);
        WebDriverWait wait = new WebDriverWait(driver, 30);
        By continueButtonQuery = By.cssSelector("body > div > table > tbody > tr > td:nth-child(2) > table > tbody > tr:nth-child(4) > td > table > tbody > tr > td:nth-child(2) > table > tbody > tr:nth-child(5) > td > form > p > input[type=image]");
        wait.until(ExpectedConditions.presenceOfElementLocated(continueButtonQuery));
        continueButtonForSecondPage.click();
    }

    public void assertThatBookingDetailsAreCorrect(String departingFrom, String month, String day, String airline) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        By departingFromQuery = By.cssSelector("body > div > table > tbody > tr > td:nth-child(2) > table > tbody > tr:nth-child(4) > td > table > tbody > tr > td:nth-child(2) > table > tbody > tr:nth-child(5) > td > form > table > tbody > tr:nth-child(2) > td > table > tbody > tr:nth-child(1) > td:nth-child(1) > b > font");
        wait.until(ExpectedConditions.presenceOfElementLocated(departingFromQuery));

        String actualDepartingFrom = departingFromAsserted.getText();
        Assert.assertTrue(actualDepartingFrom.contains(departingFrom));

        String actualDate = dateAsserted.getText();
        Assert.assertTrue(actualDate.contains(month));
        Assert.assertTrue(actualDate.contains(day));

        String actualAirline = airlineAsserted.getText();
        Assert.assertTrue(actualAirline.contains(airline));
    }

}
