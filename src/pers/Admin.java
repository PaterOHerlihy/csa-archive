package pers;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

import org.hibernate.annotations.ColumnTransformer;

@Entity
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="aID")
    private long aID;
    private String password;
    @OneToOne(mappedBy = "admin")
    private Notizkasten administNK;

    protected Admin() {
    	System.out.println("NoArg Constructor called");
    }
    
    public Admin(String pw) {
    	password=pw;
    }

	public long getaID() {
		return aID;
	}

	public void setaID(long aID) {
		this.aID = aID;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Notizkasten getAdministNK() {
		return administNK;
	}

	public void setAdministNK(Notizkasten administNK) {
		this.administNK = administNK;
	}
    
    
    
}
