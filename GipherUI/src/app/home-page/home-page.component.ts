import { Component, OnInit } from '@angular/core';

import { HomePageService } from './home-page.service';
import { Router } from '@angular/router';
import { Route } from '@angular/router';

@Component({
  selector: 'app-home-page',
  templateUrl: './home-page.component.html',
  styleUrls: ['./home-page.component.css']
})
export class HomePageComponent implements OnInit {

  public giphyObj: any;
  public giphyList: any[] = [];
  public giphyList2: any[] = [];
  public giphyList3: any[] = [];
  public searchInput: String;

  
  constructor(private homePageService: HomePageService, private router: Router) { }

  ngOnInit() {
    this.homePageService.getGiphyOnload().subscribe(
      data2 => {
        console.log(data2);
        this.giphyObj = data2;
        this.giphyList = this.giphyObj.data
        // this.giphyList1 = this.giphyObj.data.slice(0,5);
        // this.giphyList2 = this.giphyObj.data.slice(5,10);
        // this.giphyList3 = this.giphyObj.data.slice(10);
        // console.log(this.giphyList1);
        // console.log(this.giphyList2);
      });
  }

  searchGiphy(){
    this.homePageService.getGiphyOnSearch(this.searchInput).subscribe(
      data2 => {
        console.log(data2);
        this.giphyObj = data2;
        this.giphyList = this.giphyObj.data
        // this.giphyList1 = this.giphyObj.data.slice(0,5);
        // this.giphyList2 = this.giphyObj.data.slice(5,10);
        // this.giphyList3 = this.giphyObj.data.slice(10);
        // console.log(this.giphyList1);
        // console.log(this.giphyList2);
      });
  }

  openLoginInPage(){
    this.router.navigate(['login']);
  }

}
