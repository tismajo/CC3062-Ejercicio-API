package com.UVG.EjercicioAPI.Model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "Ticket")
public class TicketModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String reporter;
    private String description;
    private String status;

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;
    
    public TicketModel() {
        this.createdAt = LocalDateTime.now();
    }
    
    public TicketModel(int id, String reporter, String description, String status, String created_at) {
        this.id = id;
        this.reporter = reporter;
        this.description = description;
        this.status = status;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getReporter() {
        return reporter;
    }
    public void setReporter(String reporter) {
        this.reporter = reporter;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
}
