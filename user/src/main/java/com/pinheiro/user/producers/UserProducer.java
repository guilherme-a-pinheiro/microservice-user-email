package com.pinheiro.user.producers;

import com.pinheiro.user.dtos.EmailDTO;
import com.pinheiro.user.models.UserModel;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class UserProducer {

    @Autowired
    public RabbitTemplate rabbitTemplate;

    @Value(value = "${broker.queue.email.name}")
    private String routingKey;

    public void publishMessage(UserModel userModel){
        var emailDTO = new EmailDTO();
        emailDTO.setUserId(userModel.getId());
        emailDTO.setEmailTo(userModel.getEmail());
        emailDTO.setSubject("Cadastro realizado com sucesso!");
        emailDTO.setText(
                userModel.getName()
                + " seja bem vindo(a)! \n"
                + "Agradecemos o seu cadastro, aproveite agora todos os recursos da nossa plataforma!"
        );

        rabbitTemplate.convertAndSend("", routingKey, emailDTO);
    }
}
