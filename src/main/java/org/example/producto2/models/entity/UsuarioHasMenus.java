package org.example.producto2.models.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "usuario_has_menus", schema = "paracasa", catalog = "")
public class UsuarioHasMenus {
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
    @Column(name = "id_usuario")
    private int idUsuario;

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
}
