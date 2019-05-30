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
import com.stackroute.giphermanager.model.GiphyObject;
import com.stackroute.giphermanager.service.BookmarkedService;

@RunWith(SpringRunner.class)
@WebMvcTest(BookmarkedController.class)
public class BookmarkedControlerTest {
	 	@Autowired
	    private MockMvc mockMvc;
	    @MockBean
	    private BookmarkedService bookmarkedService;
	    @InjectMocks
	    private BookmarkedController bookmarkedController;


//	    @Before
//	    public void setUp() throws Exception {
//
//	        MockitoAnnotations.initMocks(this);
//	        mockMvc = MockMvcBuilders.standaloneSetup(bookmarkedController).build();
//	    }

	    @Test
	    public void createBookmarkSuccessTest() throws Exception {

	    	BookMarkedGiphyObject bookMarkedGiphyObject = new BookMarkedGiphyObject();
	    	ResponseEntity<BookMarkedGiphyObject> respEntity = new ResponseEntity<BookMarkedGiphyObject>(bookMarkedGiphyObject, HttpStatus.CREATED);
	    	when(bookmarkedService.createBookmark(new GiphyObject(), "sree25")).thenReturn(true);
	        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/giphy/bookmark/sree25")
	                .contentType(MediaType.APPLICATION_JSON))
	                .andDo(MockMvcResultHandlers.print());

	    }

	    @Test
	    public void createBookmarkFailureTest() throws Exception {

	        when(bookmarkedService.createBookmark(new GiphyObject(), "sree25")).thenThrow(ArithmeticException.class);
	        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/giphy/bookmark/sree25")
	                .contentType(MediaType.APPLICATION_JSON))
	                .andExpect(MockMvcResultMatchers.status().isBadRequest())
	                .andDo(MockMvcResultHandlers.print());

	    }


	    @Test
	    public void deleteBookmarkSuccessTest() throws Exception {

	    	BookMarkedGiphyObject bookMarkedGiphyObject = new BookMarkedGiphyObject();
//	    	ResponseEntity<BookMarkedGiphyObject> respEntity = new ResponseEntity<BookMarkedGiphyObject>(bookMarkedGiphyObject,HttpStatus.OK);
	    	when(bookmarkedService.deleteBookmark("5b04f7411764e3765c35f8f6", "sree25")).thenReturn(true);
	        mockMvc.perform(MockMvcRequestBuilders.delete("/api/v1/giphy/bookmark/sree25/5b04f7411764e3765c35f8f6")
	                .contentType(MediaType.APPLICATION_JSON))
	                .andDo(MockMvcResultHandlers.print());
	    }


	    @Test
	    public void deleteBookmarkFailureTest() throws Exception {

	        when(bookmarkedService.deleteBookmark("5b04f7411764e3765c35f8f6", "sree25")).thenThrow(ArithmeticException.class);
	        mockMvc.perform(MockMvcRequestBuilders.delete("/api/v1/giphy/bookmark/sree25/5b04f7411764e3765c35f8f6")
	                .contentType(MediaType.APPLICATION_JSON)).andExpect(MockMvcResultMatchers.status().isNotFound())
	                .andDo(MockMvcResultHandlers.print());
	    }



	    @Test
	    public void getAllBookMarkedSuccessTest() throws Exception {
	    	List<BookMarkedGiphyObject> bookmarked = new ArrayList<>();
//	    	ResponseEntity<List<BookMarkedGiphyObject>> respEntity = new ResponseEntity<List<BookMarkedGiphyObject>>(bookmarked, HttpStatus.OK);
	        when(bookmarkedService.getAllBookmarkedByUserId("sree25")).thenReturn(bookmarked);
	        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/giphy/bookmark/sree25")
	                .contentType(MediaType.APPLICATION_JSON))
	                .andExpect(MockMvcResultMatchers.status().isOk());
	    }


//	    @Test
//	    public void getAllBookMarkedFailureTest() throws Exception {
//	        when(bookmarkedService.getAllBookmarkedByUserId("sree25")).thenThrow(ArithmeticException.class);
//	        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/giphy/bookmark/sree25")
//	                .contentType(MediaType.APPLICATION_JSON))
//	                .andExpect(MockMvcResultMatchers.status().isNotFound());
//	    }
}
