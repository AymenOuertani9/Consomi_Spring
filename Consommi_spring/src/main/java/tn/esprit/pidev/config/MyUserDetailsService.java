package tn.esprit.pidev.config;

import java.util.ArrayList;
import java.util.Collection;
//import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

//import tn.esprit.pidev.entities.MyUserDetails;
import tn.esprit.pidev.entities.UserConsomi;
import tn.esprit.pidev.repositories.UserRepository;
import tn.esprit.pidev.services.IUserService;
@Service
@JsonDeserialize
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	IUserService iuserservice;
	@Autowired
	UserRepository userRepository;
	
	
	

	@Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		UserConsomi user = iuserservice.loadUserByUsername(userName);
        if(user==null) throw new UsernameNotFoundException(userName);
        Collection<GrantedAuthority> authorities= new ArrayList<>();
       user.getRole().forEach(r->{
           authorities.add(new SimpleGrantedAuthority(r.getRole()));
        });
       return  new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(),authorities);
    }




	
	
	
	

//	@Override
//    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
//        System.out.println("------->   " + userName);
//        UserConsomi user = iuserservice.loadUserByUsername(userName);
//        System.out.println("------->   " + user.getIduser());
//
//
//        if (user == null) throw new UsernameNotFoundException(userName);
//        Collection<GrantedAuthority> authorities = new ArrayList<>();
//        user.getRole().forEach(r -> {
////       //     log.info("rolee :{}",r);
////
//            authorities.add(new SimpleGrantedAuthority(r.getRole()));
//            System.out.println("------->   " + r.getRole());
//
//        });
//       System.out.println("--ruser.getUsername()rr----->   " + user.getUserName());
//        System.out.println("--getPassword----->   " + user.getPassword());
//        System.out.println("--authorities----->   " +authorities);
//
//        return new User(user.getUserName(), user.getPassword(), authorities);
//    }
	
//	
	
//	@Override
//    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
//		  User user = iuserservice.loadUserByUsername(userName);        
//		  if(user==null) throw new UsernameNotFoundException("invalid user");
//        Collection<GrantedAuthority> authorities=new ArrayList<>();
//        user.getRole().forEach(r->{
//            authorities.add(new SimpleGrantedAuthority(r.getRole()));
//        });
//        return new org.springframework.security.core.userdetails.User(user.getUserName(),user.getPassword(),authorities);
//    }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	@Override
//	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
//	Optional<User> user =	userRepository.findByUserName(userName); 
//	
//	user.orElseThrow(()-> new UsernameNotFoundException("Not found :" + userName));
//	
//	return user.map(MyUserDetails::new).get(); 
//	}
//	

}
