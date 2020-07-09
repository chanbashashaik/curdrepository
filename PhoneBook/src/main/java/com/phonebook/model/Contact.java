package com.phonebook.model;

import java.util.Date;

import lombok.Data;

@Data
public class Contact {
	
	 private Long contact_id;
	 private String contact_name;
	 private String contact_email;
	 private Long contact_number;
	 private Date create_date;
	 private Date update_date;
	 private Boolean delete_switch=false;

}
