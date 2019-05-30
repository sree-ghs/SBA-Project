import { Component, OnInit } from '@angular/core';

import { Router } from '@angular/router';
import { Route } from '@angular/router';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable()
export class UserHomePageService implements OnInit {

  private url:String = 'http://localhost:8082/api/v1/';
  constructor(private http: HttpClient) { }

  ngOnInit() {
  }

  getGiphyOnload(){
    return this.http.get("http://api.giphy.com/v1/gifs/search?q=funny+cat&api_key=dNpHvk3TQhtTJlGhegsx5mAmSr8JpNBt&limit=10");
  }
  getGiphyOnSearch(searchedKeyword: String){
    return this.http.get("http://api.giphy.com/v1/gifs/search?q=" + searchedKeyword + "&api_key=dNpHvk3TQhtTJlGhegsx5mAmSr8JpNBt&limit=10");
  }

  addBookMarked(userId: String, giphyObj){
    return this.http.post(this.url + 'giphy/bookmark/' + userId, giphyObj);
  }

  getBookMarked(userId: String){
    return this.http.get(this.url + 'giphy/bookmark/' + userId);
  }

  removeBookMarked(userId: String, giphyId: String){
    return this.http.delete(this.url + 'giphy/bookmark/' + userId + '/' + giphyId);
  }


  addFavourite(userId: String, giphyObj){
    return this.http.post(this.url + 'giphy/favorite/' + userId, giphyObj);
  }

  getFavourite(userId: String){
    return this.http.get(this.url + 'giphy/favorite/' + userId);
  }

  removeFavourite(userId: String, giphyId: String){
    return this.http.delete(this.url + 'giphy/favorite/' + userId + '/' + giphyId);
  }
}
