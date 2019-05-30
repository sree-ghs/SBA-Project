package com.stackroute.giphermanager.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.stackroute.giphermanager.model.GiphyObject;
import com.stackroute.giphermanager.model.GiphyUser;
import com.stackroute.giphermanager.model.GiphyUserFavourite;

@Repository
public interface FavouriteRepository extends JpaRepository<GiphyUserFavourite, String> {

	@Query("Select giphyUser.giphyObject from GiphyUserFavourite giphyUser where giphyUser.userId= :userId")
	public List<GiphyObject> findAllFavourite(@Param("userId")String userId);
	
	@Transactional
	@Modifying
	@Query("delete from GiphyUserFavourite giphyUser where giphyUser.userId= :userId")
	public void deleteFavouriteGiphy(@Param("userId")String userId);
//	, @Param("giphyId")String giphyId
//	@Query("delete from GiphyUser giphyUser where giphyUser.userId= :userId and giphyUser.giphyId =:giphyId")
}
