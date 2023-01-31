package com.example.travelua.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "travels")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Travel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "city")
    private String city;
    @Column(name = "from_date")
    private String fromDate;
    @Column(name = "to_date")
    private String toDate;
    @Column(name = "price")
    private Long price;
    @Column(name = "description")
    private String description;
}
