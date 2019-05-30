package com.stackroute.giphermanager.service;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.giphermanager.exception.BookmarkedNotFoundException;
import com.stackroute.giphermanager.model.BookMarkedGiphyObject;
import com.stackroute.giphermanager.model.GiphyObject;
import com.stackroute.giphermanager.model.GiphyUser;
import com.stackroute.giphermanager.repository.BookmarkedGiphyObjectRepository;
import com.stackroute.giphermanager.repository.BookmarkedRepository;

@Service
public class BookmarkedServiceImpl implements BookmarkedService {
	
	@Autowired
	BookmarkedRepository bookmarkedRepository;
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
	
	public boolean createBookmark(GiphyObject giphyObject, String userId) {
		
		boolean status = false;
		GiphyObject object = new GiphyObject();
		List<GiphyObject> giphyObjectList = new ArrayList<GiphyObject>();
		object = giphyObject;
		object.setImages(giphyObject.getImages());
		giphyObjectList.add(giphyObject);
		GiphyUser user = new GiphyUser();
		user.setUserId(userId);
//		user.setGiphyId(giphyObject.getId());
		user.setGiphyObject(giphyObjectList);
//		giphyObject.setNoteCreationDate(new Date());
		GiphyUser newUser = bookmarkedRepository.save(user);
		if(newUser == null) {
			status = false;
		}else {
			status = true;
		}
		return status;
	}
    public boolean deleteBookmark(String userId, String id) throws BookmarkedNotFoundException{
    	try {
   	boolean status = false;
		int flag = 0;
		GiphyUser user = new GiphyUser();
		List<GiphyObject> giphyObjects = bookmarkedRepository.findAllBookmarked(userId);
//		List<GiphyObject> giphyObjects = user.getGiphyObject();
	
		for(int i = 0; i < giphyObjects.size(); i++) {
			String getId = giphyObjects.get(i).getId();
			if( getId.equalsIgnoreCase(id)) {
				long giphyObjectId = giphyObjects.get(i).getGiphyId();
				giphyObjects.remove(i);
				user.setUserId(userId);
				user.setGiphyObject(giphyObjects);
				bookmarkedRepository.deleteBookmarkedGiphy(userId);
				bookmarkedGiphyObjectRepository.deleteByGiphyId(giphyObjectId);
				bookmarkedRepository.save(user);
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

    public GiphyObject updateBookmark(GiphyObject giphyObject, String giphyId, String userId) throws BookmarkedNotFoundException{
    	int index = 0;
    	GiphyObject tempGiphy = null;
		GiphyUser user = new GiphyUser();
		List<GiphyObject> giphyObjectsList = null;
		try{
			giphyObjectsList = bookmarkedRepository.findAllBookmarked(userId);
		}catch(Exception e)
		{
			throw new BookmarkedNotFoundException("");
		}
		
		
		for(int i = 0; i < giphyObjectsList.size(); i++) {
			if(giphyObjectsList.get(i).getId() == giphyId) {
				tempGiphy = giphyObjectsList.get(i);
				index = i;
			}
		}
		
		if(tempGiphy == null) {
			throw new BookmarkedNotFoundException("");
		}
		tempGiphy.setBitly_url(giphyObject.getBitly_url()); 
		tempGiphy.setContent_url(giphyObject.getContent_url());//.setNoteContent(note.getNoteContent());
		tempGiphy.setCreate_datetime(giphyObject.getCreate_datetime());//.setNoteCreatedBy(note.getNoteCreatedBy());
		tempGiphy.setEmbed_url(giphyObject.getEmbed_url());
		tempGiphy.setId(giphyObject.getId());
		tempGiphy.setImages(giphyObject.getImages());
		tempGiphy.setImport_datetime(giphyObject.getImport_datetime());
		tempGiphy.setRating(giphyObject.getRating());
		tempGiphy.setSlug(giphyObject.getSlug());
		tempGiphy.setSource(giphyObject.getSource());
		tempGiphy.setSource_post_url(giphyObject.getSource_post_url());
		tempGiphy.setSource_tld(giphyObject.getSource_tld());
		tempGiphy.setTitle(giphyObject.getTitle());
		tempGiphy.setTrending_datetime(giphyObject.getTrending_datetime());
		tempGiphy.setType(giphyObject.getType());
		tempGiphy.setUpdate_datetime(giphyObject.getUpdate_datetime());
		tempGiphy.setUrl(giphyObject.getUrl());
		tempGiphy.setUser(giphyObject.getUser());
		tempGiphy.setUsername(giphyObject.getUsername());
			
		giphyObjectsList.set(index, tempGiphy);
		user.setUserId(userId);
		user.setGiphyObject(giphyObjectsList);
		bookmarkedRepository.save(user);
		return tempGiphy;
    	
    }

//    public GiphyObject getBookmarkByBookmarkId(String userId,String giphyId) throws BookmarkedNotFoundException{
//    	
//    	GiphyObject tempGiphy = null;
//		GiphyUser user ;
//		try{
//			user = bookmarkedRepository.findById(userId).get();
//		}catch(Exception e)
//		{
//			throw new BookmarkedNotFoundException("");
//		}
//		List<GiphyObject> notes = user.getGiphyObject();
//		
//		for(int i = 0; i < notes.size(); i++) {
//			if(notes.get(i).getId() == giphyId) {
//				tempGiphy = notes.get(i);
//			}
//		}
//		if(tempGiphy == null) {
//			throw new BookmarkedNotFoundException("");
//		}
//		return tempGiphy;
//    }

    public List<BookMarkedGiphyObject> getAllBookmarkedByUserId(String userId){
    	List<GiphyObject> giphyObjectList = null;
    	List<BookMarkedGiphyObject> bookMarkedGiphyObjectList = new ArrayList<BookMarkedGiphyObject>();
    	giphyObjectList = bookmarkedRepository.findAllBookmarked(userId);
    	
    	for(int i = 0; i < giphyObjectList.size() ; i++) {
    		BookMarkedGiphyObject bookMarkedGiphyObject = new BookMarkedGiphyObject();
    		bookMarkedGiphyObject.setBookMarkFlag(true);
    		bookMarkedGiphyObject.setGiphyObject(giphyObjectList.get(i));
    		bookMarkedGiphyObjectList.add(bookMarkedGiphyObject);
    	}
//				.findById(userId).get();
//		giphyObjectList = user.getGiphyObject();
		
		return bookMarkedGiphyObjectList;
    }

//	public GiphyObject getAllBookmarkedByUserId(String userId){
//    	GiphyObject giphyObjectList = null;
//		GiphyUser user = bookmarkedRepository.findById(userId).get();
//		giphyObjectList = user.getGiphyObject();
//		
//		return giphyObjectList;
//    }

}
