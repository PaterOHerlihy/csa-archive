package beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.bean.NoneScoped;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;

import pers.NotizService;
import pers.Notizkasten;
import pers.NotizkastenService;
import pers.Notiz;

@Named
@NoneScoped
public class ListBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -690658784840005197L;
	private  NotizService nData = new NotizService();
	private  ArrayList<Notiz> list = nData.findAll();
	private long nkId;
	private NotizkastenService nkData= new NotizkastenService();
	private List<Notiz> notizlist;
	private Notizkasten tempNk;
	
	
	
	public void setNotizlist(List<Notiz> notizlist) {
		this.notizlist = notizlist;
	}


	@PostConstruct
	public String init() {
		tempNk = nkData.findById(nkId);
		notizlist = tempNk.getNotizen();
		
		return "/notizuebersicht2.xhtml?faces-redirect=true";
	}
	
	
	
	public Notizkasten getTempNk() {
		return tempNk;
	}



	public void setTempNk(Notizkasten tempNk) {
		this.tempNk = tempNk;
	}



	public List<Notiz> getNotizlist() {
		return notizlist;
	}
	public void setNotizlist(ArrayList<Notiz> notizlist) {
		this.notizlist = notizlist;
	}
	public long getNkId() {
		return nkId;
	}
	public void setNkId(long nkId) {
		this.nkId = nkId;
	}
	
	public NotizService getnData() {
		return nData;
	}
	public void setnData(NotizService nData) {
		this.nData = nData;
	}
	public ArrayList<Notiz> getList() {
		return list;
	}
	public void setList(ArrayList<Notiz> list) {
		this.list = list;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String delete(long id) {
		nData.delete(id);
		return "/index.xhtml?faces-redirect=true";
	}
	
	

}
