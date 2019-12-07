package com.example.security.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PrivateController {

    static final Logger logger = LoggerFactory.getLogger(PrivateController.class);

    @RequestMapping("/private")
    public String private_page(Model model) {
        logger.debug("[PrivateController][private_page][START]");

        logger.debug("[PrivateController][private_page][END]");
        return "private_page";
    }

}
