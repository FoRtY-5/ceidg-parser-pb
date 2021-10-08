package com.example.ceidgparser.service.implementation;

import com.example.ceidgparser.service.CeidgConnection;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.time.LocalDate;

public class Test {

    static CeidgConnection connection = new CeidgConnectionImpl();

    public static void main(String[] args) {
        String xmlString = connection.getDetailsFromDB(LocalDate.of(2021, 9, 1),
                LocalDate.of(2021, 10, 15));
        System.out.println(xmlString);
//        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
//        DocumentBuilder documentBuilder = null;
//        try {
//            documentBuilder = documentBuilderFactory.newDocumentBuilder();
//
//            Document doc = documentBuilder.parse(new InputSource(new StringReader(xmlString)));
//
//            File file = new File();
//
//        } catch (ParserConfigurationException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (SAXException e) {
//            e.printStackTrace();
//        }
    }

}
