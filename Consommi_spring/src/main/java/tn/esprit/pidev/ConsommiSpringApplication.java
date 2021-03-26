package tn.esprit.pidev;

import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import tn.esprit.pidev.entities.Role;
import tn.esprit.pidev.entities.UserConsomi;
import tn.esprit.pidev.repositories.UserRepository;
import tn.esprit.pidev.services.IUserService;
@EnableJpaRepositories(basePackageClasses = UserRepository.class)
@ComponentScan
@SpringBootApplication
(exclude = { SecurityAutoConfiguration.class })
public class ConsommiSpringApplication {

	@Autowired
	IUserService accountService;
	public static void main(String[] args) {
		
		SpringApplication.run(ConsommiSpringApplication.class, args);
	}
	 @Bean
	// public void run(String... arg0) throws Exception{
 CommandLineRunner start(IUserService accountService){
      return args->{
		      
	 
	     // accountService.saveUser(new User(null,"admin", null, null, "1234", 1, 1, "a", null, true, null, null, null, null, null, null, null, null, null, null, null, null, null, null));
	     //   accountService.saveUser(new User(null,"user", null, null, "1234", 1, 1, "a", null, true, null, null, null, null, null, null, null, null, null, null, null, null, null, null));

		  //   accountService.save(new Role("USER"));
         //   accountService.save(new Role("ADMIN"));
////	            Stream.of("user1","user2","user3","admin").forEach(un->{
////	                accountService.ajouterUser(un,"1234","1234");
////	            });
	           // accountService.addRoleToUser("admin","ADMIN");
        };
	    
	 }
	
    
	@Bean
	public  BCryptPasswordEncoder  getBCPE(){
		return new BCryptPasswordEncoder();
	}
}
