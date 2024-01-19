package org.example.producto2.models.entity;

import jakarta.persistence.*;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "role", schema = "paracasa", catalog = "")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Basic
    @Column(name = "name")
    private String name;

    public Role(String name) {
        this.name = name;
    }

    public Role() {
    }

    @ManyToMany(mappedBy = "rolesAssociated", fetch = FetchType.EAGER)
    private Set<Usuario> usersAssociated = new LinkedHashSet<>();

    public Set<Usuario> getUsersAssociated() {
        return usersAssociated;
    }

    public void setUsersAssociated(Set<Usuario> usersAssociated) {
        this.usersAssociated = usersAssociated;
    }

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


    @Override
    public String toString() {

        return "Role{ id: " + id + ", name: " + name + "}";
    }
}
