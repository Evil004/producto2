package org.example.producto2.models.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "menu", schema = "paracasa")
public class Menu {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;

    public Menu(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "nombre")
    private String nombre;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Basic
    @Column(name = "precio")
    private Double precio;

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    @ManyToMany
    @JoinTable(
            name = "menu_producto",
            joinColumns = @JoinColumn(name = "menu_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    Set<Producto> productos;

    public Set<Producto> getProductos() {
        return productos;
    }

    @ManyToMany(mappedBy = "menus")
    Set<Usuario> usuarios;

}
