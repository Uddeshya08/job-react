package com.smoney.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "Jobs")
@Entity
public class Job implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "LOCATION")
    private String location;

    @Column(name = "SKILL")
    private String skill;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "PUBLISHED_ON")
    private Date publishedOn;

}
