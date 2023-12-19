package org.example.producto2.models.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "menu_has_productos", schema = "paracasa", catalog = "")
public class MenuHasProductos {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_menu")
    private int idMenu;

    public int getIdMenu() {
        return idMenu;
    }

    public void setIdMenu(int idMenu) {
        this.idMenu = idMenu;
    }

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_producto")
    private int idProducto;

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }
}
