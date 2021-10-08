package com.example.ceidgparser.service.email;

// using SendGrid's Java Library
// https://github.com/sendgrid/sendgrid-java

import com.example.ceidgparser.security.ConnectionInfo;
import com.example.ceidgparser.security.EmailsInfo;
import com.example.ceidgparser.service.EmailSender;
import com.sendgrid.*;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.function.Predicate;

public class EmailSenderImpl implements EmailSender {

    EmailsInfo emailsInfo = new EmailsInfo();

    @Override
    public void sendEmail(String email) throws IOException {
        if (checkEmail(email)) {
            Email from = new Email("fastservicenoreply@gmail.com");
            String subject = "rekordy " + LocalDate.now();
            Email to = new Email(email);
            Content content = new Content("text/plain", String.valueOf(LocalDate.now()));
            Mail mail = new Mail(from, subject, to, content);

            Attachments attachments = new Attachments.Builder(LocalDate.now() + ".csv", getAttachmentContent()).build();

            mail.addAttachments(attachments);

            SendGrid sg = new SendGrid(ConnectionInfo.SENDGRID_TOKEN);
            Request request = new Request();
            try {
                request.setMethod(Method.POST);
                request.setEndpoint("mail/send");
                request.setBody(mail.build());
                Response response = sg.api(request);
                System.out.println(response.getStatusCode());
                System.out.println(response.getBody());
                System.out.println(response.getHeaders());
                System.out.println("email sent");
            } catch (IOException ex) {
                throw ex;
            }
        } else {
            System.out.println("Wrong email address");
        }
    }

    private boolean checkEmail(String email) {
        return emailsInfo.checkEmail(email);
    }

    private InputStream getAttachmentContent() {
        Path fileName = Path.of("src/main/resources/" + LocalDate.now() + ".csv");
        String csvContent = null;
        try {
            csvContent = Files.readString(fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        assert csvContent != null;
        return new ByteArrayInputStream(csvContent.getBytes(StandardCharsets.UTF_8));
    }

}