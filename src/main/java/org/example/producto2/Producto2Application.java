package org.example.producto2;

import org.example.producto2.models.dao.MenuDAOImpl;
import org.example.producto2.models.dao.ProductoDAOImpl;
import org.example.producto2.seeds.Seeds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Producto2Application {

    @Autowired
    MenuDAOImpl menuRepository;
    @Autowired
    ProductoDAOImpl productRepository;

    public static void main(String[] args) {
        SpringApplication.run(Producto2Application.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner () {
        Seeds seeds = new Seeds(menuRepository, productRepository);
        return runner -> {
            seeds.generateSeeds();
        };
    }

}
