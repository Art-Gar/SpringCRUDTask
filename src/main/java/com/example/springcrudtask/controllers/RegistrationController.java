package com.example.springcrudtask.controllers;
import com.example.springcrudtask.entities.Client;
import com.example.springcrudtask.entities.Registrations;
import com.example.springcrudtask.entities.Workouts;
import com.example.springcrudtask.repositories.ClientRepository;
import com.example.springcrudtask.repositories.RegistrationRepository;
import com.example.springcrudtask.repositories.WorkoutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class RegistrationController {
    @Autowired
    public RegistrationRepository registrationRepository;
    @Autowired
    public ClientRepository clientRepository;
    @Autowired
    public WorkoutRepository workoutRepository;
    @GetMapping("/")
    public String workouts(Model model){
        List<Registrations> registrations=registrationRepository.findAll();
        model.addAttribute("registrations", registrations);
        return "registrations_list";
    }
    @GetMapping("/new")
    public String newRegistration(Model model){
        List<Client> clients=clientRepository.findAll();
        List<Workouts> workouts=workoutRepository.findAll();
        model.addAttribute("clients", clients);
        model.addAttribute("workouts", workouts);
        return "registrations_new";
    }

    @PostMapping("/new")
    public String storeRegistration(
            @RequestParam("client_id") Integer client_id,
            @RequestParam("workout_id") Integer workout_id,
            @RequestParam("registrationDate") String registrationDate
    ){
        System.out.println("yes");
        Client c=clientRepository.getReferenceById(client_id);
        Workouts w = workoutRepository.getReferenceById((workout_id));
        Registrations r=new Registrations(c, w, registrationDate);
        registrationRepository.save(r);
        return "redirect:/";
    }
    @GetMapping("/delete/{id}")
    public  String delete(
            @PathVariable("id") Integer id
    ){
        registrationRepository.deleteById(id);
        return "redirect:/";
    }
}
