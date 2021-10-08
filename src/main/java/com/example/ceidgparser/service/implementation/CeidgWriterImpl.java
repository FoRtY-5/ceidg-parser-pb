package com.example.ceidgparser.service.implementation;

import com.example.ceidgparser.model.*;
import com.example.ceidgparser.model.deep.AdresDoDoreczen;
import com.example.ceidgparser.service.CeidgWriter;
import com.opencsv.CSVWriter;
import org.apache.tomcat.jni.Local;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CeidgWriterImpl implements CeidgWriter {

    @Override
    public String createCSV(List<InformacjaOWpisie> searchResults) throws IOException {
        List<String[]> csvData = createDataForCSV(searchResults);
        String fileName = String.valueOf(LocalDate.now());
        File file = new File("src/main/resources/"
                + fileName  + ".csv");
        file.createNewFile();

        try (CSVWriter writer = new CSVWriter(new FileWriter("src/main/resources/"
                + fileName + ".csv"))) {
            writer.writeAll(csvData);
        }
        return "File from writer created";
    }

    private List<String[]> createDataForCSV(List<InformacjaOWpisie> searchResults) {
        List<String[]> results = new ArrayList<>();
        InformacjaOWpisie info;
        DanePodstawowe podstawowe;
        DaneKontaktowe kontakt;
        DaneDodatkowe dodatkowe;
        AdresDoDoreczen adres;

        String[] header = {"telefon","kody pkd", "email", "firma", "imie", "nazwisko",
                "nip", "regon", "woj", "kod pocztowy", "miejscowosc", "ulica", "budynek", "lokal", "rozpoczecie dzialalnosci"};

        results.add(header);

        for (InformacjaOWpisie details : searchResults) {
            info = details;
            podstawowe = info.getDanePodstawowe();
            kontakt = info.getDaneKontaktowe();
            dodatkowe = info.getDaneDodatkowe();
            adres = info.getDaneAdresowe().getAdresDoDoreczen();


            String[] record = {kontakt.getTelefon(), dodatkowe.getKodPKD().substring(0, 5), kontakt.getAdresPocztyElektronicznej(),
                    podstawowe.getFirma(), podstawowe.getImie(), podstawowe.getNazwisko(),
                    podstawowe.getNip(), podstawowe.getRegon(), adres.getWojewodztwo(),
                    adres.getKodPocztowy(), adres.getMiejscowosc(), adres.getUlica(),
                    adres.getBudynek(), adres.getLokal(), dodatkowe.getDataRozpoczeciaDzialanosci()};
            results.add(record);
        }
        return results;
    }

    @Override
    public void deleteCSV() {
        Path path = Path.of("src/main/resources/" + LocalDate.now() + ".csv");
        File file = new File(String.valueOf(path));
        file.delete();
        System.out.println("File deleted");
    }

}
