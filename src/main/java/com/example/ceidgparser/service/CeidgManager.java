package com.example.ceidgparser.service;

import java.io.IOException;

public interface CeidgManager  {

    void createCSVResult(String dataOd, String dataDo);

    void deleteCSV();

    String appInit(String email, String dataOd, String dataDo) throws IOException;
}
