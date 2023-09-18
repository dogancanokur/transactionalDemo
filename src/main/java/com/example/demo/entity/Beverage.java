package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "beverage")
@Data
public class Beverage {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  @Column(name = "id", nullable = false)
  private Long id;
  @Column(name = "name", nullable = false, length = 30)
  private String name;
  @Column(name = "description", nullable = false, length = 100)
  private String description;

}
