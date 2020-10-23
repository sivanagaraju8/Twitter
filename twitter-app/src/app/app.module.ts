import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';

import { AppComponent } from './app.component';
import { UserComponent } from './user/user.component';
import { AppRoutingModule } from './app.routing.module';
import {UserService} from './user/user.service';
import {HttpClientModule} from "@angular/common/http";
import {AddUserComponent} from './user/add-user.component';
import { UpdateUserComponent } from './user/update-user.component';

import {TweetService} from './tweet/tweet.service';
import { TweetComponent } from './tweet/tweet.component';
import { UpdateTweetComponent } from './tweet/update-tweet.component';
import { AddTweetComponent } from './tweet/add-tweet.component';

@NgModule({
  declarations: [
    AppComponent,
    UserComponent,
    AddUserComponent,
    UpdateUserComponent,
    TweetComponent,
    AddTweetComponent,
    UpdateTweetComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [UserService, TweetService],
  bootstrap: [AppComponent]
})
export class AppModule { }