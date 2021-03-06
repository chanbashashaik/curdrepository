package com.phonebook.exceptions;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ExceptionResponse extends RuntimeException{
	private String message;
	private String description;
	private Date date;
	

}
