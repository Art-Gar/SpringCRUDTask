package com.example.springcrudtask.repositories;
import com.example.springcrudtask.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
public interface ClientRepository extends JpaRepository<Client, Integer> {
    Client findByUsername(String username);

}
