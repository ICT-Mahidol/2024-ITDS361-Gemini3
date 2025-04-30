package com.example.observ;

import jakarta.persistence.*;


@Entity
@Table(name = "observing_programs")
public class ObservingProgram {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String programName;

    @Column(nullable = false)
    private String observationDate;

    @Column(length = 1000)
    private String details;

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getProgramName() { return programName; }
    public void setProgramName(String programName) { this.programName = programName; }

    public String getObservationDate() { return observationDate; }
    public void setObservationDate(String observationDate) { this.observationDate = observationDate; }

    public String getDetails() { return details; }
    public void setDetails(String details) { this.details = details; }
}
