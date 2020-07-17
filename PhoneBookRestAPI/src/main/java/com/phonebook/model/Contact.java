package com.phonebook.model;

import java.util.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.NumberFormat;

import lombok.Data;

@Data
public class Contact {
	
	 private Long contact_id;
	 @Size(min=4,max=10)
	 private String contact_name;
	 @Email
	 private String contact_email;
	 @NotNull
	 private Long contact_number;
	 private Date create_date;
	 private Date update_date;
	 private Boolean delete_switch=false;

}
