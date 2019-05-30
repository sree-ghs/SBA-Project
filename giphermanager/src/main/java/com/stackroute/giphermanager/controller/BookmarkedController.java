package com.stackroute.giphermanager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.giphermanager.exception.BookmarkedNotFoundException;
import com.stackroute.giphermanager.model.BookMarkedGiphyObject;
import com.stackroute.giphermanager.model.GiphyObject;
import com.stackroute.giphermanager.service.BookmarkedService;

import io.swagger.annotations.Api;

@RestController
@Api
public class BookmarkedController {

	BookmarkedService bookmarkedService;
	
	@Autowired
	public BookmarkedController(BookmarkedService bookmarkedService) {
		this.bookmarkedService = bookmarkedService;
	}
	
		@CrossOrigin
		@PostMapping("/api/v1/giphy/bookmark/{userId}")
		public ResponseEntity<BookMarkedGiphyObject> createBookmark(@RequestBody GiphyObject giphyObject, @PathVariable("userId")String userId){
			BookMarkedGiphyObject bookMarkedGiphyObject = new BookMarkedGiphyObject();
			if(bookmarkedService.createBookmark(giphyObject, userId)) {
				bookMarkedGiphyObject.setBookMarkFlag(true);
				bookMarkedGiphyObject.setGiphyObject(giphyObject);
				return new ResponseEntity<BookMarkedGiphyObject>(bookMarkedGiphyObject, HttpStatus.CREATED);
			}else {
				return new ResponseEntity<BookMarkedGiphyObject>(HttpStatus.CONFLICT);
			}
		}
		
		@CrossOrigin
		@DeleteMapping("/api/v1/giphy/bookmark/{userId}/{giphyId}")
		public ResponseEntity<BookMarkedGiphyObject> deleteBookmark(@PathVariable("userId")String userId, @PathVariable("giphyId")String giphyId) throws BookmarkedNotFoundException{
			boolean status = false;
			BookMarkedGiphyObject bookMarkedGiphyObject = new BookMarkedGiphyObject();
			status = bookmarkedService.deleteBookmark(userId, giphyId);
			
			if(status == true) {
				bookMarkedGiphyObject.setBookMarkFlag(false);
				bookMarkedGiphyObject.setGiphyObject(null);
				return new ResponseEntity<BookMarkedGiphyObject>(bookMarkedGiphyObject,HttpStatus.OK);
			}else {
				return new ResponseEntity<BookMarkedGiphyObject>(HttpStatus.NOT_FOUND);
			}
		}
		
		/*@CrossOrigin
		@PutMapping("/api/v1/giphy/bookmark/{userId}/{giphyId}")
		public ResponseEntity<GiphyObject> updateeNote(@RequestBody GiphyObject giphyObject,@PathVariable("userId")String userId, @PathVariable("giphyId")String giphyId){
			GiphyObject updatedGiphy = null;
			try {
				updatedGiphy = bookmarkedService.updateBookmark(giphyObject, giphyId, userId);
			}catch(BookmarkedNotFoundException e) {
				e.printStackTrace();
			}
			
			if(updatedGiphy != null) {
				return new ResponseEntity<GiphyObject>(HttpStatus.OK);
			}else {
				return new ResponseEntity<GiphyObject>(HttpStatus.NOT_FOUND);
			}
		}*/
		

		@CrossOrigin
		@GetMapping("/api/v1/giphy/bookmark/{userId}")
		public ResponseEntity<List<BookMarkedGiphyObject>> getAllBookMarked(@PathVariable("userId") String id) {
			List<BookMarkedGiphyObject> bookmarked = bookmarkedService.getAllBookmarkedByUserId(id);
			return new ResponseEntity<List<BookMarkedGiphyObject>>(bookmarked,HttpStatus.OK);
		}
		

}
