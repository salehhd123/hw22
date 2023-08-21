package com.example.demo.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Info {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty
    @Column(columnDefinition = "varchar(20) not null")

    private String area;
    @NotEmpty
    @Column(columnDefinition = "varchar(20) not null")

    private String street;
    @NotEmpty
    @Column(columnDefinition = "varchar(20) not null")
    private String building;

    @OneToOne
    @MapsId
    @JsonIgnore
//    @Cascade(CascadeType.ALL)
    private Teacher teacher;


}
