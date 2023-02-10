package org.intent.backendIntent.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;

import java.time.LocalDateTime;

@Entity
@Table( name = "users")
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "El campo NAME no puede estar vacio")
    @Column(name="name", length = 60, nullable = false)
    private String name;

    @NotEmpty(message = "El campo lastName, no puede estar vacío")
    @Column(name="last_name", length = 60, nullable = false)
    private String lastName;

    @NotEmpty(message = "El campo username, no puede estar vacío")
    @Column(name="username", length = 30, nullable = false)
    private String username;

    @NotEmpty(message = "El campo email, no puede estar vacío")
    @Column(name="email", length = 60, nullable = false, unique = true )
    private String email;

    @NotEmpty(message = "El campo contraseña, no puede estar vacío")
    @Column(name="password", length = 60, nullable = false)
    private String password;

    @Column(name = "status", nullable = false, columnDefinition = "tinyint DEFAULT true")
    private Boolean active = true;

    @GeneratedValue( strategy = GenerationType.AUTO )
    @Column(name="createdAt", length = 60, nullable = true, columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime createdAt;

    @GeneratedValue( strategy = GenerationType.AUTO)
    @Column(name="updatedAt", length = 60, nullable = true, columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime updatedAt;

    @ManyToOne
    private UserTypeModel userType;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public UserTypeModel getUserType() {
        return userType;
    }

    public void setUserType(UserTypeModel userType) {
        this.userType = userType;
    }
}
