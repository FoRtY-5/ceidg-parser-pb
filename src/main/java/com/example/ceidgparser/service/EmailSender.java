package com.example.ceidgparser.service;

import java.io.IOException;

public interface EmailSender {

    void sendEmail(String email) throws IOException;

}
