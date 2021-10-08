package com.example.ceidgparser.service.implementation;

import com.example.ceidgparser.security.EmailsInfo;
import com.example.ceidgparser.service.CeidgManager;
import com.example.ceidgparser.service.CeidgParser;
import com.example.ceidgparser.service.CeidgWriter;
import com.example.ceidgparser.service.EmailSender;
import com.example.ceidgparser.service.email.EmailSenderImpl;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CeidgManagerImpl implements CeidgManager {

    private CeidgParser parser = new CeidgParserImpl();
    private CeidgWriter writer = new CeidgWriterImpl();
    private EmailsInfo emailsInfo = new EmailsInfo();

    @Override
    public void createCSVResult(String dataOd, String dataDo) {
        System.out.println("Manager creating");
        try {
            writer.createCSV(parser.getDetails(getDateFromString(dataOd),
                    getDateFromString(dataDo)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("done");
    }

    @Override
    public void deleteCSV() {
        System.out.println("Deleting file...");
        writer.deleteCSV();
    }

    @Override
    public String appInit(String email, String dataOd, String dataDo) throws IOException {
        if (emailsInfo.checkEmail(email)) {
            System.out.println("App initialized");
            CeidgManager manager = new CeidgManagerImpl();
            EmailSender emailSender = new EmailSenderImpl();
            manager.createCSVResult(dataOd, dataDo);
            emailSender.sendEmail(email);
            manager.deleteCSV();
            return "Pobieranie rekordów na email: " + email + "\nData rozpoczecia: " + dataOd +
                    "\nData zakonczenia: " + dataDo;
        } else {
            System.out.println("Wrong email");
            return "Email nie jest autoryzowany! - skontaktuj sie z administratorem aplikacji";
        }
    }

    private static LocalDate getDateFromString(String dateToConvert) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return LocalDate.parse(dateToConvert, formatter);
    }
}
