package com.pinheiro.user.dtos;

import java.util.UUID;

public class EmailDTO {

    private UUID userId;
    private String emailTo;
    private String subject;
    private String text;

    public EmailDTO(){}

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public String getEmailTo() {
        return emailTo;
    }

    public void setEmailTo(String emailTO) {
        this.emailTo = emailTO;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
