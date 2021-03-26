package tn.esprit.pidev.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
   @Autowired
   UserDetailsService userDetailsService ;
   @Autowired
   private BCryptPasswordEncoder BCryptPasswordEncoder;
   
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		
		auth.userDetailsService(userDetailsService)
		.passwordEncoder(BCryptPasswordEncoder);
//		 auth.userDetailsService(userDetailsService)
//	        .passwordEncoder(passwordEncoder());
	}
	
	
	
	@Override
    protected void configure(HttpSecurity http) throws Exception {
		
		
		
	        http.csrf().disable();
	        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	        http.authorizeRequests().antMatchers("/login/**","/register/**","/confirm/**").permitAll();
	        http.authorizeRequests().antMatchers("user/getAllPublicationJPQL/**","/ajouterPublication/**","/ajouterCommentaire/**","/Listepardate/**","/searchtopic","/bestevaluation/**","/bestcomment/**","/evaluate/**","/Publication/{idPub}/{idUser}/ajouterCommentaire","/Forum/file","/Forum/Publications/{idUser}/**","/Forum/Publication/{idPub}/{idUser}/**","/Forum/Publication/Commentaire/{idCom}").hasAuthority("ADMIN");
	        http.authorizeRequests().antMatchers("ajouterContrat**","//affecterContratAEmploye/{idcontrat}/{iduser}/**","/getNombreEmployeJPQL/**","/getSalaire/{idemp}/**","/getSalaireMoyen/**","/getCarburant","/Forum/Publication/AddRating/**","/Forum/Publications/rating/**","/Forum/AddPublication/{idUser}/","/Forum/Send/{idSender}/{idRecipient}/**","/Forum/Receive/{idSender}/{idRecipient}/**").hasAuthority("ADMIN");

	        http.authorizeRequests().anyRequest().authenticated();
	        http.addFilter(new JWTAuthenticationFilter(authenticationManager()));
	        http.addFilterBefore(new JWTAuthorizationFiler(), UsernamePasswordAuthenticationFilter.class);
	    
//		
        
//        
//    	http.
//    	csrf().disable();
//    	http.formLogin();
////    	http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
////       // http.authorizeRequests().antMatchers("/register").hasRole("ADMIN");
//       http.authorizeRequests().antMatchers("/login/**","/register/**","/file/**").permitAll();
////    //    http.authorizeRequests () . antMatchers ( HttpMethod.POST," / ajouterPublication / ** " , " / ajouterCommentaire / ** " ) . hasAuthority ( " ADMIN " );
////       // http.authorizeRequests().antMatchers("/appUsers/**","/appRoles/**").hasAuthority("ADMIN");
////
////       // http.authorizeRequests().antMatchers("/user").hasAnyRole("ADMIN","USER");
////       // http.authorizeRequests().antMatchers("/").permitAll();
////
//       http.authorizeRequests().anyRequest().authenticated();
		
//    	.authorizeRequests()
//    	
//    	    .antMatchers("/admin").hasRole("ADMIN")
//    	    .antMatchers("/user").hasAnyRole("ADMIN","USER")
//    	    .antMatchers("/").permitAll()
//    	    .and().formLogin()
//      	    .failureHandler(failureHandler)
//
//    	    . and().httpBasic();

//            .antMatchers(HttpMethod.OPTIONS, "/**")
//            .permitAll()
//            .anyRequest()
//            .authenticated()
//            .and()
//            .httpBasic();
    }
//	
//	@Bean
//	public PasswordEncoder getPasswordEncoder() { return NoOpPasswordEncoder.getInstance();}
////	 @Bean
//	    public BCryptPasswordEncoder encoder() {
//	        return new BCryptPasswordEncoder();
//	    }
	
//	@Autowired
//	CustomAuthenticationFailureHandler failureHandler; 
	
}


