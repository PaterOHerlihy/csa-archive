package beans;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.enterprise.context.*;
import javax.faces.bean.NoneScoped;
import javax.inject.Named;

import pers.Kategorie;
import pers.Notiz;
import pers.NotizService;
import pers.NotizkastenService;
import pers.Nutzer;

@Named
@NoneScoped
public class NotizBean implements Serializable {
    private static final long serialVersionUID = 3020832L;
    
    private String titel;
    private String inhalt;
    private String kategorie;
    private String autor;
    private Date erstellung = null;
    private Date modifiziert;
    private NotizService data = new NotizService();
    private long nkId;
    private NotizkastenService nkData = new NotizkastenService();
    
	private static ArrayList <Notiz> liste = new ArrayList<>();
    
    
    
	
	
	
	
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public long getNkId() {
		return nkId;
	}
	public void setNkId(long nkId) {
		this.nkId = nkId;
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
	
	public String getKategorie() {
		return kategorie;
	}
	public void setKategorie(String kategorie) {
		this.kategorie = kategorie;
	}

//    public Date getErstellung() {
//		return erstellung;
//	}
//	public void setErstellung() {
//		this.erstellung = new Date();
//	}
	
	public Date getModifiziert() {
		return modifiziert;
	}
	public void setModifiziert() {
		this.modifiziert = new Date();
	}
    
	public ArrayList<Notiz> getListe() {
	    return liste;
	}
	
	public String init() {
		
		System.out.println(nkId);
		
		return "/notiz_anlegen.xhtml?faces-redirect=true";
	}
	
	public String insert() {
	    Notiz n = new Notiz(titel,inhalt);
	    n.setErstellerID(new Nutzer(autor));
	    n.setCreatedOn(Calendar.getInstance().getTime());
	    n.setParentNotK(nkData.findById(nkId));
	    n.setZugKat(new Kategorie(kategorie));
	  
	    data.persist(n);
	    liste.add(n);	//used just for JSF Test Vision
	    return "/index.xhtml?faces-redirect=true";
	}
	
	public void delete() {
//	    liste.remove(this);
	}
	
	public void troll() {
		System.out.println("Hier könnte ihre Aktion funktionieren");
	}
}