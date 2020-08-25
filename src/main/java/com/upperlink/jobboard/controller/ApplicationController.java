/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upperlink.jobboard.controller;

import com.upperlink.jobboard.model.Application;
import com.upperlink.jobboard.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author Terseer
 */
@Controller
public class ApplicationController {

    @Autowired
    private ApplicationService applicationService;

    @GetMapping("/")
    public String viewIndexPage(Model model) {
        return "index";
    }

    @GetMapping("/login")
    public String viewLoginPage(Model model) {
        return "login";
    }

    @GetMapping("/home")
    public String viewHomePage(Model model) {
        return "home";
    }

    @GetMapping("/application")
    public String viewApplicationPage(Model model) {
        Application application = new Application();
        model.addAttribute("application", application);
        return "application_form";
    }

    @PostMapping("/saveApplication")
    public String saveApplication(@ModelAttribute("application") Application application) {
        // save employee to database

        boolean count = applicationService.checkApplicationLimit();
        System.out.println("Number of applicants" + count);
        if (count) {
            return "redirect:/showLimitMessage";
        }
        applicationService.saveApplication(application);
        return "redirect:/home";
    }

    @GetMapping("/showLimitMessage")
    public String showLimitMessage(Model model) {
        // create model attribute to bind form data
        model.addAttribute("message", "Application Closed");
        return "message";
    }

    @GetMapping("/applicants")
    public String showApplicantsPage(Model model) {
        model.addAttribute("applicants", applicationService.getAllApplications());
        return "application_list";
    }

    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        Application applicant = applicationService.getApplicationById(id);
        model.addAttribute("applicant", applicant);
        return "single_application";
    }
    
  

}
