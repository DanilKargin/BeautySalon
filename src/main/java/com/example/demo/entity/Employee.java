package com.example.demo.entity;

import com.example.demo.EmployeeStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;
import org.hibernate.annotations.NotFound;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Table(name="employees")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Employee {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id")
    public Long id;

    @Column(name = "surname", nullable = false)
    public String surname;
    @Column(name = "name", nullable = false)
    public String name;
    @Column(name = "middleName")
    public String middleName;
    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    public EmployeeStatus status;
}
