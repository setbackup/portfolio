package cnam.sebastienmarie.cloudassociation.common.filtres;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import cnam.sebastienmarie.cloudassociation.common.service.JWTResult;
import cnam.sebastienmarie.cloudassociation.common.service.JWTService;
import io.jsonwebtoken.io.IOException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtTokenAuthFilter extends OncePerRequestFilter {

    @Autowired
	JWTService jwtService;

	@Autowired
	JWTResult jwtResult;

	@Override
	protected void doFilterInternal(@SuppressWarnings("null") HttpServletRequest request,
									 @SuppressWarnings("null") HttpServletResponse response, 
									 @SuppressWarnings("null") FilterChain filterChain) throws ServletException, IOException, java.io.IOException {
				
		String autorisation = request.getHeader("Authorization");
		
		if (autorisation != null && autorisation.startsWith("bearer ")) {
			autorisation = autorisation.substring("bearer ".length());
			
			jwtService.checkAutorisation(autorisation);
			if (jwtResult.isOk()) {

				Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
				authorities.add(new SimpleGrantedAuthority("ROLE_USER"));

				if (jwtResult.isAdmin()) {
					authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
				}
				UsernamePasswordAuthenticationToken result = new UsernamePasswordAuthenticationToken(jwtResult.getLogin(),
						"", authorities);

				SecurityContextHolder.getContext().setAuthentication(result);
			}
		}
		
		filterChain.doFilter(request, response);
	}

}
