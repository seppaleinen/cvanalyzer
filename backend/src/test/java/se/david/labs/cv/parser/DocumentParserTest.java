package se.david.labs.cv.parser;

import org.apache.tika.exception.TikaException;
import org.junit.Before;
import org.junit.Test;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.io.InputStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class DocumentParserTest {
    private static final String SEPARATOR = System.getProperty("file.separator");

    private static final String PATH = String.format("data%sdocument%sHello.", SEPARATOR, SEPARATOR);

    private DocumentParser documentParser;

    @Before
    public void setup() {
        documentParser = new DocumentParser();
    }

    @Test
    public void testParseDocument_DOCX() throws IOException, TikaException, SAXException {
        testFileType("docx");
    }

    @Test
    public void testParseDocument_DOC() throws IOException, TikaException, SAXException {
        testFileType("doc");
    }

    @Test
    public void testParseDocument_DOT() throws IOException, TikaException, SAXException {
        testFileType("dot");
    }

    @Test
    public void testParseDocument_HTML() throws IOException, TikaException, SAXException {
        testFileType("html");
    }

    @Test
    public void testParseDocument_MHT() throws IOException, TikaException, SAXException {
        testFileType("mht");
    }

    @Test
    public void testParseDocument_PDF() throws IOException, TikaException, SAXException {
        testFileType("pdf");
    }

    @Test
    public void testParseDocument_RTF() throws IOException, TikaException, SAXException {
        testFileType("rtf");
    }

    @Test
    public void testParseDocument_TXT() throws IOException, TikaException, SAXException {
        testFileType("txt");
    }

    @Test
    public void testParseDocument_XML() throws IOException, TikaException, SAXException {
        testFileType("xml");
    }

    private void testFileType(final String fileType) throws IOException, TikaException, SAXException {
        InputStream stream = DocumentParserTest.class.getClassLoader().getResourceAsStream(PATH + fileType);

        String result = documentParser.parseExample(stream);

        assertNotNull(result);
        assertTrue(result, result.contains("Hello"));
    }
}
