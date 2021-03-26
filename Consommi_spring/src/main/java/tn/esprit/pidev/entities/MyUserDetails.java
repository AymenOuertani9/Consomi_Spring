//package tn.esprit.pidev.entities;
//
//import java.util.Arrays;
//import java.util.Collection;
//import java.util.Date;
//import java.util.List;
//import java.util.stream.Collectors;
//
//import javax.persistence.Column;
//import javax.persistence.Temporal;
//import javax.persistence.TemporalType;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//
//public class MyUserDetails implements UserDetails {
//	
//	
//	@Autowired
//	BCryptPasswordEncoder bCryptPasswordEncoder;
//
//	private String userName;
//	private String password;
//	private boolean active;
//	private String Lastname;
//	
//	private String Adress;
//	private String Login;
//	private int nbrpoint;
//	private int Tel;
//	private String Email;
//	//private String roles ;
//
//	@Temporal(TemporalType.DATE)
//	private Date DateCreation;
//	private String picture;
//	
//	private List<GrantedAuthority>authorities;
//
//	
//	public MyUserDetails (UserConsomi user) {
//		this.userName= user.getUsername();
//		this.password= bCryptPasswordEncoder.encode(user.getPassword());
//		this.active=user.isActive();
//		//this.authorities= user.getRole();
//		
//	
//}
//	
//
//	@Override
//	public Collection<? extends GrantedAuthority> getAuthorities() {
//		// TODO Auto-generated method stub
//		return authorities;
//	}
//
//	@Override
//	public String getPassword() {
//		// TODO Auto-generated method stub
//		return password;
//	}
//
//	@Override
//	public String getUsername() {
//		// TODO Auto-generated method stub
//		return userName;
//	}
//
//	@Override
//	public boolean isAccountNonExpired() {
//		// TODO Auto-generated method stub
//		return true;
//	}
//
//	@Override
//	public boolean isAccountNonLocked() {
//		// TODO Auto-generated method stub
//		return true;
//	}
//
//	@Override
//	public boolean isCredentialsNonExpired() {
//		// TODO Auto-generated method stub
//		return true;
//	}
//
//	@Override
//	public boolean isEnabled() {
//		// TODO Auto-generated method stub
//		return active;
//	}
//}
