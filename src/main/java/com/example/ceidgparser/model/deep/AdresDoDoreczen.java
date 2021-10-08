package com.example.ceidgparser.model.deep;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlList;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "AdresDoDoreczen")
public class AdresDoDoreczen {

    private String Miejscowosc;
    private String Ulica;
    private String Budynek;
    private String Lokal;
    private String KodPocztowy;
    private String Poczta;
    private String Wojewodztwo;

    @XmlElement(name = "Miejscowosc")
    public String getMiejscowosc() {
        return Miejscowosc;
    }

    public void setMiejscowosc(String miejscowosc) {
        Miejscowosc = miejscowosc;
    }

    @XmlElement(name = "Ulica")
    public String getUlica() {
        return Ulica;
    }

    public void setUlica(String ulica) {
        Ulica = ulica;
    }

    @XmlElement(name = "Budynek")
    public String getBudynek() {
        return Budynek;
    }

    public void setBudynek(String budynek) {
        Budynek = budynek;
    }

    @XmlElement(name = "Lokal")
    public String getLokal() {
        return Lokal;
    }

    public void setLokal(String lokal) {
        Lokal = lokal;
    }

    @XmlElement(name = "KodPocztowy")
    public String getKodPocztowy() {
        return KodPocztowy;
    }

    public void setKodPocztowy(String kodPocztowy) {
        KodPocztowy = kodPocztowy;
    }

    @XmlElement(name = "Poczta")
    public String getPoczta() {
        return Poczta;
    }

    public void setPoczta(String poczta) {
        Poczta = poczta;
    }

    @XmlElement(name = "Wojewodztwo")
    public String getWojewodztwo() {
        return Wojewodztwo;
    }

    public void setWojewodztwo(String wojewodztwo) {
        Wojewodztwo = wojewodztwo;
    }
}
