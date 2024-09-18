package com.hemre.portfolio.controller;

import com.hemre.portfolio.entity.Friend;
import com.hemre.portfolio.entity.Message;
import com.hemre.portfolio.service.FriendService;
import com.hemre.portfolio.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admins")
public class AdminController {

    private FriendService friendService;
    private MessageService messageService;

    @Autowired
    public AdminController(FriendService friendService, MessageService messageService) {
        this.friendService = friendService;
        this.messageService = messageService;
    }

    @GetMapping("/list")
    public String listFriends(Model theModel) {
        // get from db
        List<Friend> friends = friendService.findAll();

        System.out.println(friends);
        theModel.addAttribute("friends", friends);

        return "admin/list-friends-admin";
        // add to model
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel) {
        Friend theFriend = new Friend();

        theModel.addAttribute("friend", theFriend);

        return "admin/admin-edit-form";
    }

    @PostMapping("/save")
    public String saveFriend(@ModelAttribute("friend") Friend theFriend) {
        friendService.save(theFriend);
        return "redirect:/admins/list";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("friendId") int theId, Model theModel) {

        Friend theFriend = friendService.findById(theId);
        theModel.addAttribute("friend", theFriend);

        return "admin/admin-edit-form";
    }

    @GetMapping("/showFormForDelete")
    public String showFormForDelete(@RequestParam("friendId") int theId, Model theModel) {

        friendService.deleteById(theId);

        return "redirect:/admins/list";
    }

    @GetMapping("/showAllMessages")
    public String showMessages(Model theModel) {
        List<Message> messages =messageService.findAll();
        theModel.addAttribute("messages", messages);

        return "admin/list-messages";
    }

}
