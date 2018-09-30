package tn.esprit.pidevjee.interfaces;

import java.util.List;


import tn.esprit.pidevjee.persistence.Document;


public interface InterfaceDocumentServiceRemote {
	
	
		public void create(Document doc);
		public boolean deleteDocumentById(int did);
		public List<Document> getAllDocs();
	    public void AffectDocumentUser (int uid , int did);
        
}
