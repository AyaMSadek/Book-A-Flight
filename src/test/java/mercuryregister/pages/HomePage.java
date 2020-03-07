package mercuryregister.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class HomePage {
    @FindBy(css = "body > div > table > tbody > tr > td:nth-child(1) > table > tbody > tr > td > table > tbody > tr > td > table > tbody > tr:nth-child(1) > td:nth-child(2) > font > a")
    WebElement homePageLink;
    @FindBy(css = "body > div > table > tbody > tr > td:nth-child(1) > table > tbody > tr > td > table > tbody > tr > td > table > tbody > tr:nth-child(2) > td:nth-child(2) > a")
    WebElement flightsPageLink;


    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void clicksOnHomePageLink() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        By homePageLinkQuery = By.cssSelector("body > div > table > tbody > tr > td:nth-child(1) > table > tbody > tr > td > table > tbody > tr > td > table > tbody > tr:nth-child(1) > td:nth-child(2)");
        wait.until(ExpectedConditions.presenceOfElementLocated(homePageLinkQuery));
        homePageLink.click();
    }

    public void selectAndPrintTheLowestDestinationPrice() {
        String destinationsListCssSelector = "body > div > table > tbody > tr > td:nth-child(2) > table > tbody > tr:nth-child(4) > td > table > tbody > tr > td:nth-child(2) > table > tbody > tr:nth-child(2) > td:nth-child(1) > table:nth-child(2) > tbody > tr:nth-child(3) > td > table > tbody";
        int lowestPrice;
        WebDriverWait wait = new WebDriverWait(driver, 30);
        By destinationsListQuery = By.cssSelector(destinationsListCssSelector);
        wait.until(ExpectedConditions.presenceOfElementLocated(destinationsListQuery));
        WebElement destinationsList = driver.findElement(By.cssSelector(destinationsListCssSelector));
        List<WebElement> pricesOptions = destinationsList.findElements(By.tagName("b"));
        WebElement option = pricesOptions.get(0);
        lowestPrice = Integer.parseInt(option.getText().substring(1));
        for ( WebElement option2 : pricesOptions ) {
            if (lowestPrice > Integer.parseInt(option2.getText().substring(1))) {
                lowestPrice = Integer.parseInt(option2.getText().substring(1));
            }
        }
        System.out.println("THE LOWEST PRICE DESTINATION IS: $" + lowestPrice);
    }

    public void userOpensTheWebsiteURL() {
        driver.get("http://newtours.demoaut.com/mercuryreservation.php");
    }

    public void clicksOnFlightsPageLink() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        By flightsPageLinkQuery = By.cssSelector("body > div > table > tbody > tr > td:nth-child(1) > table > tbody > tr > td > table > tbody > tr > td > table > tbody > tr:nth-child(2) > td:nth-child(2) > a");
        wait.until(ExpectedConditions.presenceOfElementLocated(flightsPageLinkQuery));
        flightsPageLink.click();
    }

    public void assertThatHomePageIsStillOpened() {
        String expectedURL = "http://newtours.demoaut.com/mercuryreservation.php";
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(expectedURL,currentUrl);
    }

    public void userNavigatesBackFromBrowserAndForwardAgainToHomePage() {
        driver.navigate().back();
        driver.navigate().forward();
    }

}
