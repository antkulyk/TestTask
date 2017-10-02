package test.java.classes;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Class to run all test cases
 */
@RunWith(Cucumber.class)
@CucumberOptions(
        features="src\\test\\features",
        format={"pretty","html:target\\Reports"}
)
public class RunnerClass {}
