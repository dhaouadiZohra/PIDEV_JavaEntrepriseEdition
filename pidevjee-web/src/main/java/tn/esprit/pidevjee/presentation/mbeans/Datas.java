package tn.esprit.pidevjee.presentation.mbeans;


import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import tn.esprit.pidevjee.persistence.*;

@ManagedBean
@ApplicationScoped
public class Datas {
	
	public Role[] getRoles(){
		return Role.values();
		
		
	}

}