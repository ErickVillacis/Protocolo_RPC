package com.crud.rpc_api.model;

import lombok.Data;

import javax.persistence.*;


@Entity
@Data
@Table(name = "laptop")
public class Laptop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String brand;
    private String color;
    private Double weight;
    private String dimensions;
    private Double price;
}