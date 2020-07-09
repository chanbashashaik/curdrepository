package com.phonebook.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.phonebook.model.Contact;
import com.phonebook.service.ContactServiceImpl;

@Controller
@RequestMapping("/apple")
public class ContactController {
	@Autowired
	ContactServiceImpl cnctSer;
	
	@GetMapping({"/","/index"})
	public String loadContactPage(Model model) {
		Contact contact = new Contact();
		model.addAttribute("msg", "ContactInfo");
		model.addAttribute("contact",contact);
		return "contactinfo";
	}
	
	@PostMapping("/addcontact")
	public String addContact(@ModelAttribute("contact") Contact contact, Model modle, RedirectAttributes redirectAttributes) {
		
		boolean saveContact = cnctSer.saveContact(contact);
		if(saveContact) {
			redirectAttributes.addFlashAttribute("sussMsg", contact.getContact_name()+" is Saved Sucessfully");
		}
		else {
			redirectAttributes.addAttribute("errMsg","faild to save contact");
		}
		return "redirect:/apple/";
	}

	@GetMapping("/viewcontacts")
	public String getAllContacts(Model model) {
		model.addAttribute("msg", "View All Contacts");
		List<Contact> allContacts = cnctSer.getAllContacts();
		model.addAttribute("contacts", allContacts);
		return "viewcontacts";
		}
	
	@GetMapping("/editcontact")
	public String editContacts(@RequestParam("cid") Long cid ,Model model) {
		model.addAttribute("msg", "Edit ContactInfo");
		Contact contactByID = cnctSer.getContactByID(cid);
		model.addAttribute("contact", contactByID);
		return "contactinfo";
	}
	
	@GetMapping("/deletecontact")
	public String deleteContacts(@RequestParam("cid") Long cid ,Model model) {
		
		Contact contactByID = cnctSer.getContactByID(cid);
		contactByID.setDelete_switch(true);
		cnctSer.saveContact(contactByID);
		List<Contact> allContacts = cnctSer.getAllContacts();
		model.addAttribute("contacts", allContacts);

		return "viewcontacts";
	}

}
