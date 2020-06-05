package com.kodakestan.kodak.controllers;

import com.kodakestan.kodak.services.UserService;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

@Named("userBean")
@SessionScoped
public class UserMBean implements Serializable {
    @Inject
    private UserService service;
}
