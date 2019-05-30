import { Component, OnInit, Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable()
export class HomePageService implements OnInit {

  constructor(private http: HttpClient) { }

  ngOnInit() {
  }

  getGiphyOnload(){
    return this.http.get("http://api.giphy.com/v1/gifs/search?q=funny+cat&api_key=dNpHvk3TQhtTJlGhegsx5mAmSr8JpNBt&limit=10");
  }
  getGiphyOnSearch(searchedKeyword: String){
    return this.http.get("http://api.giphy.com/v1/gifs/search?q=" + searchedKeyword + "&api_key=dNpHvk3TQhtTJlGhegsx5mAmSr8JpNBt&limit=10");
  }

}
