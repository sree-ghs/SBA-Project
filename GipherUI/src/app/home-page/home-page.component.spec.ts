import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { HomePageComponent } from './home-page.component';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { HomePageService } from 'src/app/home-page/home-page.service';
import { NO_ERRORS_SCHEMA } from '@angular/core';
import { Observable } from 'rxjs';
import 'rxjs/add/observable/of';
import { AuthenticationService } from 'src/app/Services/authentication.service';
import { AppRoutingModule } from 'src/app/app-routing.module';
import { LoginComponent } from 'src/app/login/login.component';
import { RegistrationPageComponent } from 'src/app/registration-page/registration-page.component';
import { UserHomePageComponent } from 'src/app/user-home-page/user-home-page.component';
import { ReactiveFormsModule } from '@angular/forms';

const testConfig = {
  notes: [         
    {  
      "type":"gif",
      "id":"mlvseq9yvZhba",
      "slug":"funny-cat-mlvseq9yvZhba",
      "url":"https:\/\/giphy.com\/gifs\/funny-cat-mlvseq9yvZhba",
      "bitly_gif_url":"https:\/\/gph.is\/2d8adKP",
      "bitly_url":"https:\/\/gph.is\/2d8adKP",
      "embed_url":"https:\/\/giphy.com\/embed\/mlvseq9yvZhba",
      "username":"",
      "source":"https:\/\/photobucket.com\/images\/funny%20cat%20gifs",
      "rating":"g",
      "content_url":"",
      "source_tld":"photobucket.com",
      "source_post_url":"https:\/\/photobucket.com\/images\/funny%20cat%20gifs",
      "is_sticker":0,
      "import_datetime":"2016-09-22 23:30:56",
      "trending_datetime":"2017-07-31 14:30:02",
      "images":{  
         "fixed_height_still":{  
            "url":"https:\/\/media3.giphy.com\/media\/mlvseq9yvZhba\/200_s.gif",
            "width":"200",
            "height":"200",
            "size":"14369"
         },
         "original_still":{  
            "url":"https:\/\/media3.giphy.com\/media\/mlvseq9yvZhba\/giphy_s.gif",
            "width":"200",
            "height":"200",
            "size":"14369"
         },
         "fixed_width":{  
            "url":"https:\/\/media3.giphy.com\/media\/mlvseq9yvZhba\/200w.gif",
            "width":"200",
            "height":"200",
            "size":"132910",
            "mp4":"https:\/\/media3.giphy.com\/media\/mlvseq9yvZhba\/200w.mp4",
            "mp4_size":"16843",
            "webp":"https:\/\/media3.giphy.com\/media\/mlvseq9yvZhba\/200w.webp",
            "webp_size":"165070"
         },
         "fixed_height_small_still":{  
            "url":"https:\/\/media3.giphy.com\/media\/mlvseq9yvZhba\/100_s.gif",
            "width":"100",
            "height":"100",
            "size":"4400"
         },
         "fixed_height_downsampled":{  
            "url":"https:\/\/media3.giphy.com\/media\/mlvseq9yvZhba\/200_d.gif",
            "width":"200",
            "height":"200",
            "size":"73055",
            "webp":"https:\/\/media3.giphy.com\/media\/mlvseq9yvZhba\/200_d.webp",
            "webp_size":"76088"
         },
         "preview":{  
            "width":"200",
            "height":"200",
            "mp4":"https:\/\/media3.giphy.com\/media\/mlvseq9yvZhba\/giphy-preview.mp4",
            "mp4_size":"41111"
         },
         "fixed_height_small":{  
            "url":"https:\/\/media3.giphy.com\/media\/mlvseq9yvZhba\/100.gif",
            "width":"100",
            "height":"100",
            "size":"33264",
            "mp4":"https:\/\/media3.giphy.com\/media\/mlvseq9yvZhba\/100.mp4",
            "mp4_size":"6437",
            "webp":"https:\/\/media3.giphy.com\/media\/mlvseq9yvZhba\/100.webp",
            "webp_size":"53830"
         },
         "downsized_still":{  
            "url":"https:\/\/media3.giphy.com\/media\/mlvseq9yvZhba\/giphy-downsized_s.gif",
            "width":"200",
            "height":"200",
            "size":"14369"
         },
         "downsized":{  
            "url":"https:\/\/media3.giphy.com\/media\/mlvseq9yvZhba\/giphy-downsized.gif",
            "width":"200",
            "height":"200",
            "size":"132937"
         },
         "downsized_large":{  
            "url":"https:\/\/media3.giphy.com\/media\/mlvseq9yvZhba\/giphy.gif~c200",
            "width":"200",
            "height":"200",
            "size":"132937"
         },
         "fixed_width_small_still":{  
            "url":"https:\/\/media3.giphy.com\/media\/mlvseq9yvZhba\/100w_s.gif",
            "width":"100",
            "height":"100",
            "size":"4400"
         },
         "preview_webp":{  
            "url":"https:\/\/media3.giphy.com\/media\/mlvseq9yvZhba\/giphy-preview.webp",
            "width":"148",
            "height":"148",
            "size":"49660"
         },
         "fixed_width_still":{  
            "url":"https:\/\/media3.giphy.com\/media\/mlvseq9yvZhba\/200w_s.gif",
            "width":"200",
            "height":"200",
            "size":"14369"
         },
         "fixed_width_small":{  
            "url":"https:\/\/media3.giphy.com\/media\/mlvseq9yvZhba\/100w.gif",
            "width":"100",
            "height":"100",
            "size":"33264",
            "mp4":"https:\/\/media3.giphy.com\/media\/mlvseq9yvZhba\/100w.mp4",
            "mp4_size":"6437",
            "webp":"https:\/\/media3.giphy.com\/media\/mlvseq9yvZhba\/100w.webp",
            "webp_size":"53830"
         },
         "downsized_small":{  
            "width":"200",
            "height":"200",
            "mp4":"https:\/\/media3.giphy.com\/media\/mlvseq9yvZhba\/giphy-downsized-small.mp4",
            "mp4_size":"41111"
         },
         "fixed_width_downsampled":{  
            "url":"https:\/\/media3.giphy.com\/media\/mlvseq9yvZhba\/200w_d.gif",
            "width":"200",
            "height":"200",
            "size":"73055",
            "webp":"https:\/\/media3.giphy.com\/media\/mlvseq9yvZhba\/200w_d.webp",
            "webp_size":"76088"
         },
         "downsized_medium":{  
            "url":"https:\/\/media3.giphy.com\/media\/mlvseq9yvZhba\/giphy.gif~c200",
            "width":"200",
            "height":"200",
            "size":"132937"
         },
         "original":{  
            "url":"https:\/\/media3.giphy.com\/media\/mlvseq9yvZhba\/giphy.gif",
            "width":"200",
            "height":"200",
            "size":"132937",
            "frames":"13",
            "mp4":"https:\/\/media3.giphy.com\/media\/mlvseq9yvZhba\/giphy.mp4",
            "mp4_size":"225038",
            "webp":"https:\/\/media3.giphy.com\/media\/mlvseq9yvZhba\/giphy.webp",
            "webp_size":"165070",
            "hash":"046a728414fff3b3a778be450d1e8139"
         },
         "fixed_height":{  
            "url":"https:\/\/media3.giphy.com\/media\/mlvseq9yvZhba\/200.gif",
            "width":"200",
            "height":"200",
            "size":"132910",
            "mp4":"https:\/\/media3.giphy.com\/media\/mlvseq9yvZhba\/200.mp4",
            "mp4_size":"16843",
            "webp":"https:\/\/media3.giphy.com\/media\/mlvseq9yvZhba\/200.webp",
            "webp_size":"165070"
         },
         "looping":{  
            "mp4":"https:\/\/media3.giphy.com\/media\/mlvseq9yvZhba\/giphy-loop.mp4",
            "mp4_size":"1872820"
         },
         "original_mp4":{  
            "width":"480",
            "height":"480",
            "mp4":"https:\/\/media3.giphy.com\/media\/mlvseq9yvZhba\/giphy.mp4",
            "mp4_size":"95460"
         },
         "preview_gif":{  
            "url":"https:\/\/media3.giphy.com\/media\/mlvseq9yvZhba\/giphy-preview.gif",
            "width":"146",
            "height":"146",
            "size":"49595"
         },
         "480w_still":{  
            "url":"https:\/\/media1.giphy.com\/media\/mlvseq9yvZhba\/480w_s.jpg",
            "width":"480",
            "height":"480"
         }
      },
      "title":"bored cat GIF",
      "analytics":{  
         "onload":{  
            "url":"https:\/\/giphy-analytics.giphy.com\/simple_analytics?response_id=5ce27a10796857516fd70388&event_type=GIF_SEARCH&gif_id=mlvseq9yvZhba&action_type=SEEN"
         },
         "onclick":{  
            "url":"https:\/\/giphy-analytics.giphy.com\/simple_analytics?response_id=5ce27a10796857516fd70388&event_type=GIF_SEARCH&gif_id=mlvseq9yvZhba&action_type=CLICK"
         },
         "onsent":{  
            "url":"https:\/\/giphy-analytics.giphy.com\/simple_analytics?response_id=5ce27a10796857516fd70388&event_type=GIF_SEARCH&gif_id=mlvseq9yvZhba&action_type=SENT"
         }
      }
   }
  ]
};

