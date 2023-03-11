package com.example.bookmyshow.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.List;
//import jakarta.persistence.Table;

@Entity
@Table
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class User {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int Id;

        @Column(nullable = false)
        private String name;

        @Column(unique = true)
        private String mobile;

        @CreationTimestamp
        @Temporal(value = TemporalType.TIMESTAMP)
        private Date createdOn;

        @UpdateTimestamp
        @Temporal(value = TemporalType.TIMESTAMP)
        private Date updatedOn;

        @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
        private List<Tickets> listOfTickets;
    }




