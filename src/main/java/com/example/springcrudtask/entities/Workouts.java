package com.example.springcrudtask.entities;
import  jakarta.persistence.*;
import java.util.List;
@Entity
@Table(name="workouts")
public class Workouts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String name;
    @Column
    private String date;
    @Column
    private Integer places;
    @Column
    private String location;
    @OneToMany(mappedBy = "workouts")
    private List<Registrations> registrations;
    public Workouts() {

    }
    public Workouts(String name, String date, Integer places, String location) {
        this.name=name;
        this.date=date;
        this.places=places;
        this.location=location;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDate() {
        return date;
    }

    public Integer getPlaces() {
        return places;
    }

    public String getLocation() {
        return location;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setPlaces(Integer places) {
        this.places = places;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
