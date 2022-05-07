package com.jobhunt.web;

import com.jobhunt.domain.Employer;
import com.jobhunt.service.Impl.EmployerService;
import com.jobhunt.service.error.EmployerNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/em")
public class EmployerResource {
    private final EmployerService employerService;

    public EmployerResource(EmployerService employerService) {
        this.employerService = employerService;
    }

    @GetMapping("")
    public String listAll(Model model) {
        List<Employer> employers = employerService.listAll();
        model.addAttribute("employers", employers);

        return "em/em_main";
    }

    @GetMapping("/new")
    public String showForm(Model model) {
        Employer employer = new Employer();
        String action = "Create Employer";
        model.addAttribute("employer", employer);
        model.addAttribute("action", action);

        return "em/em_form";
    }

    @PostMapping("/new")
    public String saveEm(Employer employer) {
        employerService.save(employer);
        return "redirect:/em";

    }
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable String id, Model model)  {
        try {
            Employer employer=employerService.getById(id);
            model.addAttribute("employer",employer);
            return "em/em_form";
        } catch (EmployerNotFoundException e) {
            return "redirect:/em";
        }
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable String id){
        employerService.deleteEmployer(id);
        return "redirect:/em";
    }

}
