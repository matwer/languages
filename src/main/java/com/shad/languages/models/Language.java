package com.shad.languages.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
/**
 * @author Matthew Werner
 *
 **/
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import com.sun.istack.NotNull;


// let 'em know we're connecting to a database and creating a languages table
@Entity
@Table(name="languages")
public class Language {
	// build the table
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull
    @Size(min = 2, max = 20)
    private String name;
    @NotNull
    @Size(min = 2, max = 20)
    private String creator;
    @NotNull
    private String version;
    
    
    // this sets the pattern for saving the date in the database
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
    
    // this grabs the date before a record is created
    @PrePersist
    protected void onCreate(){
    	this.createdAt = new Date();
    }
    
    // this tells the system not to update createdAt with each save
    @Column(updatable=false)

    // this grabs the date when a record is updated
    @PreUpdate
    protected void onUpdate(){
    	this.updatedAt = new Date();
    }
    
    // a constructor with no parameters ** REQUIRED **
    public Language() {}
    
    // constructor with arguments
    public Language(String name, String creator, String version) {
    	this.name = name;
    	this.creator = creator;
    	this.version = version;
    }

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

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}
	
}
