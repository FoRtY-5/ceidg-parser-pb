package com.example.ceidgparser.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "WynikWyszukiwania")
public class WynikWyszukiwaniaDetails {

    private List<InformacjaOWpisie> informacjaOWpisie;

    @XmlElement(name = "InformacjaOWpisie")
    public List<InformacjaOWpisie> getInformacjaOWpisie() {
        return informacjaOWpisie;
    }

    public void setInformacjaOWpisie(List<InformacjaOWpisie> informacjaOWpisie) {
        this.informacjaOWpisie = informacjaOWpisie;
    }
}
