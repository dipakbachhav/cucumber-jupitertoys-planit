import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
            features = "src/test/resources/",
            glue = "org.jupiertoys.serenity.stepDefinitions"
    )

public class JupiterToysRunner {

}