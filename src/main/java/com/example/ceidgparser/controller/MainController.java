package com.example.ceidgparser.controller;

import com.example.ceidgparser.Main;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class MainController {

    Main main;

    @GetMapping("/start")
    public String main() {
        main.run();
        return "Endpoint reached - method starting...";
    }

    @GetMapping(value = "/start", params = {"email", "dataOd", "dataDo"})
    public String getRecords(@RequestParam String email,
                             @RequestParam String dataOd,
                             @RequestParam String dataDo) {
        return main.run(email, dataOd, dataDo);
    }

}
