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

        return "publisherhome-create";
    }

    @PostMapping("/publisherHomes")
    public String save(@Valid PublisherHome publisherHome, Model model) {
        publisherHomeService.save(publisherHome);
        return "redirect:publisherhomes";


    }

    @GetMapping("/publisherhomes")
    public String listPublisherHomes(Model model) {
        model.addAttribute("publisherHomes", publisherHomeService.findAllPublisherHome());
        return "publisherhome-list";
    }

    @GetMapping("/publisherHome/delete/{id}")
    public String deletePublisherHome(@PathVariable("id") Long id, Model model) {
        publisherHomeService.delete(id);
        model.addAttribute("publisherHomes", publisherHomeService.findAllPublisherHome());
        return "publisherhome-list";
    }

    @PostMapping("/publisherHome/update/{id}")
    public String updatePublisherHome(@PathVariable("id") Long id, @Valid PublisherHome publisherHome, Model model) {
        publisherHomeService.save(publisherHome);
        model.addAttribute("publisherHome", publisherHomeService.findAllPublisherHome());
        return "redirect:list";
    }
}
