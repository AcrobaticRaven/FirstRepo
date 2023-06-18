package org.example.WT03;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class MailHandler {

    void sendMail(){
        Properties sysProperties =System.getProperties();

        sysProperties.put("mail.smtp.host",MailMetaData.HostServer);
        sysProperties.put("mail.smtp.port",MailMetaData.port);
        sysProperties.put(MailMetaData.sslProperty,"true");
        sysProperties.put(MailMetaData.authPerm,"true");

        //creating session using sender mail and password

        Authenticator mailAuthenticator = new CustomisedMailAuth();
        Session mailSession = Session.getInstance(sysProperties,mailAuthenticator);
try {
    MimeMessage mailMessage = new MimeMessage(mailSession);
    mailMessage.setFrom(MailMetaData.userMail);
    mailMessage.setSubject("Api calls and sending mails");
    mailMessage.setText(MailMetaData.details);


    Address receiverMail =new InternetAddress(MailMetaData.receiverMail);
    mailMessage.setRecipient(Message.RecipientType.TO,receiverMail);
    Transport.send(mailMessage);
}catch(MessagingException e){
    System.out.println(e);
}
    }
}
