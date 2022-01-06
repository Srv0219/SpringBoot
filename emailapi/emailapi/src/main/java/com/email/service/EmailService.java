package com.email.service;


import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

@Service
public class EmailService {
    public boolean sendEmail(String subject, String message, String to) {
        boolean flag = false;
        String from = "adaks74@gmail.com";

        //rest of the code

        //variable for gmail

        String host = "smtp.gmail.com";

        //get the system properties
        Properties prop = new Properties();
        System.out.println("PROPERTIES" + prop);

        //setting important information to properties object
        //host set
        prop.put("mail.smtp.host", host);
        prop.put("mail.smtp.port", "465");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.ssl.enable", "true");





        //Step:1 to get the session object..
        Session session = Session.getInstance(prop, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("mail@gmail.com", "mail123");
            }
        });

        session.setDebug(true);

        //Step:2 Compose the message [text,multimedia]
        MimeMessage m = new MimeMessage(session);

        try {
            //for email
            m.setFrom(from);

            //adding recipient to message
            m.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

            //adding subject to message
            m.setSubject(subject);

            //adding text to message

            m.setText(message);

            //Step:3 send the message using transport class
            Transport.send(m);

            System.out.println("sent success.....................");
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }
}
