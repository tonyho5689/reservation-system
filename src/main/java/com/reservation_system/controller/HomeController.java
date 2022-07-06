package com.reservation_system.controller;

import com.reservation_system.model.Reservation;
import com.reservation_system.model.User;
import com.reservation_system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;


@Controller
public class HomeController {

    final UserService userService;

    public HomeController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String index(Model model) {
        return "index";
    }

    @GetMapping("/reservations")
    public String reservations(Model model, HttpSession session) {
        User user = userService.get(10000L);
        session.setAttribute("user", user);
        Reservation reservation = new Reservation();
        model.addAttribute("reservation", reservation);

        return "reservations";
    }
//TODO submit button
//    @PostMapping("/reservations-submit")
//    public
}