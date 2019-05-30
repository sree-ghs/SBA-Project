import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RegistrationPageComponent } from './registration-page.component';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from 'src/app/app-routing.module';
import { NO_ERRORS_SCHEMA } from '@angular/core';
import { AuthenticationService } from 'src/app/Services/authentication.service';
import { UserHomePageComponent } from 'src/app/user-home-page/user-home-page.component';
import { ReactiveFormsModule } from '@angular/forms';
import { HomePageComponent } from 'src/app/home-page/home-page.component';
import { LoginComponent } from 'src/app/login/login.component';
import { RegistrationPageService } from 'src/app/registration-page/registration-page.service';

describe('RegistrationPageComponent', () => {
  let component: RegistrationPageComponent;
  let fixture: ComponentFixture<RegistrationPageComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RegistrationPageComponent,
        UserHomePageComponent,
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
        RegistrationPageService
      ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RegistrationPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
