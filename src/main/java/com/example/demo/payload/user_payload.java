package com.example.demo.payload;

import jakarta.persistence.Column;
//import jakarta.persistence.Id;
//import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class user_payload {
	
	private int id;

	@Column(name="Username",nullable=false,length =40)
private String name;
	
	
private String email;


	@Column(length =20)
private String password;
}
