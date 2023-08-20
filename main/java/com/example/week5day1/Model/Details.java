package com.example.week5day1.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Details {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    private String gender;
    private Integer age;
    private String email;

    @OneToOne
    // ana alle mwgod fe 6rf althane
    @MapsId
    //3shan lma tstd3e alclass 4a mn onetoOne may9er loop
    @JsonIgnore
    private Customer customer;
}
