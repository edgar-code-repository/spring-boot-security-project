package com.example.security.controller;

import com.example.security.model.User;
import com.example.security.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class InitializeDataController {

    static final Logger logger = LoggerFactory.getLogger(InitializeDataController.class);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @RequestMapping("/init")
    public String initialize(Model model) {
        logger.debug("[InitializeDataController][initialize][START]");

        String password = this.passwordEncoder.encode("secret");

        User normalUser = new User("normal_user", password, true, "ROLE_USER");
        userRepository.save(normalUser);

        User admin_user = new User("admin_user", password, true, "ROLE_ADMIN");
        userRepository.save(admin_user);

        logger.debug("[InitializeDataController][initialize][END]");
        return "public_page";
    }

}
