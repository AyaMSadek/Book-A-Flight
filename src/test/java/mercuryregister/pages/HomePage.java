package mercuryregister.pages;

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
}
