package com.stackroute.giphermanager.service;

import java.util.List;

import com.stackroute.giphermanager.exception.BookmarkedNotFoundException;
import com.stackroute.giphermanager.model.BookMarkedGiphyObject;
import com.stackroute.giphermanager.model.FavouriteGiphyObject;
import com.stackroute.giphermanager.model.GiphyObject;

public interface FavouriteService {
	
	boolean createFavourite(GiphyObject giphyObject, String userId);
	boolean deleteFavourite(String userId, String giphyId) throws BookmarkedNotFoundException;

//    GiphyObject updateFavourite(GiphyObject giphyObject, String giphyId, String userId) throws BookmarkedNotFoundException;


    List<FavouriteGiphyObject> getAllFavouriteByUserId(String userId);


}
