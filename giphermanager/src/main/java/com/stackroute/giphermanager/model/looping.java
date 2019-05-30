package com.stackroute.giphermanager.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class looping {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(updatable = false, nullable = false)
	private long loopingID;

	private String mp4;

	public String getMp4() {
		return mp4;
	}

	public void setMp4(String mp4) {
		this.mp4 = mp4;
	}
	
}
