package pers;

import java.util.Date;

import javax.persistence.*;


@Entity
public class Notiz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long nID;
    private String titel;
    private String inhalt;
    @ManyToOne(fetch = FetchType.EAGER)
    private Notizkasten notizkasten;   
    @Temporal(TemporalType.TIMESTAMP)
    private java.util.Date lastTimeEdited;
    @Temporal(TemporalType.TIMESTAMP)
    private java.util.Date createdOn;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="Creator_ID", referencedColumnName = "nuID")
    private Nutzer erstellerID;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="Kat_ID", referencedColumnName = "katID")
    private Kategorie zugKat;
    
    

    public Notiz() 
    { 
        System.out.println("NoArg Constructor called"); 
    } 
    
    
    public Notiz(String titel, String inhalt) {
		super();
		this.titel = titel;
		this.inhalt = inhalt;
	}


    
	

	public String getTitel() {
		return titel;
	}

	public void setTitel(String titel) {
		this.titel = titel;
	}

	public String getInhalt() {
		return inhalt;
	}

	public void setInhalt(String inhalt) {
		this.inhalt = inhalt;
	}


	public long getnID() {
		return nID;
	}


	public void setnID(long nID) {
		this.nID = nID;
	}


	public Notizkasten getParentNotK() {
		return notizkasten;
	}


	public void setParentNotK(Notizkasten parentNotK) {
		this.notizkasten = parentNotK;
	}


	public java.util.Date getLastTimeEdited() {
		return lastTimeEdited;
	}


	public void setLastTimeEdited(java.util.Date lastTimeEdited) {
		this.lastTimeEdited = lastTimeEdited;
	}


	public java.util.Date getCreatedOn() {
		return createdOn;
	}


	public void setCreatedOn(java.util.Date createdOn) {
		this.createdOn = createdOn;
	}


	public Nutzer getErstellerID() {
		return erstellerID;
	}


	public void setErstellerID(Nutzer erstellerID) {
		this.erstellerID = erstellerID;
	}


	public Kategorie getZugKat() {
		return zugKat;
	}


	public void setZugKat(Kategorie zugKat) {
		this.zugKat = zugKat;
	}
    
    

}