describe('HomePageComponent', () => {
  let component: HomePageComponent;
  let fixture: ComponentFixture<HomePageComponent>;
  let homePageService;
  let spygetGiphyOnload;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ HomePageComponent,
        LoginComponent,
        RegistrationPageComponent,
        UserHomePageComponent ],
      imports: [ HttpClientModule,
        FormsModule,
        ReactiveFormsModule,
        AppRoutingModule
         ],
      schemas: [NO_ERRORS_SCHEMA],
      providers: [
        HomePageService,
        AuthenticationService
      ]
    })   
    .compileComponents();
  }));
  beforeEach(() => {
    homePageService = TestBed.get(HomePageService);
    spygetGiphyOnload = spyOn(homePageService, 'getGiphyOnload').and.returnValue(Observable.of(testConfig.notes));
  });
  // beforeEach(() => {
  //   fixture = TestBed.createComponent(HomePageComponent);
  //   component = fixture.componentInstance;
  //   fixture.detectChanges();
  // });

  it('should create', () => {
    fixture = TestBed.createComponent(HomePageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
    // expect(component).toBeTruthy();
  });

  // it('getGiphyOnload should be called whenever HomePageComponent is rendered', () => {
  //   fixture = TestBed.createComponent(HomePageComponent);
  //   component = fixture.componentInstance;
  //   expect(homePageService.getGiphyOnload).toHaveBeenCalled();
  // });
});
