import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"com.tinubu.application.steps","com.tinubu.application.config"},
        plugin = {"pretty", "summary"}
)
public class CucumberTest {
}
