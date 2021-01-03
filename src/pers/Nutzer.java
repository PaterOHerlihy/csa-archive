package pers;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Nutzer {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long nuID;
	private String name;
//	@ManyToOne(fetch=FetchType.LAZY)
//	@JoinColumn(name="Nutzer_ID")
//	private Notizkasten parent;
	@OneToOne(mappedBy="erstellerID")
	private Notiz createdNot;
	
	protected Nutzer() {
		 System.out.println("NoArg Constructor called"); 
	}
	
	public Nutzer(String name) {
		this.name=name;
	}
	
	public long getNuID() {
		return nuID;
	}
	public void setNuID(long nuID) {
		this.nuID = nuID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
//	public Notizkasten getParent() {
//		return parent;
//	}
//	public void setParent(Notizkasten parent) {
//		this.parent = parent;
//	}
	public Notiz getCreatedNot() {
		return createdNot;
	}
	public void setCreatedNot(Notiz createdNot) {
		this.createdNot = createdNot;
	} 

	
	
}
