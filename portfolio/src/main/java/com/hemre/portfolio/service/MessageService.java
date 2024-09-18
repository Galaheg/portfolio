package com.hemre.portfolio.service;
import com.hemre.portfolio.entity.Message;

import java.util.List;

public interface MessageService {

    List<Message> findAll();

    Message findById(int id);

    Message save(Message theFriend);

    void deleteById(int id);


}
