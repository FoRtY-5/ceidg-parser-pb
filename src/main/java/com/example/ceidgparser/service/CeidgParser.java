package com.example.ceidgparser.service;

import com.example.ceidgparser.model.InformacjaOWpisie;

import java.time.LocalDate;
import java.util.List;

public interface CeidgParser {

    List<InformacjaOWpisie> getDetails(LocalDate localDateFrom, LocalDate localDateTo);

}
