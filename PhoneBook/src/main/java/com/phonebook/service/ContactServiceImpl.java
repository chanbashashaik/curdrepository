package com.phonebook.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phonebook.entity.ContactEntity;
import com.phonebook.model.Contact;
import com.phonebook.repository.ContactRepository;

@Service
public class ContactServiceImpl implements ContactService {
	
	@Autowired
	ContactRepository phrepo;

	@Override
	public boolean saveContact(Contact contact) {
		ContactEntity entity = new ContactEntity();
		BeanUtils.copyProperties(contact, entity);
		ContactEntity saveEntity = phrepo.save(entity);
		return saveEntity.getContact_id()!=null;
	}

	@Override
	public List<Contact> getAllContacts() {
		List<ContactEntity> findAll = phrepo.findAll();

		return findAll.stream().map(entity -> {
			Contact contact = new Contact();
			BeanUtils.copyProperties(entity, contact);
			return contact;
		}).collect(Collectors.toList()).stream().filter(entities -> entities.getDelete_switch().equals(false))
				.collect(Collectors.toList());

	}

	@Override
	public Contact getContactByID(Long id) {
		
		Optional<ContactEntity> findById = phrepo.findById(id);
		if(findById.isPresent()) {
			ContactEntity contactEntity = findById.get();
	
			Contact contact = new Contact();
		
			BeanUtils.copyProperties(contactEntity, contact);
			return contact;
		}
		return null;
	}

	

		
}
