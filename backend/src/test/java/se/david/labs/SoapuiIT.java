package se.david.labs;

import com.eviware.soapui.tools.AbstractSoapUIRunner;
import com.eviware.soapui.tools.SoapUILoadTestRunner;
import com.eviware.soapui.tools.SoapUISecurityTestRunner;
import com.eviware.soapui.tools.SoapUITestCaseRunner;
import io.dropwizard.testing.ResourceHelpers;
import io.dropwizard.testing.junit.DropwizardAppRule;
import org.apache.log4j.Level;
import org.apache.poi.hdf.extractor.SEP;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Test;

import java.util.logging.Logger;

public class SoapuiIT {
    @ClassRule
    public static final DropwizardAppRule<DropwizardConfiguration> RULE =
            new DropwizardAppRule<DropwizardConfiguration>(DropwizardApplication.class, ResourceHelpers.resourceFilePath("cv-test.yml"));

    private static final String SEPARATOR = System.getProperty("file.separator");

    private static final String SETTINGS_FILE = String.format("soapui%ssoapui-settings.xml",
            SEPARATOR);

    private static final String PROJECT_FILE = String.format("src%stest%sresources%ssoapui%stests%sbackend-soapui-test.xml",
            SEPARATOR, SEPARATOR, SEPARATOR, SEPARATOR, SEPARATOR);

    private static final String LOG4J_PATH = String.format("target%stest-classes%ssoapui%ssoapui-log4j.xml",
            SEPARATOR, SEPARATOR, SEPARATOR);

    private static final String OUTPUT = "target";

    @Before
    public void setup() {
        System.setProperty("soapui.log4j.config", LOG4J_PATH);
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
        runner.setSettingsFile(SETTINGS_FILE);
        runner.setOutputFolder(OUTPUT);
        runner.setProjectFile(PROJECT_FILE);
        runner.run();
    }
}
