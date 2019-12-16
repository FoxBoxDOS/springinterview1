package ru.kazarin.springexam.springinterview.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.kazarin.springexam.springinterview.entity.Human;
import ru.kazarin.springexam.springinterview.service.HumanService;


import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller
public class HumanController {
    private HumanService service;
    private String sortLastnameMethod = "ASC";

    public HumanController() {
    }

    @Autowired
    public void setHumanService(HumanService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String list(Model model) {
        List<Human> springapp = this.filterAndSort();
        model.addAttribute("humans", springapp);
        model.addAttribute("sort", this.sortLastnameMethod);
        return "index";
    }

    @GetMapping("/all")
    public String allHuman() {
        return "operations/all";
    }

    @GetMapping("/sort/{sortDate}")
    public String sortChoose(@PathVariable String sortLastname) {
        sortLastnameMethod = sortLastname;
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        Human human = service.getHumanById(id);
        model.addAttribute("humans", human);
        return "operations/edit";
    }

    @GetMapping("/find/{id}")
    public String find(@PathVariable Integer id, Model model){
        Human human = service.getHumanById(id);
        model.addAttribute("humans", human);
        return "operations/find";
    }
    @PostMapping("/update")
    public String saveHuman(@RequestParam Integer id, @RequestParam String firstname,
                           @RequestParam String lastname) {
        service.updateHuman(id, firstname, lastname);
        return "redirect:/";
    }

    @GetMapping("/new")
    public String newHuman() {
        return "operations/new";
    }

    @PostMapping("/save")
    public String updateHuman(@RequestParam String firstname, @RequestParam String lastname) {
        service.saveHuman(new Human(firstname, lastname));
        return "redirect:/";
    }


    public List<Human> findByFirstnameAndLastnameLike(String firstname, String lastname){
        List<Human> springapp= null;
        springapp = service.findByFirstnameAndLastnameLike(firstname, lastname);
        return springapp;
    }

    private List<Human> filterAndSort() {
        List<Human> springapp = null;
        switch (sortLastnameMethod) {
            case "ASC":
                springapp = service.findAllByOrderByLastnameAsc();
                break;
            case "DESC":
                springapp = service.findAllByOrderByLastnameDesc();
                break;
        }
        return springapp;
    }

    private List<Human> filterAndSort1() {
        List<Human> searchId = null;
        switch (sortLastnameMethod) {
            case "ASC":
                searchId = service.findAllByOrderByLastnameAsc();
                break;
            case "DESC":
                searchId = service.findAllByOrderByLastnameDesc();
                break;
        }
        return searchId;
    }

}
