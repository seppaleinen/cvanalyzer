package se.david.labs;

import com.eviware.soapui.tools.AbstractSoapUIRunner;
import com.eviware.soapui.tools.SoapUILoadTestRunner;
import com.eviware.soapui.tools.SoapUISecurityTestRunner;
import com.eviware.soapui.tools.SoapUITestCaseRunner;
import io.dropwizard.testing.ResourceHelpers;
import io.dropwizard.testing.junit.DropwizardAppRule;
import org.junit.After;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Test;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;

public class SoapuiIT {
    @ClassRule
    public static final DropwizardAppRule<DropwizardConfiguration> RULE =
            new DropwizardAppRule<DropwizardConfiguration>(DropwizardApplication.class, ResourceHelpers.resourceFilePath("cv-test.yml"));


    private AbstractSoapUIRunner runner;
    private static final String SOAPTEST_PATH = "src/test/resources/backend-soapui-test.xml";

    @Before
    public void setup() {
        System.setProperty("soapui.log4j.config", "target/test-classes/soapui-log4j.xml");
        runner = null;
    }

    @Test
    public void runSoapUITestSuites() throws Exception {
        runner = new SoapUITestCaseRunner();
        runner.setSettingsFile("soapui-settings.xml");
        runner.setOutputFolder("target");
        runner.setProjectFile(SOAPTEST_PATH);
        runner.run();
    }

    @Test
    public void runSoapUISecuritySuites() throws Exception {
        runner = new SoapUISecurityTestRunner();
        runner.setSettingsFile("soapui-settings.xml");
        runner.setOutputFolder("target");
        runner.setProjectFile(SOAPTEST_PATH);
        runner.run();
    }

    @Test
    public void runSoapUILoadSuites() throws Exception {
        runner = new SoapUILoadTestRunner();
        runner.setSettingsFile("soapui-settings.xml");
        runner.setOutputFolder("target");
        runner.setProjectFile(SOAPTEST_PATH);
        runner.run();
    }
}
