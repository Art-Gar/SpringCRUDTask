package com.example.springcrudtask.controllers;

import com.example.springcrudtask.entities.Club;
import com.example.springcrudtask.repositories.ClubRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
public class ClubController {
    @Autowired
    public ClubRepository clubRepository;

    @GetMapping("/")
    public String clubs(Model model){
        List<Club> clubs= clubRepository.findAll();
        model.addAttribute("clubs", clubs);
        return "clubs_list";
    }

    @GetMapping("/new")
    public String newClub(){
        return "clubs_new";
    }

    @PostMapping("/new")
    public String storeClub(
            @RequestParam("name") String name,
            @RequestParam("surname") String surname,
            @RequestParam("email") String email,
            @RequestParam("phone") String phone
    ){
        Club c=new Club(name, surname, email, phone);
        clubRepository.save(c);
        return "redirect:/";
    }

    @GetMapping("/update/{id}")
    public String update(
            @PathVariable("id") Integer id,
            Model model
    ){
        Club c=clubRepository.getReferenceById(id);
        model.addAttribute("club", c);
        return "clubs_update";
    }

    @PostMapping("/update/{id}")
    public String save(
            @PathVariable("id") Integer id,
            @RequestParam("name") String name,
            @RequestParam("surname") String surname,
            @RequestParam("email") String email,
            @RequestParam("phone") String phone
    ){
        Club c=clubRepository.getReferenceById(id);
        c.setName(name);
        c.setSurname(surname);
        c.setEmail(email);
        c.setPhone(phone);
        clubRepository.save(c);

        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public  String delete(
            @PathVariable("id") Integer id
    ){
        clubRepository.deleteById(id);
        return "redirect:/";
    }

}