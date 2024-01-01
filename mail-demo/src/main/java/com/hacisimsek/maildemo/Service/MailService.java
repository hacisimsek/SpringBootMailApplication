package com.hacisimsek.maildemo.Service;

import com.hacisimsek.maildemo.Model.MailStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String fromMail;

    public void sendMail(String mail, MailStructure mailStructure) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(mail);
        mailMessage.setFrom(fromMail);
        mailMessage.setSubject(mailStructure.getSubject());
        mailMessage.setText(mailStructure.getMessage());
        javaMailSender.send(mailMessage);
    }
}
