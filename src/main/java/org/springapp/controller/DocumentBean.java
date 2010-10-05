/*
 * Java bean that will become the form backed object behind the updateDoc.ftl and the editDocs.ftl.
 * Probably also for the newDoc.ftl form. 
 * 
 * This will contain data from the DocumentDto object.
 * 
 * Work In Progress.
 */

package org.springapp.controller;

import java.util.ArrayList;
import java.util.List;


public class DocumentBean {

    private Integer id = -1;			// unique ID associated with document
    
    //@NotEmpty @Size(min=1, max=100)		// not sure about max size
    private String name = "";			// document title
    
    //@NotEmpty
    private String accountType = "";// savings or loan
    
    private List<String> showStatus = new ArrayList<String>();
    
    /*
     * TODO: Also need to add an object (file object?) to which
     * an uploaded file will be bound.
     */
    
    public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public List<String> getshowStatus() {
		return showStatus;
	}
	public void setshowStatus(List<String> showStatus) {
		System.out.println("setshowStatus - List input");
		this.showStatus = showStatus;
	}
	public void setshowStatus(String[] showStatus) {
		System.out.println("setshowStatus - String[] input");
		for (int i = 0; i < showStatus.length; i++) {
	    	this.showStatus.add( showStatus[i] );
	    }
	}  
}