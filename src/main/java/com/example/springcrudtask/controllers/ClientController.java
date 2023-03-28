package com.example.springcrudtask.controllers;

import com.example.springcrudtask.entities.Client;
import com.example.springcrudtask.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
public class ClientController {
    @Autowired
    public ClientRepository clientRepository;

    @GetMapping("/clients")
    public String clients(Model model){
        List<Client> clients= clientRepository.findAll();
        model.addAttribute("clients", clients);
        return "clients_list";
    }

    @GetMapping("/clients/new")
    public String newclient(){
        return "clients_new";
    }

    @PostMapping("/clients/new")
    public String storeclient(
            @RequestParam("name") String name,
            @RequestParam("surname") String surname,
            @RequestParam("email") String email,
            @RequestParam("phone") String phone
    ){
        Client c=new Client(name, surname, email, phone);
        clientRepository.save(c);
        return "redirect:/clients";
    }

    @GetMapping("clients/update/{id}")
    public String update(
            @PathVariable("id") Integer id,
            Model model
    ){
        Client c=clientRepository.getReferenceById(id);
        model.addAttribute("client", c);
        return "clients_update";
    }

    @PostMapping("clients/update/{id}")
    public String save(
            @PathVariable("id") Integer id,
            @RequestParam("name") String name,
            @RequestParam("surname") String surname,
            @RequestParam("email") String email,
            @RequestParam("phone") String phone
    ){
        Client c=clientRepository.getReferenceById(id);
        c.setName(name);
        c.setSurname(surname);
        c.setEmail(email);
        c.setPhone(phone);
        clientRepository.save(c);

        return "redirect:/clients";
    }

    @GetMapping("clients/delete/{id}")
    public  String delete(
            @PathVariable("id") Integer id
    ){
        clientRepository.deleteById(id);
        return "redirect:/clients";
    }

}