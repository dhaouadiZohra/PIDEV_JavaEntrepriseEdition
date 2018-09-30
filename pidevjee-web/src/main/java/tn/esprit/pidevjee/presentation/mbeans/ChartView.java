package tn.esprit.pidevjee.presentation.mbeans;



import javax.annotation.PostConstruct;
import javax.ejb.EJB;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import org.primefaces.model.chart.PieChartModel;

import tn.esprit.pidevjee.services.CommentService;
import tn.esprit.pidevjee.services.DocumentService;





@ManagedBean
public class ChartView implements Serializable {
	@EJB
	CommentService commentService ;
	
    private PieChartModel pieModel1;
    private PieChartModel pieModel2;
   
   
 
    @PostConstruct
    public void init() {
        createPieModels();
    }
 
    public PieChartModel getPieModel1() {
        return pieModel1;
    }
     
    public PieChartModel getPieModel2() {
        return pieModel2;
    }
     
    private void createPieModels() {
        createPieModel1();
        createPieModel2();
    }
   
    private void createPieModel1() {
    	
    	
    	
        pieModel1 = new PieChartModel();
       int n =(int) commentService.documentNonValideJPQL();
       int m =(int) commentService.documentValideJPQL();
        pieModel1.set("valide",m);
        pieModel1.set("non valide", n);
       
         
        pieModel1.setTitle("Document");
        pieModel1.setLegendPosition("w");
    }
     
    private void createPieModel2() {
  
        pieModel2 = new PieChartModel();
        
         
        pieModel2.set("Brand 1",0);
        pieModel2.set("Brand 2", 325);
        pieModel2.set("Brand 3", 702);
        pieModel2.set("Brand 4", 421);
         
        pieModel2.setTitle("Custom Pie");
        pieModel2.setLegendPosition("e");
        pieModel2.setFill(false);
        pieModel2.setShowDataLabels(true);
        pieModel2.setDiameter(150);
    }
    
    
    
    
}

