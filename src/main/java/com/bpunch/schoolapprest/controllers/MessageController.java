package com.bpunch.schoolapprest.controllers;

import com.bpunch.schoolapprest.model.entity.Message;
import com.bpunch.schoolapprest.services.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/messages")
public class MessageController {

    private final MessageService messageService;

    @Autowired
    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }


    @PostMapping
    public @ResponseBody Message createMessage(@RequestBody Message message) {

        return messageService.createMessage(message);
    }

    @GetMapping
    public List<Message> getAllMessages() {

        return messageService.getAllMessages();
    }

}
