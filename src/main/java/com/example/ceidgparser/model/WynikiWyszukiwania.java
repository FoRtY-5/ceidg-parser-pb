package com.example.ceidgparser.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "WynikWyszukiwania")
public class WynikiWyszukiwania {

    private List<String> IdentyfikatorWpisu;

    @XmlElement(name = "IdentyfikatorWpisu")
    public List<String> getIdentyfikatorWpisu() {
        return IdentyfikatorWpisu;
    }

    public void setIdentyfikatorWpisu(List<String> identyfikatorWpisu) {
        IdentyfikatorWpisu = identyfikatorWpisu;
    }
}
