package com.clinic.petclinicspring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/oups")
@Controller
public class ErrorController {
    @RequestMapping
    public String error() {
        return "notImplemented";
    }
}
