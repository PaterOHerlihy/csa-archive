package beans;

import java.io.Serializable;
import javax.enterprise.context.*;
import javax.inject.Named;

import pers.Admin;
import pers.AdminService;
import pers.Notizkasten;
import pers.NotizkastenService;


@Named
@ApplicationScoped
public class NKBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7910599635791177899L;
	private String nkName;
	private String admPW;
	private Notizkasten tempNK;
	private Admin tempAdm;
	private NotizkastenService data = new NotizkastenService();
	private AdminService dataA = new AdminService();
	

	
	public String getNkName() {
		return nkName;
	}
	public void setNkName(String nkName) {
		this.nkName = nkName;
	}
	public String getAdmPW() {
		return admPW;
	}
	public void setAdmPW(String admPW) {
		this.admPW = admPW;
	}
	
	public String createNKwADM(){
		if ((nkName==null || admPW == null)||(nkName=="" || admPW=="")) {
			System.out.println("unerlaubte Eingabe");
			
		}
		
		tempAdm= new Admin(admPW);
		tempNK = new Notizkasten(nkName);
		tempAdm.setAdministNK(tempNK);
		tempNK.setAdmin(tempAdm);
		data.persist(tempNK);
//		dataA.persist(tempAdm);
		return "/index.xhtml?faces-redirect=true";
		
	}
	
	public void troll() {
		System.out.println("Hier könnte ihre Aktion funktionieren");
	}
	
}
