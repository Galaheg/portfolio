package com.hemre.portfolio.controller;

import com.hemre.portfolio.entity.Friend;
import com.hemre.portfolio.entity.Message;
import com.hemre.portfolio.service.FriendService;
import com.hemre.portfolio.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    private MessageService messageService;

    @Autowired
    public MainController(MessageService messageService){
        this.messageService = messageService;
    }

    /*@GetMapping("/**")
    public String noMapping(Model theModel){

        Message theMessage = new Message();
        theModel.addAttribute( "theMessage", theMessage);

        return "index";
    }*/

    @RequestMapping("/")
        public String mainPage(){
            return "redirect:/hemre";
    }

    @GetMapping("/hemre")
    public String deneme(Model theModel){

        Message theMessage = new Message();
        theModel.addAttribute( "theMessage", theMessage);

        return "index";
    }

    @PostMapping("/hemre/saveMessage")
    public String save(@ModelAttribute("theMessage") Message message){
        System.out.println(" Inside or not?? ");
        messageService.save(message);
        return "redirect:/hemre";
    }

}
