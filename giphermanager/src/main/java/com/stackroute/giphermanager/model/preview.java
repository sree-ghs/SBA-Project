package com.stackroute.giphermanager.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class preview {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(updatable = false, nullable = false)
	private long previewID;
	
	private String mp4;
	private String mp4_size;
	private String width;
	private String height;
	
	public String getMp4() {
		return mp4;
	}
	public void setMp4(String mp4) {
		this.mp4 = mp4;
	}
	public String getMp4_size() {
		return mp4_size;
	}
	public void setMp4_size(String mp4_size) {
		this.mp4_size = mp4_size;
	}
	public String getWidth() {
		return width;
	}
	public void setWidth(String width) {
		this.width = width;
	}
	public String getHeight() {
		return height;
	}
	public void setHeight(String height) {
		this.height = height;
	}
	
}
