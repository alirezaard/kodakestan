package com.kodakestan.kodak.controllers;

import com.kodakestan.kodak.services.UserService;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named("articleBean")
@ViewScoped
public class ArticleMBean {
    @Inject
    private UserService service;


}