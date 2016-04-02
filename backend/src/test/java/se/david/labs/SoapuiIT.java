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

    @Before
    public void setup() {
        System.setProperty("soapui.log4j.config", "target/test-classes/soapui-log4j.xml");
    }

    @Test
    public void runSoapUITestSuites() throws Exception {
        runSoapuiRunner(new SoapUITestCaseRunner());
    }

    @Test
    public void runSoapUISecuritySuites() throws Exception {
        runSoapuiRunner(new SoapUISecurityTestRunner());
    }

    @Test
    public void runSoapUILoadSuites() throws Exception {
        runSoapuiRunner(new SoapUILoadTestRunner());
    }

    private void runSoapuiRunner(AbstractSoapUIRunner runner) throws Exception {
        runner.setSettingsFile("soapui-settings.xml");
        runner.setOutputFolder("target");
        runner.setProjectFile("src/test/resources/backend-soapui-test.xml");
        runner.run();
    }
}
