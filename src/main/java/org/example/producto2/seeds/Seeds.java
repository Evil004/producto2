package org.example.producto2.seeds;

import org.example.producto2.models.dao.MenuDAOImpl;
import org.example.producto2.models.dao.ProductoDAOImpl;
import org.example.producto2.models.dao.RoleDAOImpl;
import org.example.producto2.models.dao.UsuarioDAOImpl;
import org.example.producto2.models.entity.Menu;
import org.example.producto2.models.entity.Producto;
import org.example.producto2.models.entity.Role;
import org.example.producto2.models.entity.Usuario;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class Seeds {
    private MenuDAOImpl menuRepository;
    private ProductoDAOImpl productRepository;

    private UsuarioDAOImpl usuarioRepository;

    private RoleDAOImpl roleRepository;


    public Seeds(MenuDAOImpl menuRepository, ProductoDAOImpl productRepository, UsuarioDAOImpl usuarioRepository, RoleDAOImpl roleRepository)  {
        this.menuRepository = menuRepository;
        this.productRepository = productRepository;
        this.usuarioRepository = usuarioRepository;
        this.roleRepository = roleRepository;
    }

    public void generateSeeds(){
        Menu menuLibanes = new Menu("Libanes", 30.5);
        Menu menuVeggie = new Menu("Veggie", 20);
        Menu menuBurguer = new Menu("Libanes", 25);

        Producto productPollo = new Producto("Pollo", "El pollo es saludable",5);
        Producto productSeitan = new Producto("Seitan", "El seitan no se que es",7);
        Producto productTofu = new Producto("Tofu", "Tofu en fin",6);
        Producto productTernera = new Producto("Ternera", "La ternera esta buena",5);
        Producto productSetas = new Producto("Setas", "Las setas te dejan bobo",2);

        Menu[] menus = menuRepository.findAll();

        if(menus.length == 0) {
            menuRepository.save(menuLibanes);
            menuRepository.save(menuVeggie);
            menuRepository.save(menuBurguer);
        }

        List<Producto> productos = productRepository.findAll();

        if(productos.isEmpty()) {
            productRepository.save(productPollo);
            productRepository.save(productSeitan);
            productRepository.save(productTofu);
            productRepository.save(productTernera);
            productRepository.save(productSetas);
        }

    }

    public void creationUsers() {
        Usuario[] usuarios = usuarioRepository.findAll();

        Set<Role> roles = new HashSet<Role>();

        roles.add(roleRepository.findById(1));

        Usuario admin = new Usuario("admin", "admin", roles);

        if(usuarios.length == 0) {
            usuarioRepository.save(admin);
        }
    }
}




