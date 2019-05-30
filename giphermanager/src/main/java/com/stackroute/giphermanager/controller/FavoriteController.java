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
import com.stackroute.giphermanager.model.FavouriteGiphyObject;
import com.stackroute.giphermanager.model.GiphyObject;
import com.stackroute.giphermanager.service.BookmarkedService;
import com.stackroute.giphermanager.service.FavouriteService;

import io.swagger.annotations.Api;


@RestController
@Api
public class FavoriteController {

	
	

	FavouriteService favouriteService;
		
		@Autowired
		public FavoriteController(FavouriteService favouriteService) {
			this.favouriteService = favouriteService;
		}
		
			@CrossOrigin
			@PostMapping("/api/v1/giphy/favorite/{userId}")
			public ResponseEntity<FavouriteGiphyObject> createFavourite(@RequestBody GiphyObject giphyObject, @PathVariable("userId")String userId){
				FavouriteGiphyObject favouriteGiphyObject = new FavouriteGiphyObject();
				if(favouriteService.createFavourite(giphyObject, userId)) {
					favouriteGiphyObject.setFavouriteFlag(true);
					favouriteGiphyObject.setGiphyObject(giphyObject);
					return new ResponseEntity<FavouriteGiphyObject>(favouriteGiphyObject, HttpStatus.CREATED);
				}else {
					return new ResponseEntity<FavouriteGiphyObject>(HttpStatus.CONFLICT);
				}
			}
			
			@CrossOrigin
			@DeleteMapping("/api/v1/giphy/favorite/{userId}/{giphyId}")
			public ResponseEntity<FavouriteGiphyObject> deleteFavourite(@PathVariable("userId")String userId, @PathVariable("giphyId")String giphyId) throws BookmarkedNotFoundException{
				boolean status = false;
				FavouriteGiphyObject favouriteGiphyObject = new FavouriteGiphyObject();
				status = favouriteService.deleteFavourite(userId, giphyId);
				
				if(status == true) {
					favouriteGiphyObject.setFavouriteFlag(false);
					favouriteGiphyObject.setGiphyObject(null);
					return new ResponseEntity<FavouriteGiphyObject>(favouriteGiphyObject,HttpStatus.OK);
				}else {
					return new ResponseEntity<FavouriteGiphyObject>(HttpStatus.NOT_FOUND);
				}
			}
			
//			@CrossOrigin
//			@PutMapping("/api/v1/giphy/bookmark/{userId}/{giphyId}")
//			public ResponseEntity<GiphyObject> updateeNote(@RequestBody GiphyObject giphyObject,@PathVariable("userId")String userId, @PathVariable("giphyId")String giphyId){
//				GiphyObject updatedGiphy = null;
//				try {
//					updatedGiphy = bookmarkedService.updateBookmark(giphyObject, giphyId, userId);
//				}catch(BookmarkedNotFoundException e) {
//					e.printStackTrace();
//				}
//				
//				if(updatedGiphy != null) {
//					return new ResponseEntity<GiphyObject>(HttpStatus.OK);
//				}else {
//					return new ResponseEntity<GiphyObject>(HttpStatus.NOT_FOUND);
//				}
//			}
			

			@CrossOrigin
			@GetMapping("/api/v1/giphy/favorite/{userId}")
			public ResponseEntity<List<FavouriteGiphyObject>> getAllFavourite(@PathVariable("userId") String id) {
				List<FavouriteGiphyObject> favourite = favouriteService.getAllFavouriteByUserId(id);
				return new ResponseEntity<List<FavouriteGiphyObject>>(favourite,HttpStatus.OK);
			}
			

}
