import { Component, OnInit } from '@angular/core';
import { UserHomePageService } from './user-home-page.service';
import { Router } from '@angular/router';
import { AuthenticationService } from 'src/app/Services/authentication.service';
import { error } from 'util';

@Component({
  selector: 'app-user-home-page',
  templateUrl: './user-home-page.component.html',
  styleUrls: ['./user-home-page.component.css']
})
export class UserHomePageComponent implements OnInit {
  public giphyObj: any;
  public giphyList: any[] = [];
  public giphyUpdatedList: any[] = [];
  public giphyBookmarkedList: any[] = [];
  public giphyFavouriteList: any[] = [];
  
  public searchInput: String;
  public showBookmarked: boolean;
  public showFavourite: boolean;
  public username: String;
  public bookMarkedList: any[] = [];

  constructor(private userHomePageService: UserHomePageService, private router: Router, 
    private authenticationService: AuthenticationService) { }

  ngOnInit() {
    this.username = this.authenticationService.getUserId();
    this.showFavourite = false;
    this.showBookmarked = false;
    this.userHomePageService.getGiphyOnload().subscribe(
      data2 => {
        console.log(data2);
        this.giphyObj = data2;
        this.giphyList = this.giphyObj.data;
        this.giphyUpdatedList = this.giphyList.map(function(item) {
          const obj = {
            bookMarkFlag: false,
            favouriteFlag: false,
            giphyObject: item
          };
          return obj;
        });
        console.log('updated list');
        console.log(this.giphyUpdatedList);
        
       this.getTheUpdatedGifListWithDetails();   
      });
  }

  searchGiphy(){
    this.showFavourite = false;
    this.showBookmarked = false;
    this.userHomePageService.getGiphyOnSearch(this.searchInput).subscribe(
      (data2: any) => {
        console.log(data2);
        this.giphyObj = data2;
        this.giphyList = this.giphyObj.data;

        this.giphyUpdatedList = [];
        this.giphyUpdatedList = this.giphyList.map(function(item) {
        const obj = {
          bookMarkFlag: false,
          favouriteFlag: false,
          giphyObject: item
        };
        return obj;
      });
      this.getTheUpdatedGifListWithDetails();
    });
    
  }
  getTheUpdatedGifListWithDetails(){
    this.userHomePageService.getBookMarked(this.username).subscribe(
      (data: any) => {            
        this.giphyBookmarkedList = data;
        console.log(data);            
        console.log(this.giphyUpdatedList.length);
        for(let i=0; i<this.giphyUpdatedList.length; i++){
          for(let j=0; j<this.giphyBookmarkedList.length; j++){
            console.log(this.giphyUpdatedList[i]);
            console.log(this.giphyUpdatedList[i].giphyObject);
            console.log(this.giphyBookmarkedList[j].giphyObject.id);
            if(this.giphyUpdatedList[i].giphyObject.id === this.giphyBookmarkedList[j].giphyObject.id){
              this.giphyUpdatedList[i].bookMarkFlag = this.giphyBookmarkedList[j].bookMarkFlag;
            }
          }
        }
        console.log('bookmark update');
        console.log(this.giphyUpdatedList);
      },
      error=> {
      });
    
      this.userHomePageService.getFavourite(this.username).subscribe(
        (data: any) => {            
          this.giphyFavouriteList = data;
          for(let i=0; i<this.giphyUpdatedList.length; i++){
            for(let j=0; j<this.giphyFavouriteList.length; j++){
              if(this.giphyUpdatedList[i].giphyObject.id === this.giphyFavouriteList[j].giphyObject.id){
                this.giphyUpdatedList[i].favouriteFlag = this.giphyFavouriteList[j].favouriteFlag;
              }
            }
          }
          console.log('bookmark update');
          console.log(this.giphyUpdatedList);
        },
        error=> {
        });
  }
  openBookmarked(){
    this.userHomePageService.getBookMarked(this.username).subscribe(
      (data: any[]) => {
        this.showBookmarked = true;
        this.showFavourite = false;
        this.searchInput = '';
        this.giphyBookmarkedList = data;
        console.log(data);
      },
      error=> {

      }
    );   
  }
  changeBookMarked(giphyObject, index){
    if(giphyObject.bookMarkFlag) {
      this.unBookMarked(giphyObject, index);
    } else {
      this.bookMarked(giphyObject, index);
    }

  }

  bookMarked(giphyObject, index){
    this.userHomePageService.addBookMarked(this.username,giphyObject.giphyObject).subscribe(
      (data: any) => {
        console.log(data);
        this.giphyUpdatedList[index].bookMarkFlag = true;
        // this.giphyList[index] = data;
      }
    );
  }
  unBookMarked(giphyObject, index){
    const giphyObjectId = giphyObject.giphyObject.id;
    this.userHomePageService.removeBookMarked(this.username, giphyObjectId).subscribe(
      (data: any) => {
        // this.openBookmarked();
        if(this.showBookmarked === false){
          this.giphyUpdatedList[index].bookMarkFlag = false;
        } else {
          this.giphyBookmarkedList.splice(index);
        }
      }
    )
  }

  openFavourite(){
    this.userHomePageService.getFavourite(this.username).subscribe(
      (data: any)=> {
        this.showFavourite = true;
        this.showBookmarked = false;
        this.searchInput = '';
        this.giphyFavouriteList = data;
      },
      error => {

      }
    );    
  }

   changeFavourite(giphyObject, index){
     if(giphyObject.favouriteFlag){
      this.unFavoirited(giphyObject, index);
     } else {
      this.markFavourite(giphyObject, index);
     }
    
  }

  markFavourite(giphyObject, index){
    this.userHomePageService.addFavourite(this.username,giphyObject.giphyObject).subscribe(
      (data: any) => {
        console.log(data);
        this.giphyUpdatedList[index].favouriteFlag = true;
        // this.giphyList[index] = data;
      }
    );
  }
  unFavoirited(giphyObject, index){
    const giphyObjectId = giphyObject.giphyObject.id;
    this.userHomePageService.removeFavourite(this.username, giphyObjectId).subscribe(
      (data: any) => {
        // this.openFavourite();
        if(this.showFavourite === false){
          this.giphyUpdatedList[index].favouriteFlag = false;
        }else{
          this.giphyFavouriteList.splice(index);
        }
      }
    )
  }

  logout(){
    this.authenticationService.setBearerToken('');
    this.authenticationService.setUserId('');
    this.router.navigate(['']);
  }
}
