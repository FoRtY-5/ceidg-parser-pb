package com.example.ceidgparser;

import com.example.ceidgparser.service.CeidgManager;
import com.example.ceidgparser.service.implementation.CeidgManagerImpl;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class Main {
//    private CeidgRunner ceidgRunner = new CeidgRunnerImpl();

    private CeidgManager manager = new CeidgManagerImpl();

    public void run() {
        System.out.println("Empty run function");
    }

    public String run(String email, String dataOd, String dataDo) {
        try {
            return manager.appInit(email, dataOd, dataDo);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "Niepowodzenie";
    }

}
