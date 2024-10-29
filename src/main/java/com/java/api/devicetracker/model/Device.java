package com.java.api.devicetracker.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@Entity
public class Device {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String brand;
    private LocalDateTime creationTime;

    // Constructors, Getters, and Setters
    public Device() {
    }

    public Device(String name, String brand) {
        this.name = name;
        this.brand = brand;
        this.creationTime = LocalDateTime.now();
    }

    public Device(long id, String name, String brand, LocalDateTime creationTime) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.creationTime = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public LocalDateTime getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(LocalDateTime creationTime) {
        this.creationTime = creationTime;
    }
}
