package com.example.springcrudtask.controllers;

import com.example.springcrudtask.entities.Client;
import com.example.springcrudtask.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
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
    public String newClientGet(Model model){
        model.addAttribute("client",new Client());
        return "clients_new";
    }

    @PostMapping("/clients/new")
    public String storeclient(
            Model model,
            String name,
            String surname,
            String email,
            String phone,
            @Validated @ModelAttribute("client") Client client,
            BindingResult result
    ){
        if (result.hasErrors()) {
        return "clients_new";
        } else {
            Client c = new Client(name, surname, email, phone);
            clientRepository.save(c);
            return "redirect:/clients";
        }
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
            @Validated @ModelAttribute("client") Client client,
            BindingResult result
    ){
        if (result.hasErrors()) {
            return "clients_update";
        }
        else {
            Client c = clientRepository.getReferenceById(id);
            c.setName(client.getName());
            c.setSurname(client.getSurname());
            c.setEmail(client.getEmail());
            c.setPhone(client.getPhone());
            clientRepository.save(c);
            return "redirect:/clients";
        }
    }

    @GetMapping("clients/delete/{id}")
    public  String delete(
            @PathVariable("id") Integer id
    ){
        clientRepository.deleteById(id);
        return "redirect:/clients";
    }

}