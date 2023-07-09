package benny.idat.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SuppressWarnings("deprecation")
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception 
    {
  auth.inMemoryAuthentication().withUser("Marilin").password(passwordEncoder().encode("mk198293")).roles("ADMIN");
	auth.inMemoryAuthentication().withUser("Benny").password(passwordEncoder().encode("us22938")).roles("USER");
	auth.inMemoryAuthentication().withUser("Samara").password(passwordEncoder().encode("mk367290")).roles("ANALISTA");

    }
    @Override
	protected void configure(HttpSecurity http) throws Exception 
	{		
		http.authorizeRequests()
		    .antMatchers("/listar_public").permitAll()
		    .antMatchers("/agregar").access("hasRole('ADMIN')")
		    .antMatchers("/editar/{alumnoId}").access("hasRole('ADMIN')")
		    .antMatchers("/borrar_analist/{alumnoId}").access("hasRole('ANALISTA')")
		    .antMatchers("/buscar_analist/{alumnoId}").access("hasRole('ANALISTA')")
		    .antMatchers("/listar_admin/{alumnoId}").access("hasRole('ANALISTA')")
		    .antMatchers("/listar_user").access("hasRole('USER')");
		
		http.authorizeRequests().and()
			.httpBasic();
		
		http.authorizeRequests().and()
			.csrf().disable();
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}


	
}
