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

@Repository
public interface BookmarkedGiphyObjectRepository extends JpaRepository<GiphyObject, String> {

//	@Query("Select giphyUser.giphyObject from GiphyUser giphyUser where giphyUser.userId= :userId")
//	public List<GiphyObject> findAllBookmarked(@Param("userId")String userId);
	
	
	@Transactional
	@Modifying
	@Query("delete from GiphyObject giphyObject where giphyObject.giphyId= :giphyId")
	public void deleteByGiphyId(@Param("giphyId")long giphyId);
}
