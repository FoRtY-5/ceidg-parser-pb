package com.example.ceidgparser.service.implementation;

import com.example.ceidgparser.security.ConnectionInfo;
import com.example.ceidgparser.service.CeidgConnection;
import com.example.ceidgparser.service.CeidgMapper;
import com.microsoft.schemas._2003._10.serialization.arrays.ArrayOfint;
import com.microsoft.schemas._2003._10.serialization.arrays.ArrayOfstring;
import org.tempuri.*;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.time.LocalDate;
import java.util.List;


public class CeidgConnectionImpl implements CeidgConnection {

    private CeidgMapper mapper = new CeidgMapperImpl();

    private LocalDate localDateFrom;
    private LocalDate localDateTo;
    private XMLGregorianCalendar dateFrom;
    private XMLGregorianCalendar dateTo;


    private IDataStoreProvider201901 iData = new DataStoreProvider201901().getBasicHttpBindingIDataStoreProvider201901();

    public List<String> getRecords(LocalDate localDateFrom, LocalDate localDateTo) {
        return mapper.getIdsToList(getRecordsFromDB(localDateFrom, localDateTo));
    }

    public String getDetailsFromDB(LocalDate localDateFrom, LocalDate localDateTo) {
        this.localDateFrom = localDateFrom;
        this.localDateTo = localDateTo;

        setDate();

        ArrayOfstring empty = new ArrayOfstring();

        ArrayOfstring arrayOfIds = new ArrayOfstring();

        for (String id : getRecords(localDateFrom, localDateTo)) {
            arrayOfIds.getString().add(id);
        }

        String result = iData.getMigrationData201901(ConnectionInfo.AUTH_TOKEN, empty, empty,
                empty, empty, empty, empty,
                empty, empty, empty, empty,
                empty, dateFrom, dateTo, empty,
                new ArrayOfint(), arrayOfIds, dateFrom, dateTo);

        return result;
    }

    private String getRecordsFromDB(LocalDate localDateFrom, LocalDate localDateTo) {
        this.localDateFrom = localDateFrom;
        this.localDateTo = localDateTo;
        setDate();
        return iData.getID(ConnectionInfo.AUTH_TOKEN, dateFrom, dateTo, dateFrom, dateTo);
    }

    private void setDate() {
        dateFrom = setDateFrom();
        dateTo = setDateTo();
    }

    private XMLGregorianCalendar setDateFrom() {
        XMLGregorianCalendar dateFrom = null;
        try {
            dateFrom = DatatypeFactory.newInstance().newXMLGregorianCalendar(localDateFrom.toString());
        } catch (DatatypeConfigurationException e) {
            e.printStackTrace();
        }
        return dateFrom;
    }

    private XMLGregorianCalendar setDateTo() {
        XMLGregorianCalendar dateTo = null;
        try {
            dateTo = DatatypeFactory.newInstance().newXMLGregorianCalendar(localDateTo.toString());
        } catch (DatatypeConfigurationException e) {
            e.printStackTrace();
        }
        return dateTo;
    }

}
