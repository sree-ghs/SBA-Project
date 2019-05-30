package com.stackroute.giphermanager.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.stackroute.giphermanager.exception.BookmarkNotCreatedException;
import com.stackroute.giphermanager.exception.BookmarkNotDeletedException;
import com.stackroute.giphermanager.exception.BookmarkedNotFoundException;
import com.stackroute.giphermanager.model.BookMarkedGiphyObject;
import com.stackroute.giphermanager.model.FavouriteGiphyObject;
import com.stackroute.giphermanager.model.GiphyObject;
import com.stackroute.giphermanager.service.FavouriteService;

@RunWith(SpringRunner.class)
@WebMvcTest(FavoriteController.class)
public class FavoriteControlerTest {
	 	@Autowired
	    private MockMvc mockMvc;
	    @MockBean
	    private FavouriteService favouriteService;
	    @InjectMocks
	    private FavoriteController favoriteController;


//	    @Before
//	    public void setUp() throws Exception {
//
//	        MockitoAnnotations.initMocks(this);
//	        mockMvc = MockMvcBuilders.standaloneSetup(bookmarkedController).build();
//	    }

	    @Test
	    public void createFavouriteSuccessTest() throws Exception {

	    	BookMarkedGiphyObject bookMarkedGiphyObject = new BookMarkedGiphyObject();
	    	ResponseEntity<BookMarkedGiphyObject> respEntity = new ResponseEntity<BookMarkedGiphyObject>(bookMarkedGiphyObject, HttpStatus.CREATED);
	    	when(favouriteService.createFavourite(new GiphyObject(), "sree35")).thenReturn(true);
	        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/giphy/favorite/sree35")
	                .contentType(MediaType.APPLICATION_JSON))
	                .andDo(MockMvcResultHandlers.print());

	    }

	    @Test
	    public void createFavouriteFailureTest() throws Exception {

	        when(favouriteService.createFavourite(new GiphyObject(), "sree35")).thenThrow(ArithmeticException.class);
	        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/giphy/favorite/sree35")
	                .contentType(MediaType.APPLICATION_JSON))
	                .andExpect(MockMvcResultMatchers.status().isBadRequest())
	                .andDo(MockMvcResultHandlers.print());

	    }


	    @Test
	    public void deleteFavouriteSuccessTest() throws Exception {

	    	BookMarkedGiphyObject bookMarkedGiphyObject = new BookMarkedGiphyObject();
//	    	ResponseEntity<BookMarkedGiphyObject> respEntity = new ResponseEntity<BookMarkedGiphyObject>(bookMarkedGiphyObject,HttpStatus.OK);
	    	when(favouriteService.deleteFavourite("5b04f7411764e3765c35f8f6", "sree35")).thenReturn(true);
	        mockMvc.perform(MockMvcRequestBuilders.delete("/api/v1/giphy/favorite/sree35/5b04f7411764e3765c35f8f6")
	                .contentType(MediaType.APPLICATION_JSON))
	                .andDo(MockMvcResultHandlers.print());
	    }


	    @Test
	    public void deleteFavouriteFailureTest() throws Exception {

	        when(favouriteService.deleteFavourite("5b04f7411764e3765c35f8f6", "sree35")).thenThrow(ArithmeticException.class);
	        mockMvc.perform(MockMvcRequestBuilders.delete("/api/v1/giphy/favorite/sree35/5b04f7411764e3765c35f8f6")
	                .contentType(MediaType.APPLICATION_JSON)).andExpect(MockMvcResultMatchers.status().isNotFound())
	                .andDo(MockMvcResultHandlers.print());
	    }



	    @Test
	    public void getAllFavouriteSuccessTest() throws Exception {
	    	List<FavouriteGiphyObject> favorite = new ArrayList<>();
//	    	ResponseEntity<List<BookMarkedGiphyObject>> respEntity = new ResponseEntity<List<BookMarkedGiphyObject>>(bookmarked, HttpStatus.OK);
	        when(favouriteService.getAllFavouriteByUserId("sree35")).thenReturn(favorite);
	        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/giphy/favorite/sree35")
	                .contentType(MediaType.APPLICATION_JSON))
	                .andExpect(MockMvcResultMatchers.status().isOk());
	    }


//	    @Test
//	    public void getAllBookMarkedFailureTest() throws Exception {
//	        when(favouriteService.getAllBookmarkedByUserId("sree35")).thenThrow(ArithmeticException.class);
//	        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/giphy/favorite/sree35")
//	                .contentType(MediaType.APPLICATION_JSON))
//	                .andExpect(MockMvcResultMatchers.status().isNotFound());
//	    }
}
