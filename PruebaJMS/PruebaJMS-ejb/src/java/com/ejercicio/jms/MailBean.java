package com.ejercicio.jms;

import java.util.Properties;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

@Stateless
@LocalBean
public class MailBean {

    public void enviarMail(String to, String subject, String body) {
        //TODO: cambiar from, username y password
        final String from = "mail@mail.com";
        final String username = "username";
        final String password = "password";
        String host = "smtp.gmail.com";
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true"); 
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", "587");
        Session session = Session.getInstance(props,
            new javax.mail.Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                   return new PasswordAuthentication(username, password);
                }
            });
        try {
           Message message = new MimeMessage(session);
           message.setFrom(new InternetAddress(from));
           message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
           message.setSubject(subject);
           message.setText(body);
           Transport.send(message);
           System.out.println("Sent message successfully....");
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
   }
    
}
