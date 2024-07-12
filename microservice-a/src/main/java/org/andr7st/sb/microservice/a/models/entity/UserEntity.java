package org.andr7st.sb.microservice.a.models.entity;

import jakarta.persistence.*;

@SuppressWarnings("unused")
@Entity
@Table(name = "users") // @table es opcional
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // El motor de la base de dato maneja los id's autoincrementalmente
    private Long id;

    private String name;

    @Column(unique = true)
    private String email;

    private String password;

    //Clase POJO = Getters and Setters
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
}
