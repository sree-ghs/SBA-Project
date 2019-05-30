package com.stackroute.giphermanager.service;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.giphermanager.exception.BookmarkedNotFoundException;
import com.stackroute.giphermanager.model.BookMarkedGiphyObject;
import com.stackroute.giphermanager.model.FavouriteGiphyObject;
import com.stackroute.giphermanager.model.GiphyObject;
import com.stackroute.giphermanager.model.GiphyUser;
import com.stackroute.giphermanager.model.GiphyUserFavourite;
import com.stackroute.giphermanager.repository.BookmarkedGiphyObjectRepository;
import com.stackroute.giphermanager.repository.BookmarkedRepository;
import com.stackroute.giphermanager.repository.FavouriteRepository;

@Service
public class FavouriteServiceImpl implements FavouriteService {
	
	@Autowired
	FavouriteRepository favouriteRepository;
	@Autowired
	BookmarkedGiphyObjectRepository bookmarkedGiphyObjectRepository;
	
//	@Autowired
//	public BookmarkedServiceImpl(BookmarkedRepository bookmarkedRepository) {
//		this.bookmarkedRepository = bookmarkedRepository;
//	}
//	
//	@Autowired
//	public BookmarkedServiceImpl(BookmarkedGiphyObjectRepository bookmarkedGiphyObjectRepository) {
//		this.bookmarkedGiphyObjectRepository = bookmarkedGiphyObjectRepository;
//	}
	
	public boolean createFavourite(GiphyObject giphyObject, String userId) {
		
		boolean status = false;
		GiphyObject object = new GiphyObject();
		List<GiphyObject> giphyObjectList = new ArrayList<GiphyObject>();
		object = giphyObject;
		object.setImages(giphyObject.getImages());
		giphyObjectList.add(giphyObject);
		GiphyUserFavourite user = new GiphyUserFavourite();
		user.setUserId(userId);
//		user.setGiphyId(giphyObject.getId());
		user.setGiphyObject(giphyObjectList);
//		giphyObject.setNoteCreationDate(new Date());
		GiphyUserFavourite newUser = favouriteRepository.save(user);
		if(newUser == null) {
			status = false;
		}else {
			status = true;
		}
		return status;
	}
    public boolean deleteFavourite(String userId, String id) throws BookmarkedNotFoundException{
    	try {
   	boolean status = false;
		int flag = 0;
		GiphyUserFavourite user = new GiphyUserFavourite();
		List<GiphyObject> giphyObjects = favouriteRepository.findAllFavourite(userId);
//		List<GiphyObject> giphyObjects = user.getGiphyObject();
	
		for(int i = 0; i < giphyObjects.size(); i++) {
			String getId = giphyObjects.get(i).getId();
			if( getId.equalsIgnoreCase(id)) {
				long giphyObjectId = giphyObjects.get(i).getGiphyId();
				giphyObjects.remove(i);
				user.setUserId(userId);
				user.setGiphyObject(giphyObjects);
				favouriteRepository.deleteFavouriteGiphy(userId);
				bookmarkedGiphyObjectRepository.deleteByGiphyId(giphyObjectId);
				favouriteRepository.save(user);
				flag = 1;
				break;
			}
		}	
		
		if(flag == 1) {
			status = true;
		}else {
			status = false;
		}
		return status;
    	}catch(Exception e) {
    		throw new BookmarkedNotFoundException("");
    	}
    }

//    public GiphyObject updateFavourite(GiphyObject giphyObject, String giphyId, String userId) throws BookmarkedNotFoundException{
//    	int index = 0;
//    	GiphyObject tempGiphy = null;
//		GiphyUser user = new GiphyUser();
//		List<GiphyObject> giphyObjectsList = null;
//		try{
//			giphyObjectsList = bookmarkedRepository.findAllBookmarked(userId);
//		}catch(Exception e)
//		{
//			throw new BookmarkedNotFoundException("");
//		}
//		
//		
//		for(int i = 0; i < giphyObjectsList.size(); i++) {
//			if(giphyObjectsList.get(i).getId() == giphyId) {
//				tempGiphy = giphyObjectsList.get(i);
//				index = i;
//			}
//		}
//		
//		if(tempGiphy == null) {
//			throw new BookmarkedNotFoundException("");
//		}
//		tempGiphy.setBitly_url(giphyObject.getBitly_url()); 
//		tempGiphy.setContent_url(giphyObject.getContent_url());//.setNoteContent(note.getNoteContent());
//		tempGiphy.setCreate_datetime(giphyObject.getCreate_datetime());//.setNoteCreatedBy(note.getNoteCreatedBy());
//		tempGiphy.setEmbed_url(giphyObject.getEmbed_url());
//		tempGiphy.setId(giphyObject.getId());
//		tempGiphy.setImages(giphyObject.getImages());
//		tempGiphy.setImport_datetime(giphyObject.getImport_datetime());
//		tempGiphy.setRating(giphyObject.getRating());
//		tempGiphy.setSlug(giphyObject.getSlug());
//		tempGiphy.setSource(giphyObject.getSource());
//		tempGiphy.setSource_post_url(giphyObject.getSource_post_url());
//		tempGiphy.setSource_tld(giphyObject.getSource_tld());
//		tempGiphy.setTitle(giphyObject.getTitle());
//		tempGiphy.setTrending_datetime(giphyObject.getTrending_datetime());
//		tempGiphy.setType(giphyObject.getType());
//		tempGiphy.setUpdate_datetime(giphyObject.getUpdate_datetime());
//		tempGiphy.setUrl(giphyObject.getUrl());
//		tempGiphy.setUser(giphyObject.getUser());
//		tempGiphy.setUsername(giphyObject.getUsername());
//			
//		giphyObjectsList.set(index, tempGiphy);
//		user.setUserId(userId);
//		user.setGiphyObject(giphyObjectsList);
//		bookmarkedRepository.save(user);
//		return tempGiphy;
//    	
//    }



    public List<FavouriteGiphyObject> getAllFavouriteByUserId(String userId){
    	List<GiphyObject> giphyObjectList = null;
    	List<FavouriteGiphyObject> favouriteGiphyObjectList = new ArrayList<FavouriteGiphyObject>();
    	giphyObjectList = favouriteRepository.findAllFavourite(userId);
    	
    	for(int i = 0; i < giphyObjectList.size() ; i++) {
    		FavouriteGiphyObject favouriteGiphyObject = new FavouriteGiphyObject();
    		favouriteGiphyObject.setFavouriteFlag(true);
    		favouriteGiphyObject.setGiphyObject(giphyObjectList.get(i));
    		favouriteGiphyObjectList.add(favouriteGiphyObject);
    	}
		
		return favouriteGiphyObjectList;
    }



}
