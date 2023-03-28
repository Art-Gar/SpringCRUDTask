package com.example.springcrudtask.repositories;
import com.example.springcrudtask.entities.Registrations;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RegistrationRepository  extends JpaRepository<Registrations, Integer> {
    @Modifying
    @Query("DELETE FROM Workouts w WHERE w.id = :pid")
    void deleteByPid(@Param("pid") Integer theId);
}
