package com.pinheiro.email.consumer;

import com.pinheiro.email.dtos.EmailRecordDTO;
import com.pinheiro.email.models.EmailModel;
import com.pinheiro.email.services.EmailService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class EmailConsumer {

    @Autowired
    private EmailService service;

    @RabbitListener(queues = "${broker.queue.email.name}")
    public void listenEmailQueue(@Payload EmailRecordDTO emailRecordDTO){
        var emailModel = new EmailModel();
        BeanUtils.copyProperties(emailRecordDTO, emailModel);
        service.sendEmail(emailModel);
    }
}
