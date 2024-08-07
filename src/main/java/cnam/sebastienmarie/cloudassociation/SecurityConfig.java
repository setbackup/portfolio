package cnam.sebastienmarie.cloudassociation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import cnam.sebastienmarie.cloudassociation.common.filtres.JwtTokenAuthFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig{

    @Bean
    protected SecurityFilterChain filterChain(HttpSecurity http, JwtTokenAuthFilter jwTokenAuthFilter) throws Exception{
        
        http.csrf(csrf -> csrf.disable());

        http.sessionManagement(sessionManagmeent -> sessionManagmeent.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        http.httpBasic(httpBasic -> httpBasic.disable());

        http.formLogin(formLogin -> formLogin.disable());
        http.addFilterBefore(jwTokenAuthFilter, UsernamePasswordAuthenticationFilter.class);

        http.authorizeHttpRequests(a->
            a.requestMatchers(HttpMethod.POST, "/inscription").permitAll()
            .requestMatchers(HttpMethod.POST, "/login").permitAll()
            
            .requestMatchers(HttpMethod.POST, "/campagnes_dons/creation").hasRole("ADMIN")
            .requestMatchers(HttpMethod.GET, "/campagnes_dons/consulter").permitAll()
            
            .requestMatchers(HttpMethod.POST, "/campagne_goodies/creation").hasRole("ADMIN")
            .requestMatchers(HttpMethod.GET, "/campagne_goodies/consulter").permitAll()

            .requestMatchers(HttpMethod.GET, "/campagnes").permitAll()

            .requestMatchers(HttpMethod.GET, "/adhesion").permitAll()
            .requestMatchers(HttpMethod.POST, "/adhesion").permitAll()

            .requestMatchers(HttpMethod.GET, "/adherent/campagnes").hasRole("USER")
            .requestMatchers(HttpMethod.GET, "/adherent/campagnes/*").hasRole("USER")

            .requestMatchers(HttpMethod.POST, "/donnations").hasRole("USER")
            .requestMatchers(HttpMethod.POST, "/goodies").hasRole("USER")

        );
         
        return http.build(); 
    }
}