package com.kodakestan.kodak.controllers;

import com.kodakestan.kodak.services.UserService;
import org.springframework.stereotype.Controller;

import javax.inject.Inject;

//@Named("articleBean")
//@ViewScoped

@Controller("articleBean")
public class ArticleMBean {
    @Inject
    private UserService service;


}