package com.sus.app.systemUsabilityScale.controllers;

import antlr.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class SessionController {
    @GetMapping("/")
    public String index(Model model, HttpSession session) {
        List<String> favoriteColors = getFavColors(session);
        model.addAttribute("favoriteColors", favoriteColors);
        model.addAttribute("sessionId", session.getId());
        return "index";
    }
    @PostMapping("/saveColor")
    public String saveMessage
            (@RequestParam("color") String color,
             HttpServletRequest request) {
        List<String > favoriteColors
                =getFavColors(request.getSession());
        if (!StringUtils.isEmpty(color)) {
            
        }
    }
}
