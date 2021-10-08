package com.example.ceidgparser.service;

import java.time.LocalDate;
import java.util.List;

public interface CeidgConnection {

    String getDetailsFromDB(LocalDate localDateFrom, LocalDate localDateTo);

}
