package com.hemre.portfolio.dao;

import com.hemre.portfolio.entity.Friend;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FriendRepository extends JpaRepository<Friend, Integer> {//entity type and primary key
    public List<Friend> findAllByOrderByLastNameAsc();
}
