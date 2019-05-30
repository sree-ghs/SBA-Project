package com.stackroute.giphermanager.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

// import com.stackroute.accountmanager.model.User;
import com.stackroute.giphermanager.model.GiphyObject;
import com.stackroute.giphermanager.model.GiphyUser;
import com.stackroute.giphermanager.model.GiphyUserFavourite;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class FavouriteRepositoryTest {
	
	@Autowired
	FavouriteRepository favouriteRepository;
	
	GiphyObject giphyObject;
	GiphyUserFavourite giphyUser;
	List<GiphyObject> giphyObjectList;
	
	
	@Before
    public void setUp() throws Exception {
		giphyObject = new GiphyObject();
		giphyObjectList = new ArrayList<GiphyObject>();
		giphyUser = new GiphyUserFavourite();
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
		giphyUser.setUserId("sree20");
		giphyUser.setGiphyObject(giphyObjectList);
    }

    @After
    public void tearDown() throws Exception {
    	favouriteRepository.deleteAll();
    }
    
    @Test
    public void createBookmarkSuccess() {
    	favouriteRepository.save(giphyUser);
        List<GiphyObject> object = favouriteRepository.findAllFavourite("sree20");
        Assert.assertEquals(giphyObjectList.get(0).getBitly_url(), object.get(0).getBitly_url());
    }
    
    @Test(expected = IndexOutOfBoundsException.class)
    public void deleteBookmarktest() {
    	giphyUser.setUserId("sree07");
    	favouriteRepository.save(giphyUser);
        List<GiphyObject> object = favouriteRepository.findAllFavourite("sree20");
        Assert.assertEquals(giphyObjectList.get(0).getBitly_url(), object.get(0).getBitly_url());
        favouriteRepository.deleteFavouriteGiphy("sree07");
        List<GiphyObject> object2 = favouriteRepository.findAllFavourite("sree20");

    }
    
    
    @Test
    public void getAllCategoryByUserId() {

    	giphyUser.setUserId("sree93");
    	favouriteRepository.save(giphyUser);

		List<GiphyObject> bookmarked = favouriteRepository.findAllFavourite("sree93");
        Assert.assertEquals(1, bookmarked.size());


    }
}
