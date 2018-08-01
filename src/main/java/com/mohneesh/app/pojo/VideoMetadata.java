package com.mohneesh.app.pojo;

import javax.persistence.Entity;

import org.springframework.stereotype.Component;

@Entity
//@Component
public class VideoMetadata {

	private String videoDescription;
	private String videoName;
	private int version;
	private int schemaVersion;
	private String createdBy;
	
	private String ownerApp;
	
	
	
	
	
	public String getOwnerApp() {
		return ownerApp;
	}
	public void setOwnerApp(String ownerApp) {
		this.ownerApp = ownerApp;
	}
	public String getVideoDescription() {
		return videoDescription;
	}
	public void setVideoDescription(String videoDescription) {
		this.videoDescription = videoDescription;
	}
	public String getVideoName() {
		return videoName;
	}
	public void setVideoName(String videoName) {
		this.videoName = videoName;
	}
	public int getVersion() {
		return version;
	}
	public void setVersion(int version) {
		this.version = version;
	}
	public int getSchemaVersion() {
		return schemaVersion;
	}
	public void setSchemaVersion(int schemaVersion) {
		this.schemaVersion = schemaVersion;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	
	
 	
	


}
