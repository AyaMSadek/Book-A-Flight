package mercuryregister.chromeDriver;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LaunchApplication  {
    public static WebDriver driver = new ChromeDriver();
    public static void openWebsitePage (){
        System.setProperty("webdriver.chrome.driver", "src/chromDriver/chromedriver");

        driver.manage().window().setSize(new Dimension(1440, 900));
        driver.get("http://newtours.demoaut.com/mercuryreservation.php");

    }

    protected static void closeDriver() {
        driver.close();
    }
}
