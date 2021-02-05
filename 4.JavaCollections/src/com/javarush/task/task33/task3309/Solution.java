package com.javarush.task.task33.task3309;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.StringWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/* 
Комментарий внутри xml
*/

public class Solution {
    public static String toXmlWithComment(Object obj, String tagName, String comment) throws JAXBException, ParserConfigurationException,  TransformerException {
        JAXBContext context = JAXBContext.newInstance ( obj.getClass () );
        Marshaller marshaller = context.createMarshaller ();
        marshaller.setProperty ( Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE );

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance ();
        factory.setCoalescing(true);
        DocumentBuilder builder = factory.newDocumentBuilder ();
        Document document = builder.newDocument ();
        marshaller.marshal ( obj, document );

        NodeList nodeList = document.getElementsByTagName ( tagName );
        for (int i = 0; i < nodeList.getLength (); i++) {
            nodeList.item ( i ).getParentNode ().insertBefore ( document.createComment ( comment ),
                    nodeList.item ( i ));
//            nodeList.item ( i ).getParentNode ().insertBefore ( document.createComment ( "\n" ),
//                    nodeList.item ( i ));

        }

        TransformerFactory transformerFactory = TransformerFactory.newInstance ();
        Transformer transformer = transformerFactory.newTransformer ();
        transformer.setOutputProperty(OutputKeys.STANDALONE, "no");
        StringWriter writer = new StringWriter (  );
        transformer.transform ( new DOMSource ( document ), new StreamResult ( writer ) );
        String result = writer.toString ();
        return result;
    }

    public static void main(String[] args) {

    }
}
