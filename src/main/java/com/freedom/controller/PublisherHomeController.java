package com.freedom.controller;


import com.freedom.entity.PublisherHome;
import com.freedom.service.PublisherHomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Service

public class PublisherHomeController {

    private final PublisherHomeService publisherHomeService;

    @Autowired
    public PublisherHomeController(PublisherHomeService publisherHomeService) {
        this.publisherHomeService = publisherHomeService;

    }

    @GetMapping("/publisherHome")
    public String show(PublisherHome publisherHome) {
        return "publisherHome-create";
    }

    @PostMapping("/publisherHome")
    public String save(@Valid PublisherHome publisherHome, Model model) {
        return "redirect:list";


    }
    @GetMapping("/publisherHome-list")
    public String listPublisherHomes(Model model) {
        model.addAttribute("publisherHomes", publisherHomeService.findAllPublisherHome());
        return "index";
    }


}
