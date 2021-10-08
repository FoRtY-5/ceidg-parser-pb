package com.example.ceidgparser.service.implementation;

import com.example.ceidgparser.model.InformacjaOWpisie;
import com.example.ceidgparser.service.CeidgConnection;
import com.example.ceidgparser.service.CeidgMapper;
import com.example.ceidgparser.service.CeidgParser;

import java.io.InputStream;
import java.time.LocalDate;
import java.util.List;

public class CeidgParserImpl implements CeidgParser {

    CeidgConnection connection = new CeidgConnectionImpl();
    CeidgMapper mapper = new CeidgMapperImpl();

    @Override
    public List<InformacjaOWpisie> getDetails(LocalDate localDateFrom, LocalDate localDateTo) {
        return mapper.getDetailsToList(connection.getDetailsFromDB(localDateFrom, localDateTo));
    }


}
