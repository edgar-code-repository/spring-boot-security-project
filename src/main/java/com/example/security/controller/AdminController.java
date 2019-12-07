package com.example.security.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminController {

    static final Logger logger = LoggerFactory.getLogger(AdminController.class);

    @RequestMapping("/admin")
    public String admin_page(Model model) {
        logger.debug("[AdminController][admin_page][START]");

        logger.debug("[AdminController][admin_page][END]");
        return "admin_page";
    }

}
