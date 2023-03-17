package main.seguridad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import main.servicio.impl.UsuarioServiceImplements;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	
    @Autowired
    UsuarioServiceImplements userDetailsService;
 
    
    
    /*
    
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests((authz) -> authz
                .anyRequest().authenticated()
            )
            .httpBasic(withDefaults());
        return http.build();
    }
    */

  
    
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return bCryptPasswordEncoder;
    }
    
    /*
    @Bean DaoAuthenticationProvider authenticationProvider() {
    	DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
    	auth.setUserDetailsService(userDetailsService);
    	auth.setPasswordEncoder(passwordEncoder());
  	 
    	return auth;
    	
    }*/

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }
    
    /*
	@Bean
	public UserDetailsService userDetailsService() {
		UserDetails user =
			 User.withDefaultPasswordEncoder()
				.username("user")
				.password("pass")
				.roles("USER")
				.build();

		return new InMemoryUserDetailsManager(user);
	}*/
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
            
    		http.authorizeRequests()
                    .antMatchers("/","/usuarios").permitAll()
                   // .antMatchers("/admin").hasRole("ROLE_ADMIN")               
                    .and()
                    .formLogin()
            			.loginPage("/login")
            			.permitAll()
	                    .defaultSuccessUrl("/")
	                    .failureUrl("/login?error=true")
	                    .usernameParameter("username")
	                    .passwordParameter("password")
	                    .and()
	                .logout()
		                .permitAll()
	                    .logoutUrl("/logout")
	                    .logoutSuccessUrl("/")
	                .invalidateHttpSession(true)
	                .clearAuthentication(true)
	                	.and()
	                
	                .csrf().disable();
    		
    }
    
    
    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring().antMatchers("/ignore1", "/ignore2");
    }
    
}
