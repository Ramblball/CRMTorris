package com.example.CRMTorris.controller;

import com.example.CRMTorris.database.model.Worker;
import com.example.CRMTorris.database.service.WorkerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller("/create")
public class CreateController {

    private final WorkerService workerService;

    public CreateController(WorkerService workerService) {
        this.workerService = workerService;
    }

    @PostMapping("/worker")
    public String addWorker(@ModelAttribute("userForm") @Valid Worker userForm, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            return "registration";
        }
        if (workerService.ConfirmPassword(userForm.getPassword())){
            model.addAttribute("passwordError", "Пароли не совпадают");
            return "registration";
        }
        if (!workerService.saveUser(userForm)){
            model.addAttribute("usernameError", "Пользователь с таким именем уже существует");
            return "registration";
        }

        return "redirect:/";
    }
}
