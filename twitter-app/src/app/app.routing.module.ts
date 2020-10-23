import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { UserComponent } from './user/user.component';
import {AddUserComponent} from './user/add-user.component';
import {UpdateUserComponent} from './user/update-user.component';

import { TweetComponent } from './tweet/tweet.component';
import { UpdateTweetComponent } from './tweet/update-tweet.component';
import { AddTweetComponent } from './tweet/add-tweet.component';

const routes: Routes = [
  { path: 'users', component: UserComponent },
  { path: 'addUsers', component: AddUserComponent },
  { path: 'updateUser/:id', component: UpdateUserComponent },
  { path: 'tweets', component: TweetComponent },
 { path: 'addTweet', component: AddTweetComponent },
  { path: 'updateTweet/:id', component: UpdateTweetComponent }
];

@NgModule({
  imports: [
    RouterModule.forRoot(routes)
  ],
  exports: [
    RouterModule
  ],
  declarations: []
})
export class AppRoutingModule { }