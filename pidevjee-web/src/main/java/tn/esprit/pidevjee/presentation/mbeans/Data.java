package tn.esprit.pidevjee.presentation.mbeans;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import tn.esprit.pidevjee.persistence.etat;



@ManagedBean
@ApplicationScoped
public class Data {
	public etat[] getetat()
	{
		return etat.values();
		
	}
public Data() {
	// TODO Auto-generated constructor stub
}


}
