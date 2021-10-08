package com.example.ceidgparser.model.deep;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "AdresGlownegoMiejscaWykonywaniaDzialalnosci")
public class AdresGlownegoMiejscaWykonywaniaDzialalnosci {

    private String Miejscowosc;
    private String Budynek;
    private String KodPocztowy;
    private String Poczta;

    @XmlElement(name = "Miejscowosc")
    public String getMiejscowosc() {
        return Miejscowosc;
    }

    public void setMiejscowosc(String miejscowosc) {
        Miejscowosc = miejscowosc;
    }

    @XmlElement(name = "Budynek")
    public String getBudynek() {
        return Budynek;
    }

    public void setBudynek(String budynek) {
        Budynek = budynek;
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
}
