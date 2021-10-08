package com.example.ceidgparser.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "InformacjaOWpisie")
public class InformacjaOWpisie {

    private String identyfikatorWpisu;
    private DanePodstawowe danePodstawowe;
    private DaneKontaktowe daneKontaktowe;
    private DaneAdresowe daneAdresowe;
    private DaneDodatkowe daneDodatkowe;

    @XmlElement(name = "IdentyfikatorWpisu")
    public String getIdentyfikatorWpisu() {
        return identyfikatorWpisu;
    }

    public void setIdentyfikatorWpisu(String identyfikatorWpisu) {
        this.identyfikatorWpisu = identyfikatorWpisu;
    }

    @XmlElement(name = "DanePodstawowe")
    public DanePodstawowe getDanePodstawowe() {
        return danePodstawowe;
    }

    public void setDanePodstawowe(DanePodstawowe danePodstawowe) {
        this.danePodstawowe = danePodstawowe;
    }

    @XmlElement(name = "DaneKontaktowe")
    public DaneKontaktowe getDaneKontaktowe() {
        return daneKontaktowe;
    }

    public void setDaneKontaktowe(DaneKontaktowe daneKontaktowe) {
        this.daneKontaktowe = daneKontaktowe;
    }

    @XmlElement(name = "DaneAdresowe")
    public DaneAdresowe getDaneAdresowe() {
        return daneAdresowe;
    }

    public void setDaneAdresowe(DaneAdresowe daneAdresowe) {
        this.daneAdresowe = daneAdresowe;
    }

    @XmlElement(name = "DaneDodatkowe")
    public DaneDodatkowe getDaneDodatkowe() {
        return daneDodatkowe;
    }

    public void setDaneDodatkowe(DaneDodatkowe daneDodatkowe) {
        this.daneDodatkowe = daneDodatkowe;
    }
}
