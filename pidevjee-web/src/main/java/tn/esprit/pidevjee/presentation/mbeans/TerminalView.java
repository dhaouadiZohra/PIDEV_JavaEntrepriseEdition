package tn.esprit.pidevjee.presentation.mbeans;

import java.util.Date;

import javax.faces.bean.ManagedBean;


@ManagedBean
public class TerminalView {
	public String handleCommand(String command, String[] params) {
        if(command.equals("hello")) {
            if(params.length > 0)
                return "Hello " + params[0];       
            
            else
                return "Hello beautiful Stranger <3";
        }
       
        else if(command.equals("date"))
            return new Date().toString();
        
        else if(command.equals("Whats your name Haroun ?"))
            return command.concat("My name is Haroun :p ");
   
        	else
            return command + " not found";
    }
	

}