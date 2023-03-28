package com.example.springcrudtask.entities;
import  jakarta.persistence.*;
import java.util.List;
@Entity
@Table(name="registrations")
public class Registrations {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name="workout_id")
    private Workouts workouts;
    @ManyToOne
    @JoinColumn(name="client_id")
    private Client client;

    @Column(length= 64)
    private String registration_date;
    public Registrations() {
    }
    public Registrations(Client client, Workouts workouts, String registration_date) {
        this.client=client;
        this.workouts=workouts;
        this.registration_date=registration_date;
    }

    public Integer getId() {
        return id;
    }

    public Workouts getWorkouts() {
        return workouts;
    }

    public Client getClient() {
        return client;
    }

    public String getRegistration_date() {
        return registration_date;
    }


    public void setWorkouts(Workouts workouts) {
        this.workouts = workouts;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void setRegistration_date(String registration_date) {
        this.registration_date = registration_date;
    }
}
