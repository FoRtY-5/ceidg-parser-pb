package com.example.ceidgparser.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "DaneKontaktowe")
public class DaneKontaktowe {

    private String adresPocztyElektronicznej;
    private String adresStronyInternetowej;
    private String telefon;
    private String faks;

    @XmlElement(name = "AdresPocztyElektronicznej")
    public String getAdresPocztyElektronicznej() {
        return adresPocztyElektronicznej;
    }

    public void setAdresPocztyElektronicznej(String adresPocztyElektronicznej) {
        this.adresPocztyElektronicznej = adresPocztyElektronicznej;
    }

    @XmlElement(name = "AdresStronyInternetowej")
    public String getAdresStronyInternetowej() {
        return adresStronyInternetowej;
    }

    public void setAdresStronyInternetowej(String adresStronyInternetowej) {
        this.adresStronyInternetowej = adresStronyInternetowej;
    }

    @XmlElement(name = "Telefon")
    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    @XmlElement(name = "Faks")
    public String getFaks() {
        return faks;
    }

    public void setFaks(String faks) {
        this.faks = faks;
    }
}
