package com.hemre.portfolio.service;

import com.hemre.portfolio.dao.FriendRepository;
import com.hemre.portfolio.entity.Friend;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FriendServiceImpl implements FriendService{

    private FriendRepository friendRepository;

    @Autowired
    public FriendServiceImpl(FriendRepository friendRepository) {
        this.friendRepository = friendRepository;
    }

    @Override
    public List<Friend> findAll() {

        List<Friend> friends = friendRepository.findAll();

        return friends;
    }

    @Override
    public Friend findById(int id) {

        Optional<Friend> result = friendRepository.findById(id); // for null control

        Friend theFriend = null;
        if (result.isPresent()){
            theFriend = result.get();
        }
        else{
            throw new RuntimeException("Did not find friend by this id - " + id);
        }
        return theFriend;
    }

    @Override
    public Friend save(Friend theFriend) {
        return friendRepository.save(theFriend);
    }

    @Override
    public void deleteById(int id) {
        try{
            friendRepository.deleteById(id);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }

        System.out.println("USE LOGGER IN THE FUTURE.......\nSuccessfully deleted user");
    }
}
