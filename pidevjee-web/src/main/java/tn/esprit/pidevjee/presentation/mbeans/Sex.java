package tn.esprit.pidevjee.presentation.mbeans;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import tn.esprit.pidevjee.persistence.Sexe;
@ManagedBean
@ApplicationScoped
public class Sex {
	public Sexe[] getSexe(){
		return Sexe.values();

}
}
