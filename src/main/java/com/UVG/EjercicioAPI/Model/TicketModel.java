package com.UVG.EjercicioAPI.Model;

public class TicketModel {
    private int id;
    private String reporter;
    private String description;
    private String status;
    private String created_at;
    
    public TicketModel() {
        
    }
    
    public TicketModel(int id, String reporter, String description, String status, String created_at) {
        this.id = id;
        this.reporter = reporter;
        this.description = description;
        this.status = status;
        this.created_at = created_at;
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
    public String getCreated_at() {
        return created_at;
    }
    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

}
