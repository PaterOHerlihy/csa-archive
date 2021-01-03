package beans;

import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import pers.Notizkasten;
import pers.NotizkastenService;

@ManagedBean(name = "epoint")
@ApplicationScoped
public class EntryBean {
	
	private NotizkastenService data = new NotizkastenService();
	private List<Notizkasten> auflist = data.findAll();
	
	public List<Notizkasten> getAuflist() {
		return auflist;
	}
	public void setAuflist(List<Notizkasten> auflist) {
		this.auflist = auflist;
	}
	
	

}
