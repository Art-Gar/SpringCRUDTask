package com.example.springcrudtask.repositories;
import com.example.springcrudtask.entities.Club;
import org.springframework.data.jpa.repository.JpaRepository;
public interface ClubRepository extends JpaRepository<Club, Integer> {

}
