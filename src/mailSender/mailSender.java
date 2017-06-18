package mailSender;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.security.Security;
import java.util.Properties;

public class mailSender {
    public static void sendMail(String to, String userID,String userPassword) {
        System.out.println("Sending email");
        try {
            String password = "127589AB";
            String username = "watchneighborsuni@gmail.com";
            String subject = "Watchneighbors- confirm your registration";
            String body = "Welcome! You are now registered at Watchneighbors Application! Use it safely ;)";
            set_SMTP_Properties(username, password, to, subject, body);

        } catch (MessagingException e) {
            System.out.println("SMTP SEND FAIL");
            e.printStackTrace();
        }
        System.out.println("mail sent");


    }

    public static void set_SMTP_Properties(String usr, String pwd, String to, String subject, String body) throws MessagingException {
        String password = pwd;
        String user = usr;

        String host = "smtp.gmail.com";
        String from = user;

        Properties props = System.getProperties();
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.port", 587);
        Session session = Session.getInstance(props);
        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress(from));
        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to, false));
        message.setSubject(subject);
        message.setText(body);

        Transport.send(message, user, password);
        System.out.println("Mail successfully sent");


    }
}


