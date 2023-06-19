package runners;

import com.cucumber.listener.Reporter;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.AfterClass;

@CucumberOptions(
        features = {"src/test/java/featureFiles"},
        glue = {"stepDefinitions"},
        plugin = {
                "com.cucumber.listener.ExtentCucumberFormatter:target/ExtentReport/ExtentReportRegression.html"


        }

)

public class ExtendReport_Runner extends AbstractTestNGCucumberTests {

        @AfterClass

        public static void afterClass()
        {
        Reporter.loadXMLConfig("src/test/java/xmlFiles/ExtendReportSet.xml");
        Reporter.setSystemInfo("User Name","Ersin");
        Reporter.setSystemInfo("Application Name","pmx_group Website");
                Reporter.setSystemInfo("Operating System Info",System.getProperty("os.name").toString());
                Reporter.setTestRunnerOutput("Test Execution Cucumber Report");

                }


}
