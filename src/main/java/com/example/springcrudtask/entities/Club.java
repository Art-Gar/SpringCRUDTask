package com.example.springcrudtask.entities;
import  jakarta.persistence.*;
@Entity
@Table(name="clients")
public class Club {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String name;
    @Column
    private String surname;
    @Column
    private String email;
    @Column
    private String phone;
    public Club() {
    }
    public Club(String name, String surname,
                String email, String phone) {
        this.name=name;
        this.surname=surname;
        this.email=email;
        this.phone=phone;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }
    @Override
    public String toString() {
        return "Club{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname=" + surname + '\'' +
                ", email=" + email + '\'' +
                ", phone=" + phone +
                '}';
    }
}
