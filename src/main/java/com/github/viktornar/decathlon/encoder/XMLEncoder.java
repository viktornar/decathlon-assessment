package com.github.viktornar.decathlon.encoder;

import com.github.viktornar.decathlon.utils.FileUtils;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import java.io.*;

import static com.github.viktornar.decathlon.constants.Constants.*;

/**
 * Concrete implementation on encoder. Do not use it directly.
 * Should be initialized through GenericEncoder.
 *
 * @author v.nareiko
 */
public class XMLEncoder implements Encoder {
    @Override
    public String encode(Object objectsToBeBound, Class... classesToBeBound) {
        String xmlString = XML_HEADER + "\n" + XSLT_HEADER;
        try (ByteArrayOutputStream outStream = new ByteArrayOutputStream()) {
            JAXBContext jaxbContext = JAXBContext.newInstance(classesToBeBound);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jaxbMarshaller.setProperty(Marshaller.JAXB_FRAGMENT, true);
            jaxbMarshaller.marshal(objectsToBeBound, outStream);
            xmlString += outStream.toString();
        } catch (IOException | JAXBException e) {
            e.printStackTrace();
        }

        return xmlString;
    }

    @Override
    public void writeData(File output, String dataToWrite) {
        FileUtils.writeData(output, dataToWrite);
        InputStream input = getClass().getClassLoader().getResourceAsStream(XSLT_INPUT_FILE_PATH);
        FileUtils.copy(input, output);
    }
}
