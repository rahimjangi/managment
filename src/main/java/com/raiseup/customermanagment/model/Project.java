package com.raiseup.customermanagment.model;

import lombok.*;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;

@Slf4j
@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long projectId;
    @Column(nullable = false)
    private String name;
    private String description;
    private String stage;

    public Project(String name, String description, String stage) {
        this.name = name;
        this.description = description;
        this.stage = stage;
    }
}
