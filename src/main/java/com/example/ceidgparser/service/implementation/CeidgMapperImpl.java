package com.example.ceidgparser.service.implementation;

import com.example.ceidgparser.model.InformacjaOWpisie;
import com.example.ceidgparser.model.WynikWyszukiwaniaDetails;
import com.example.ceidgparser.model.WynikiWyszukiwania;
import com.example.ceidgparser.service.CeidgMapper;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.util.List;

public class CeidgMapperImpl implements CeidgMapper {

    JAXBContext jaxbContext;
    JAXBContext jaxbContextDetails;

    public CeidgMapperImpl() {
        try {
            // create context with ":" separated list of packages that
            // contain your JAXB ObjectFactory classes
            jaxbContext = JAXBContext.newInstance(WynikiWyszukiwania.class);
            jaxbContextDetails = JAXBContext.newInstance(WynikWyszukiwaniaDetails.class);
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    public List<String> getIdsToList(String xmlString) {
        return unmarshal(xmlString).getIdentyfikatorWpisu();
    }

    public List<InformacjaOWpisie> getDetailsToList(String xmlString) {
        return unmarshalDetails(xmlString).getInformacjaOWpisie();
    }



    private WynikWyszukiwaniaDetails unmarshalDetails(String xmlString) {
        try {
            // Unmarshallers are not thread-safe.  Create a new one every time.
            Unmarshaller unmarshaller = jaxbContextDetails.createUnmarshaller();
            return (WynikWyszukiwaniaDetails) unmarshaller.unmarshal(new StringReader(xmlString));
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    private WynikiWyszukiwania unmarshal(String xmlString) {
        try {
            // Unmarshallers are not thread-safe.  Create a new one every time.
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            return (WynikiWyszukiwania) unmarshaller.unmarshal(new StringReader(xmlString));
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }
}
