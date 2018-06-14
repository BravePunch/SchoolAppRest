package com.bpunch.schoolapprest.services;

import com.bpunch.schoolapprest.model.entity.Message;
import com.bpunch.schoolapprest.repositories.IMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class MessageService {

    private final IMessageRepository messageRepository;

    @Autowired
    public MessageService(IMessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }


    @Transactional
    public Message createMessage(Message message){

        messageRepository.save(message);

        return message;
    }

    @Transactional
    public List<Message> getAllMessages() {

        return (List<Message>) messageRepository.findAll();
    }

}
