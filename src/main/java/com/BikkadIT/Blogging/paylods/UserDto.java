package com.BikkadIT.Blogging.paylods;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@Data
public class UserDto {
	
	private int id;
	
	@NotEmpty
	@Size(min = 4, message = "username must be min 4 char")
	private String name;
	
	@Email(message = "Email add is not valid !!")
	private String email;
	
	@NotEmpty
	@Size(min = 3, max = 10, message = "password must be min 3 and max 10 char")

	private String password;
	
	@NotEmpty
	private String about;

}
