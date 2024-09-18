package com.hemre.portfolio.service;


import com.hemre.portfolio.entity.Friend;

import java.util.List;

public interface FriendService {

    List<Friend> findAll();

    Friend findById(int id);

    Friend save(Friend theFriend);

    void deleteById(int id);

}
