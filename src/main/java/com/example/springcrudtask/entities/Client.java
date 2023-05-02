package com.example.springcrudtask.entities;
import  jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;

@Entity
@Table(name="clients")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    @NotNull(message = "Vardas yra būtinas!")
    @Size(min = 3, max = 20, message = "Vardas turi turėti tarp 3 ir 20 raidžių!")
    private String name;
    @Column
    @NotNull(message = "Pavardė yra būtina!")
    @Size(min = 3, max = 25, message = "Pavardė turi turėti tarp 3 ir 25 raidžių!")
    private String surname;
    @Column
    @NotNull(message = "Paštas yra būtinas!")
    @Email(message = "Elektroninis paštas nėra validus!")
    private String email;
    @Column
    @Size(max = 15, message = "telefonas negali turėti daugiau nei 15 simbolių!")
    private String phone;
    @Column(length = 128)
    @Value("${agreement:null}")
    private String agreement = null;
    @OneToMany(mappedBy = "client")
    private List<Registrations> registrations;
    public Client() {
    }
    public Client(String name, String surname,
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
    public String getAgreement() {
        return agreement;
    }

    public void setAgreement(String agreement) {
        this.agreement = agreement;
    }
    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", registrations=" + registrations +
                '}';
    }
}
