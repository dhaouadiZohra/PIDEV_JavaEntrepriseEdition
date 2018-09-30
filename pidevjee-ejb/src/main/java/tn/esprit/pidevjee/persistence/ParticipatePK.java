package tn.esprit.pidevjee.persistence;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Embeddable;
@Embeddable
public class ParticipatePK implements Serializable {
private int iduser;
private int idevent;
private Date datepart;
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((datepart == null) ? 0 : datepart.hashCode());
	result = prime * result + idevent;
	result = prime * result + iduser;
	return result;
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	ParticipatePK other = (ParticipatePK) obj;
	if (datepart == null) {
		if (other.datepart != null)
			return false;
	} else if (!datepart.equals(other.datepart))
		return false;
	if (idevent != other.idevent)
		return false;
	if (iduser != other.iduser)
		return false;
	return true;
}


}
