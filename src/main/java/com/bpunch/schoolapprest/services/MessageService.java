package com.bpunch.schoolapprest.services;

import com.bpunch.schoolapprest.model.entity.Message;
import com.bpunch.schoolapprest.repositories.IMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MessageService {

    private final IMessageRepository messageRepository;

    @Autowired
    public MessageService(IMessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }


    public Message createMessage(Message message){

        messageRepository.save(message);

        return message;
    }

    public List<Message> getAllMessages() {

        return (List<Message>) messageRepository.findAll();
    }

}
