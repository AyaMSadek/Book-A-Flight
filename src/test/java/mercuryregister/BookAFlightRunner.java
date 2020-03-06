package mercuryregister;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/mercuryregister/BookAFlight.feature",
        glue = { "mercuryregister/definitions"}, strict = true)
public class BookAFlightRunner {
}


