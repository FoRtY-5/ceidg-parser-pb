package com.example.ceidgparser.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "DaneDodatkowe")
public class DaneDodatkowe {

    private String dataRozpoczeciaDzialanosci;
    private String dataZawieszeniaDzialnosci;
    private String status;
    private String kodPKD;

    @XmlElement(name = "DataRozpoczeciaWykonywaniaDzialalnosciGospodarczej")
    public String getDataRozpoczeciaDzialanosci() {
        return dataRozpoczeciaDzialanosci;
    }

    public void setDataRozpoczeciaDzialanosci(String dataRozpoczeciaDzialanosci) {
        this.dataRozpoczeciaDzialanosci = dataRozpoczeciaDzialanosci;
    }

    @XmlElement(name = "DataZawieszeniaWykonywaniaDzialalnosciGospodarczej")
    public String getDataZawieszeniaDzialnosci() {
        return dataZawieszeniaDzialnosci;
    }

    public void setDataZawieszeniaDzialnosci(String dataZawieszeniaDzialnosci) {
        this.dataZawieszeniaDzialnosci = dataZawieszeniaDzialnosci;
    }

    @XmlElement(name = "Status")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @XmlElement(name = "KodyPKD")
    public String getKodPKD() {
        return kodPKD;
    }

    public void setKodPKD(String kodPKD) {
        this.kodPKD = kodPKD;
    }
}
