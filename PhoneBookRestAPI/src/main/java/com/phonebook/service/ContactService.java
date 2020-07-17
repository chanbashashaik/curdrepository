package com.phonebook.service;

import java.util.List;

import com.phonebook.model.Contact;

public interface ContactService {
	
	public Contact saveContact(Contact contact);
	public List<Contact> getAllContacts();
	public Contact getContactByID(Long id);
	public void deleteContactByID(Long id);

	

}
