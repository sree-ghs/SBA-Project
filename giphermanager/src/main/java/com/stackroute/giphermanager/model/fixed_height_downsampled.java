package com.stackroute.giphermanager.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class fixed_height_downsampled {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(updatable = false, nullable = false)
	private long fixed_height_downsampledId;
	
	private String url;
	private String width;
	private String height;
	private String size;
	private String webp;
	private String webp_size;
	
	
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
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
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getWebp() {
		return webp;
	}
	public void setWebp(String webp) {
		this.webp = webp;
	}
	public String getWebp_size() {
		return webp_size;
	}
	public void setWebp_size(String webp_size) {
		this.webp_size = webp_size;
	}
	
	
}
