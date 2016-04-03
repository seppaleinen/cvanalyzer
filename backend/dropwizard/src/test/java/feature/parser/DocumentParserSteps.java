package feature.parser;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.tika.exception.TikaException;
import org.xml.sax.SAXException;
import se.david.cv.dropwizard.cv.parser.DocumentParser;

import java.io.IOException;
import java.io.InputStream;

import static org.junit.Assert.assertTrue;

@SuppressWarnings("unused")
public class DocumentParserSteps {
    private String fileType;
    private DocumentParser documentParser;
    private static final String SEPARATOR = System.getProperty("file.separator");
    private static final String PATH = String.format("data%sdocument%sHello.", SEPARATOR, SEPARATOR);

    private String result = null;

    @Given("^document of type '(.+)'$")
    public void addNewDocument(final String fileType) throws Throwable {
        this.fileType = fileType;
    }


    @When("^the user parses document$")
    public void parseDocument() throws IOException, TikaException, SAXException {
        documentParser = new DocumentParser();
        InputStream stream = DocumentParserTest.class.getClassLoader().getResourceAsStream(PATH + fileType);

        result = documentParser.parseExample(stream);
    }

    @Then("'(.+)' should be in result$")
    public void verifyResult(final String expectedResult) {
        assertTrue(result.contains(expectedResult));
    }
}
