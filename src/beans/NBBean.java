package beans;

import java.io.Serializable;
import java.util.Calendar;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Named;

import pers.Notiz;
import pers.NotizService;

@Named
@SessionScoped
public class NBBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5634008840501457035L;
	
	private long id;
	private NotizService data = new NotizService();
	private Notiz not;
	private String inhalt;
	private String preInhalt;
	
	
	
	
	
	public String getPreInhalt() {
		return preInhalt;
	}

	public void setPreInhalt(String preInhalt) {
		this.preInhalt = preInhalt;
		System.out.println(preInhalt);
	}

	public NotizService getData() {
		return data;
	}

	public void setData(NotizService data) {
		this.data = data;
	}

	public String getInhalt() {
		return inhalt;
	}

	public void setInhalt(String inhalt) {
		this.inhalt = inhalt;
	}

	public Notiz getNot() {
		return not;
	}
	
	public String update() {
		System.out.println("Test: "+inhalt);
		not.setInhalt(preInhalt);
		not.setLastTimeEdited(Calendar.getInstance().getTime());
		data.update(not);
		return "/notizuebersicht.xhtml?faces-redirect=true";
	}

	public void setNot(Notiz not) {
		this.not = not;
	}

	public long getId() {
		return id;
	}
	
	
	
	
	public void setId(long id) {
		this.id = id;
	}

	@PostConstruct
	public String init() {
		System.out.println(id);
		not = data.findById(id);
		preInhalt=not.getInhalt();
		return "/notizbearbeiten.xhtml?faces-redirect=true";
		
	}
	
	public String delete() {
		
		data.delete(not.getnID());
		
		return "/notizbearbeiten.xhtml?faces-redirect=true";
	}

	
	
	

}
