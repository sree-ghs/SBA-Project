package com.stackroute.giphermanager.service;

import java.util.List;

import com.stackroute.giphermanager.exception.BookmarkedNotFoundException;
import com.stackroute.giphermanager.model.BookMarkedGiphyObject;
import com.stackroute.giphermanager.model.GiphyObject;

public interface BookmarkedService {
	
	boolean createBookmark(GiphyObject giphyObject, String userId);
	boolean deleteBookmark(String userId, String giphyId) throws BookmarkedNotFoundException;

    GiphyObject updateBookmark(GiphyObject giphyObject, String giphyId, String userId) throws BookmarkedNotFoundException;

//    GiphyObject getBookmarkByBookmarkId(String userId,String giphyId) throws BookmarkedNotFoundException;

    List<BookMarkedGiphyObject> getAllBookmarkedByUserId(String userId);

//	GiphyObject getAllBookmarkedByUserId(String userId);
}
