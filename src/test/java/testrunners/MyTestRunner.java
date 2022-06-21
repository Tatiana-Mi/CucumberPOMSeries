package testrunners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/AppFeatures"},   //if we need to run in parallel, no need to change this line.
        // If we need to run exact feature.file - > just need to add it=>>
        // =>> features = {"src/test/resources/AppFeatures/AccountsPage.feature"},
        glue = {"stepdefinitions", "AppHooks"},
        plugin = {"pretty"}

)


public class MyTestRunner {

}
