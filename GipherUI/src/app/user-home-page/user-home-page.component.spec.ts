import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UserHomePageComponent } from './user-home-page.component';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { AppRoutingModule } from 'src/app/app-routing.module';
import { NO_ERRORS_SCHEMA } from '@angular/core';
import { AuthenticationService } from 'src/app/Services/authentication.service';
import { UserHomePageService } from 'src/app/user-home-page/user-home-page.service';
import { RegistrationPageComponent } from 'src/app/registration-page/registration-page.component';
import { ReactiveFormsModule } from '@angular/forms';
import { HomePageComponent } from 'src/app/home-page/home-page.component';
import { LoginComponent } from 'src/app/login/login.component';

describe('UserHomePageComponent', () => {
  let component: UserHomePageComponent;
  let fixture: ComponentFixture<UserHomePageComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UserHomePageComponent,
        RegistrationPageComponent,
        HomePageComponent,
        LoginComponent ],
      imports: [ HttpClientModule,
        FormsModule,
        ReactiveFormsModule,
        AppRoutingModule
         ],
      schemas: [NO_ERRORS_SCHEMA],
      providers: [
        AuthenticationService,
        UserHomePageService
      ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UserHomePageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
