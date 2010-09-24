/*
 * This is an immutable object, which basically mimicks the AdminDocumentDto immutable object within mifos
 */

package org.springapp.controller;

public class DocumentDto {

    private Integer id;
    private String name;
    private String identifier;
    private boolean active;
    		
    public DocumentDto(Integer id, String name, String identifier, boolean active) {
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