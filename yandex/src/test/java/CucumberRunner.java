import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(

        plugin = {"yandex.market.util.AllureReporter"},
        features="src/test/resources/",
        glue = {"yandex.market.steps", "yandex.market.hooks"}
)
public class CucumberRunner {

}
