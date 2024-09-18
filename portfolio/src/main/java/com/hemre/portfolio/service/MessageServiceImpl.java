package com.hemre.portfolio.service;

import com.hemre.portfolio.dao.MessageRepository;
import com.hemre.portfolio.entity.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MessageServiceImpl implements MessageService{

    private MessageRepository messageRepository;

    @Autowired
    public MessageServiceImpl(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @Override
    public List<Message> findAll() {
        List<Message> messages = messageRepository.findAll();
        return messages;
    }

    @Override
    public Message findById(int id) {

        Optional<Message> message = messageRepository.findById(id);
        Message theMessage = null;

        if (message.isPresent()){
            theMessage = message.get();
        }
        else{
            throw new RuntimeException("Did not find Message by this id - " + id);
        }
        return theMessage;
    }

    @Override
    public Message save(Message theFriend) {
        return messageRepository.save(theFriend);
    }

    @Override
    public void deleteById(int id) {
        messageRepository.deleteById(id);
    }
}
