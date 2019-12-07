package com.example.security.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PublicController {

    static final Logger logger = LoggerFactory.getLogger(PublicController.class);

    @RequestMapping("/")
    public String public_page(Model model) {
        logger.debug("[PublicController][public_page][START]");

        logger.debug("[PublicController][public_page][END]");
        return "public_page";
    }

}
