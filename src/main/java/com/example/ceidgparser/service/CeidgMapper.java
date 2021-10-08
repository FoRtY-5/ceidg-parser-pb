package com.example.ceidgparser.service;

import com.example.ceidgparser.model.InformacjaOWpisie;

import java.util.List;

public interface CeidgMapper {

    List<String> getIdsToList(String xmlString);

    List<InformacjaOWpisie> getDetailsToList(String xmlString);

}
