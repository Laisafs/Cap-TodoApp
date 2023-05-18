/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;



/**
 *
 * @author Laisa
 */
public class Task {
    private int id;
    private int idProjects;
    private String name;
    private String description;
    private boolean isCompleted;
    private String notes;
    private Date deadLine;
    private Date createdAt;
    private Date updatedAt;

    public Task(int id, int idProjects, String name, String description, boolean isCompleted, String notes, Date deadLine, Date createdAt, Date updatedAt) {
        this.id = id;
        this.idProjects = idProjects;
        this.name = name;
        this.description = description;
        this.isCompleted = isCompleted;
        this.notes = notes;
        this.deadLine = deadLine;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
public Task(){
    this.createdAt = new Date();
    this.updatedAt = new Date();
  
}
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdProjects() {
        return idProjects;
    }

    public void setIdProjects(int idProjects) {
        this.idProjects = idProjects;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isIsCompleted() {
        return isCompleted;
    }

    public void setIsCompleted(boolean isCompleted) {
        this.isCompleted = isCompleted;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Date getDeadLine() {
        return deadLine;
    }

    public void setDeadLine(Date deadLine) {
        this.deadLine = deadLine;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "Task{" + "id=" + id + ", idProject=" + idProjects + ", name=" + name + ", description=" + description + ", isCompleted=" + isCompleted + ", notes=" + notes + ", deadLine=" + deadLine + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + '}';
    }
    
    
    
    
}
