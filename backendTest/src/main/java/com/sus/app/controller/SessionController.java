package com.sus.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class SessionController {
    @RequestMapping("/admin")
    public String helloAdmin() {
        return "hello admin";
    }

    @PostMapping("/addNote")
    public String addNote(@RequestParam("note") String note, HttpServletRequest request) {
        List<String> notes = (List<String>) request.getSession().getAttribute("NOTES_SESSION");
        if (notes == null) {
            notes = new ArrayList<>();
            request.getSession().setAttribute("NOTES_SESSION", notes);
        }
        notes.add(note);
        request.getSession().setAttribute("NOTES_SESSION", notes);
        return "redirect:/home";
    }
    @GetMapping("/home")
    public String home(Model model, HttpSession session) {
        List<String> notes = (List<String>) session.getAttribute("NOTES_SESSION");
        model.addAttribute("notesSession", notes!=null? notes:new ArrayList<>());
        return "home";
    }
    @PostMapping("/invalidate/session")
    public String destroySession(HttpServletRequest request) {
        request.getSession().invalidate();
        return "redirect:/home";
    }
}
