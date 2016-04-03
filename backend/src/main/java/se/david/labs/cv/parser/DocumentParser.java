package se.david.labs.cv.parser;

import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.AutoDetectParser;
import org.apache.tika.sax.BodyContentHandler;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.io.InputStream;

/**
 * Tested file-types
 * docx
 * doc
 * dot
 * html
 * mht
 * pdf
 * rtf
 * txt
 * xml
 */
public class DocumentParser {

    public String parseExample(InputStream stream) throws TikaException, SAXException, IOException {
        AutoDetectParser parser = new AutoDetectParser();
        BodyContentHandler handler = new BodyContentHandler();
        Metadata metadata = new Metadata();
        parser.parse(stream, handler, metadata);
        String result = handler.toString();
        return result.trim();
    }

}
