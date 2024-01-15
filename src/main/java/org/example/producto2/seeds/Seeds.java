package org.example.producto2.seeds;

import org.example.producto2.models.dao.MenuDAOImpl;
import org.example.producto2.models.dao.ProductoDAOImpl;
import org.example.producto2.models.entity.Menu;
import org.example.producto2.models.entity.Producto;


public class Seeds {
    private MenuDAOImpl menuRepository;
    private ProductoDAOImpl productRepository;

    public Seeds(MenuDAOImpl menuRepository, ProductoDAOImpl productRepository)  {
        this.menuRepository = menuRepository;
        this.productRepository = productRepository;
    }

    public void generateSeeds(){
        Menu menuLibanes = new Menu("Libanes", 30.5);
        Menu menuVeggie = new Menu("Veggie", 20);
        Menu menuBurguer = new Menu("Libanes", 25);
        menuRepository.save(menuLibanes);
        menuRepository.save(menuVeggie);
        menuRepository.save(menuBurguer);

        Producto productPollo = new Producto("Pollo", "El pollo es saludable",5);
        Producto productSeitan = new Producto("Seitan", "El seitan no se que es",7);
        Producto productTofu = new Producto("Tofu", "Tofu en fin",6);
        Producto productTernera = new Producto("Ternera", "La ternera esta buena",5);
        Producto productSetas = new Producto("Setas", "Las setas te dejan bobo",2);
        productRepository.save(productPollo);
        productRepository.save(productSeitan);
        productRepository.save(productTofu);
        productRepository.save(productTernera);
        productRepository.save(productSetas);



    }
}




