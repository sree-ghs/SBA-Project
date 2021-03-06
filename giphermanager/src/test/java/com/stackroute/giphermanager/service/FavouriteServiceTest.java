package com.stackroute.giphermanager.service;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.stackroute.giphermanager.model.BookMarkedGiphyObject;
import com.stackroute.giphermanager.model.FavouriteGiphyObject;
import com.stackroute.giphermanager.model.GiphyObject;
import com.stackroute.giphermanager.model.GiphyUser;
import com.stackroute.giphermanager.model.GiphyUserFavourite;
import com.stackroute.giphermanager.repository.FavouriteRepository;

@RunWith(SpringRunner.class)
//@WebMvcTest(favouriteServiceImpl.class)
public class FavouriteServiceTest {

	
    @MockBean
    private FavouriteRepository favouriteRepository;
    @InjectMocks
    private FavouriteServiceImpl favouriteServiceImpl;
    GiphyObject giphyObject = null;
    GiphyUserFavourite giphyUser = null;
	List<GiphyObject> giphyObjectList = null;
    Optional<GiphyObject> options;
    
    @Before
    public void setUp() throws Exception {

        MockitoAnnotations.initMocks(this);
        giphyUser = new GiphyUserFavourite();
        giphyObject = new GiphyObject();
        giphyObjectList = new ArrayList<GiphyObject>();
        giphyObject.setBitly_url("DFgfdG"); 
		giphyObject.setContent_url("dfgdfg");
		giphyObject.setCreate_datetime("dfdF");
		giphyObject.setEmbed_url("xdgdfg");
		giphyObject.setId("dgdfg");
		giphyObject.setImages(null);
		giphyObject.setImport_datetime("dfdG");
		giphyObject.setRating("4");
		giphyObject.setSlug("dfgd");
		giphyObject.setSource("dfsdf");
		giphyObject.setSource_post_url("dfgdfg");
		giphyObject.setSource_tld("xdfxd");
		giphyObject.setTitle("dfs");
		giphyObject.setTrending_datetime("se3455");
		giphyObject.setType("gif");
		giphyObject.setUpdate_datetime("35435");
		giphyObject.setUrl("segdg");
		giphyObject.setUser(null);
		giphyObject.setUsername("dfg");
        giphyObjectList.add(giphyObject);
        giphyUser.setUserId("sree35");
        giphyUser.setGiphyObject(giphyObjectList);
        options = Optional.of(giphyObject);
    }
    
    
    @Test
    public void createBookmarkTestSuccess() throws Exception {
    	
        when(favouriteRepository.save(giphyUser)).thenReturn(giphyUser);
        boolean status = favouriteServiceImpl.createFavourite(giphyObject, "sree35");
        Assert.assertEquals(false, status);

    }
    
    @Test
    public void createBookmarkTestFailure() throws Exception {

        when(favouriteRepository.save(giphyUser)).thenReturn(giphyUser);
        boolean status = favouriteServiceImpl.createFavourite(giphyObject, "sree35");
        Assert.assertEquals(false, status);

    }

    @Test
    public void deleteBookmark() throws Exception {
        when(favouriteRepository.findAllFavourite("sree35")).thenReturn(giphyObjectList);
        boolean flag = favouriteServiceImpl.deleteFavourite("sree35", "jmsgdh");
        Assert.assertEquals(false, flag);
    }



    @Test
    public void getAllBookmarkedByUserIdTestSuccess(){
        when(favouriteRepository.findAllFavourite("sree35")).thenReturn(giphyObjectList);
        List<FavouriteGiphyObject> list = favouriteServiceImpl.getAllFavouriteByUserId("sree35");
        
        List<FavouriteGiphyObject> list2 = new ArrayList<>();
        for(int i = 0; i < giphyObjectList.size() ; i++) {
        	FavouriteGiphyObject favouriteGiphyObject = new FavouriteGiphyObject();
        	favouriteGiphyObject.setFavouriteFlag(true);
        	favouriteGiphyObject.setGiphyObject(giphyObjectList.get(i));
    		list2.add(favouriteGiphyObject);
    	}
        Assert.assertEquals(list2.get(0).getGiphyObject().getBitly_url(), list.get(0).getGiphyObject().getBitly_url());

    }


}
