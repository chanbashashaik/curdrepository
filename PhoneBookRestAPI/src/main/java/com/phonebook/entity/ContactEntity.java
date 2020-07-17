package com.phonebook.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;
import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;


import lombok.Data;

@Data
@Entity
@Table(name = "CONTACTS_DTLS")
public class ContactEntity {

	@Id
	@SequenceGenerator(name = "cid_seq_gen", sequenceName = "CONTACT_ID_SEQ", allocationSize = 1)
	@GeneratedValue(generator = "cid_seq_gen", strategy = GenerationType.SEQUENCE)
	private Long contact_id;
	
	private String contact_name;
	private String contact_email;
	private Long contact_number;
	@CreationTimestamp
	@Temporal(TemporalType.DATE)
	@Column(updatable = false)
	private Date create_date;
	@UpdateTimestamp
	@Temporal(TemporalType.DATE)
	@Column(insertable = false)
	private Date update_date;
	private Boolean delete_switch=false;
}
