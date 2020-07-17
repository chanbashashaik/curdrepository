package com.phonebook.resources;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.phonebook.exceptions.ExceptionResponse;
import com.phonebook.exceptions.UserNotFoundException;
import com.phonebook.model.Contact;
import com.phonebook.service.ContactServiceImpl;

import lombok.var;

@RestController
@RequestMapping("/apple")
public class ContactResources {

	@Autowired
	ContactServiceImpl cnctSer;

	@PostMapping("/contacts")
	public ResponseEntity<Contact> createContact(@Valid @RequestBody  Contact contact) {
		
		Contact savedContact=cnctSer.saveContact(contact);
		
		 URI location = ServletUriComponentsBuilder
					.fromCurrentRequest().pathSegment("/{id}")
		.buildAndExpand(savedContact.getContact_id()).toUri();
		
						
	return	ResponseEntity.created(location).build();

	}
	
	
	@GetMapping("/contacts")
	public ResponseEntity<List<Contact>> getAllContacts() {
		
		List<Contact> contacts= cnctSer.getAllContacts();
		if(contacts.isEmpty()) {
			throw new UserNotFoundException("no contacts are there!");
		}
		else {
		
		return new ResponseEntity<List<Contact>>(contacts, HttpStatus.FOUND);
		}
	}
		
	@GetMapping("/contacts/{id}")
	public ResponseEntity<Contact> getContactByID(@PathVariable("id") long id) {
		
		Contact contactFindByID= cnctSer.getContactByID(id);
		if(contactFindByID==null) {
			throw new UserNotFoundException(id+" contact not found");
		}
		else {
		return new ResponseEntity<Contact>(contactFindByID, HttpStatus.FOUND);
		}
	}
	
	  @PutMapping("/contacts/{cid}") 
	  public ResponseEntity<Contact> updateContacts(@PathVariable("cid") Long cid, @RequestBody Contact contactinfo)
	  { 
	  Contact contact = cnctSer.getContactByID(cid);
	  BeanUtils.copyProperties(contactinfo, contact); 
	  cnctSer.saveContact(contact);
	  //return
	   URI location = ServletUriComponentsBuilder
				.fromCurrentRequest().build()
				.toUri();
	  	return	ResponseEntity.created(location).build();
	  
	  }
	  
	  @DeleteMapping("/contacts/{cid}")
		public ResponseEntity<Contact> deleteContacts(@PathVariable("cid") Long cid) {
			Contact contactFindByID= cnctSer.getContactByID(cid);
		
			if(contactFindByID==null) {
				throw new UserNotFoundException(cid+" contact not found");
			}
			else {
			cnctSer.deleteContactByID(cid);
			return new ResponseEntity<Contact>(HttpStatus.OK);
			}
		}

	 

}
