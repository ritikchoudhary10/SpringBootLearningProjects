package com.ritik.entity;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"username"}))
public class UserInfo implements UserDetails{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1920155950326908034L;
	@Id
	@SequenceGenerator(initialValue = 1001 ,name = "User_gen" ,allocationSize = 1,sequenceName = "userId_generator")
	@GeneratedValue(generator = "User_gen" ,strategy = GenerationType.AUTO)
	private Integer id;
	@NonNull
	
	private String username;
	@NonNull
	private String password;
	@NonNull
	private String firstName;
	@NonNull
	private String lastName;
	@NonNull
	private String mailId;
	@NonNull
	private Long phoneNo;
	@NonNull
	private Integer enabled=1;
	@NonNull
	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name = "authorities",
					 joinColumns = @JoinColumn(name = "id" ))
	@Column(name = "authority")
	private List<String> authorities ;
	
	public List<GrantedAuthority> getAuthorities(){
		return this.authorities.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList());
	}
	
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
	
}
