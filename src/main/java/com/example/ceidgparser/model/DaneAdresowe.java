package com.example.ceidgparser.model;

import com.example.ceidgparser.model.deep.AdresDoDoreczen;
import com.example.ceidgparser.model.deep.AdresGlownegoMiejscaWykonywaniaDzialalnosci;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "DaneAdresowe")
public class DaneAdresowe {

    private AdresGlownegoMiejscaWykonywaniaDzialalnosci adresDzialanosci;
    private AdresDoDoreczen adresDoDoreczen;

    @XmlElement(name = "AdresGlownegoMiejscaWykonywaniaDzialalnosci")
    public AdresGlownegoMiejscaWykonywaniaDzialalnosci getAdresDzialanosci() {
        return adresDzialanosci;
    }

    public void setAdresDzialanosci(AdresGlownegoMiejscaWykonywaniaDzialalnosci adresDzialanosci) {
        this.adresDzialanosci = adresDzialanosci;
    }

    @XmlElement(name = "AdresDoDoreczen")
    public AdresDoDoreczen getAdresDoDoreczen() {
        return adresDoDoreczen;
    }

    public void setAdresDoDoreczen(AdresDoDoreczen adresDoDoreczen) {
        this.adresDoDoreczen = adresDoDoreczen;
    }
}
