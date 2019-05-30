import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { LoginComponent } from './login.component';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { AppRoutingModule } from 'src/app/app-routing.module';
import { NO_ERRORS_SCHEMA } from '@angular/core';
import { AuthenticationService } from 'src/app/Services/authentication.service';
import { RegistrationPageComponent } from 'src/app/registration-page/registration-page.component';
import { UserHomePageComponent } from 'src/app/user-home-page/user-home-page.component';
import { ReactiveFormsModule } from '@angular/forms';
import { HomePageComponent } from 'src/app/home-page/home-page.component';

describe('LoginComponent', () => {
  let component: LoginComponent;
  let fixture: ComponentFixture<LoginComponent>;
  let authenticationService;
  let spygetGiphyOnload;
  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ LoginComponent,
        RegistrationPageComponent,
        HomePageComponent,
        UserHomePageComponent ],
      imports: [ HttpClientModule,
        FormsModule,
        ReactiveFormsModule,
        AppRoutingModule
         ],
      schemas: [NO_ERRORS_SCHEMA],
      providers: [
        AuthenticationService
      ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(LoginComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
