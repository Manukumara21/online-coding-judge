package com.codingjudge.dto;

public class UserDto {
    
    private Long id;
    private String username;
    private String email;
    private String role;
    private Long createdAt;
    private Long updatedAt;

    // Constructors
    public UserDto() {
    }

    public UserDto(Long id,
               String username,
               String email,
               String role,
               Long createdAt,
               Long updatedAt) {

    this.id = id;
    this.username = username;
    this.email = email;
    this.role = role;
    this.createdAt = createdAt;
    this.updatedAt = updatedAt;
}

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Long createdAt) {
        this.createdAt = createdAt;
    }

    public Long getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Long updatedAt) {
        this.updatedAt = updatedAt;
    }
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
