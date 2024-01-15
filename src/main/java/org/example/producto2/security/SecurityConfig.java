package org.example.producto2.security;

import org.example.producto2.models.dao.UsuarioDAO;
import org.example.producto2.models.entity.Usuario;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public InMemoryUserDetailsManager userDetailsManager(UsuarioDAO usuarioDAO) {

        usuarioDAO.findAll();

        Usuario usuario2 = new Usuario();
        usuario2.setNombre("pepe");
        usuario2.setPassword("{noop}test123");

        UserDetails pepe = User.builder()
                .username(usuario2.getNombre())
                .password(usuario2.getPassword())
                .roles("ADMIN")
                .build();
        return new InMemoryUserDetailsManager(pepe);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.authorizeHttpRequests(configurer ->
                        configurer.requestMatchers("/*").permitAll()
                                .anyRequest().authenticated()
                )
                .formLogin(form ->
                        form
                                .loginPage("/login")
                                .loginProcessingUrl("/authenticateTheUser")
                                .permitAll()
                )
                .logout(logout -> logout.permitAll()
                );


        return http.build();
    }
}
