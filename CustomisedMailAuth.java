package org.example.WT03;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

public class CustomisedMailAuth extends Authenticator {
    protected PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication(MailMetaData.userMail,MailMetaData.password);
    }
    }
