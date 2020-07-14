package springpractice.blackjack.controller;

import lombok.extern.slf4j.Slf4j;
import springpractice.blackjack.Services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class HelloController {

    private final Services services;

    @Autowired
    public HelloController(Services service) {
        this.services = service;
    }

    @GetMapping("hello")
    public String hello(Model model){
        log.info("hello method called");
        model.addAttribute("message", services.getMessage());
        return "hello";
    }
}
