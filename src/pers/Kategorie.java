package pers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Kategorie {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long katID; 
	private String katName;
	@OneToOne(mappedBy="zugKat")
	private Notiz notiz;

	public Kategorie() {
		System.out.println("NoArg Constructor called"); 
	}
	
	public Kategorie(String kategorie) {
		katName=kategorie;
	}

	public String getKatName() {
		return katName;
	}

	public void setKatName(String katName) {
		this.katName = katName;
	}
	
	
	
}
