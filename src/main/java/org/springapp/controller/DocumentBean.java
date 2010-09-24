/*
 * Java bean that will become the form backed object behind the updateDoc.ftl and the editDocs.ftl.
 * Probably also for the newDoc.ftl form. 
 * 
 * This will contain data from the DocumentDto object.
 * 
 * Work In Progress.
 */

package org.springapp.controller;

public class DocumentBean {

    private Integer id;
    private String name;
    private String identifier;
    private boolean active;
    		
    public DocumentBean(Integer id, String name, String identifier, boolean active) {
        this.id = id;
        this.name = name;
        this.identifier = identifier;
        this.active = active;
    }

    public Integer getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getIdentifier() {
        return this.identifier;
    }

    public boolean isActive() {
        return this.active;
    }
}