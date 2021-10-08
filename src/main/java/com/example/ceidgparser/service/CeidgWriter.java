package com.example.ceidgparser.service;

import com.example.ceidgparser.model.InformacjaOWpisie;
import com.example.ceidgparser.model.WynikWyszukiwaniaDetails;

import java.io.IOException;
import java.util.List;

public interface CeidgWriter {

    String createCSV(List<InformacjaOWpisie> searchResults) throws IOException;

    void deleteCSV();
}
