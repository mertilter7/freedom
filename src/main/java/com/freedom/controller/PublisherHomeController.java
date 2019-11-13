package com.freedom.controller;

import com.freedom.entity.PublisherHome;
import com.freedom.service.PublisherHomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
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

    @PostMapping("/publisherHomes")
    public String save(@Valid PublisherHome publisherHome, Model model) {
        publisherHomeService.save(publisherHome);
        return "redirect:publisherHomes";


    }

    @GetMapping("/publisherHomes")
    public String listPublisherHomes(Model model) {
        model.addAttribute("publisherHomes", publisherHomeService.findAllPublisherHome());
        return "publisherHome-list";
    }

    @PostMapping("publisherHome/edit/{id}")
    public String updatePublisherHome(@PathVariable("id") Long id , @Valid PublisherHome publisherHome, Model model) {
        PublisherHome update = publisherHomeService.update(id, publisherHome);
        model.addAttribute("publisherHomes", publisherHomeService.findAllPublisherHome());
        return "publisherhome-list";
    }

    @GetMapping("publisherhome/edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        PublisherHome publisherHome = publisherHomeService.getById(id);
        model.addAttribute("publisherHome", publisherHome);
        return "publisherhome-update";
    }
}
