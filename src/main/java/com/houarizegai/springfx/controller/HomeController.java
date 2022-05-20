package com.houarizegai.springfx.controller;

import com.houarizegai.springfx.domain.entity.User;
import com.houarizegai.springfx.repository.UserRepository;
import javafx.fxml.FXML;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final UserRepository userRepository;
    private final Logger logger = LoggerFactory.getLogger(HomeController.class.getName());

    @FXML
    public void saveUser() {
        var user = new User(1, "Houari", 100d);
        userRepository.save(user);
        logger.info("User added to database");
    }
}
