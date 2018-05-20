package com.voter_demo.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
public class Election implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NonNull
    private java.sql.Date date;

    @NonNull
    private String type;

    @NonNull
    private String title;

    @NonNull
    private long term;

    @NonNull
    private String description;
}
