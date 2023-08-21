package com.example.demo.Model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Teacher {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @NotEmpty
    @Column(columnDefinition = "varchar(20) not null")
    private String name;

@NotNull
@Column(columnDefinition = "int not null")
    private Integer age;

    @NotEmpty
//    @Email
    @Column(columnDefinition = "varchar(20) not null")
    private String email;

    @NotNull
    @Column(columnDefinition = "int not null")
    private Integer salary;

    @OneToOne(cascade = CascadeType.DETACH,mappedBy = "teacher")
    @PrimaryKeyJoinColumn
    private Info info;

    @OneToMany(cascade = CascadeType.DETACH,mappedBy = "teacher")
    private Set<Course> courses;


}
