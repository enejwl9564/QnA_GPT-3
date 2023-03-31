package com.example.controller;

import com.example.service.Gpt3Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class QuestionController {

    @Autowired
    private Gpt3Service gpt3Service;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home() {
        return "index";
    }

    @RequestMapping(value = "/ask", method = RequestMethod.POST)
    public String askQuestion(@RequestParam("question") String question, Model model) {
        String answer = gpt3Service.generateAnswer(question);
        model.addAttribute("question", question);
        model.addAttribute("answer", answer);
        return "answer";
    }
}
