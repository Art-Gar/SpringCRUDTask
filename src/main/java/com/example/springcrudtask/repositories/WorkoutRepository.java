package com.example.springcrudtask.repositories;

import com.example.springcrudtask.entities.Workouts;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkoutRepository extends JpaRepository<Workouts,Integer> {


}
