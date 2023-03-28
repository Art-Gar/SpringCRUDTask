package com.example.springcrudtask.controllers;
import com.example.springcrudtask.entities.Workouts;
import com.example.springcrudtask.repositories.WorkoutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class WorkoutController {
    @Autowired
    public WorkoutRepository workoutRepository;
    @GetMapping("/workouts")
    public String workouts(Model model){
        List<Workouts> workouts=workoutRepository.findAll();
        model.addAttribute("workouts", workouts);
        return "workouts_list";
    }
    @GetMapping("/workouts/new")
    public String newWorkout(){
        return "workouts_new";
    }

    @PostMapping("/workouts/new")
    public String storeWorkout(
            @RequestParam("name") String name,
            @RequestParam("date") String date,
            @RequestParam("places") Integer places,
            @RequestParam("location") String location
    ){
        Workouts w=new Workouts(name, date, places, location);
        workoutRepository.save(w);
        return "redirect:/workouts";
    }
    @GetMapping("workouts/update/{id}")
    public String update(
            @PathVariable("id") Integer id,
            Model model
    ){
        Workouts w=workoutRepository.getReferenceById(id);
        model.addAttribute("workout", w);
        return "workouts_update";
    }
    @PostMapping("workouts/update/{id}")
    public String save(
            @PathVariable("id") Integer id,
            @RequestParam("name") String name,
            @RequestParam("date") String date,
            @RequestParam("places") Integer places,
            @RequestParam("location") String location
    ){
        Workouts w=workoutRepository.getReferenceById(id);
        w.setName(name);
        w.setDate(date);
        w.setPlaces(places);
        w.setLocation(location);
        workoutRepository.save(w);

        return "redirect:/workouts";
    }
    @GetMapping("workouts/delete/{id}")
    public  String delete(
            @PathVariable("id") Integer id
    ){
        workoutRepository.deleteById(id);
        return "redirect:/workouts";
    }
}
