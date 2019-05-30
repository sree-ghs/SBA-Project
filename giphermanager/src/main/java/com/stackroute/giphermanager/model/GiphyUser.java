package com.stackroute.giphermanager.model;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class GiphyUser {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(updatable = false, nullable = false)
	private long giphyUserID;
		
	private String userId;
//	private String giphyId;

	@OneToMany(cascade = CascadeType.ALL)
	private List<GiphyObject> giphyObject;
	
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	

	
	
//	public String getGiphyId() {
//		return giphyId;
//	}
//	public void setGiphyId(String giphyId) {
//		this.giphyId = giphyId;
//	}
	public List<GiphyObject> getGiphyObject() {
		return giphyObject;
	}
	public void setGiphyObject(List<GiphyObject> giphyObject) {
		this.giphyObject = giphyObject;
	}

	
	
	
	
	
}
