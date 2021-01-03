package pers;


import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;


@Entity
public class Notizkasten {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long nkID;
    private String thema;
    
    @OneToMany(
            mappedBy = "notizkasten",
            cascade = CascadeType.ALL,
            orphanRemoval = true
        )
    private List<Notiz> notizen;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "admin_id", referencedColumnName = "aID")
    private Admin admin; 
//    @OneToMany(mappedBy="parent")
//    private List<Nutzer> nkNutzer;
//    
    protected Notizkasten() {
    	System.out.println("NoArg Constructor called");
    }

    public Notizkasten(String thema) {
    	this.thema = thema;
    }

	public long getNkID() {
		return nkID;
	}

	public void setNkID(long nkID) {
		this.nkID = nkID;
	}

	public String getThema() {
		return thema;
	}

	public void setThema(String thema) {
		this.thema = thema;
	}

	public List<Notiz> getNotizen() {
		return notizen;
	}

	public void setNotizen(List<Notiz> notizen) {
		this.notizen = notizen;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

//	public List<Nutzer> getNkNutzer() {
//		return nkNutzer;
//	}
//
//	public void setNkNutzer(List<Nutzer> nkNutzer) {
//		this.nkNutzer = nkNutzer;
//	}
//    
    

}
