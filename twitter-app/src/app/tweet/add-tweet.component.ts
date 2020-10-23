
import { Component } from '@angular/core';
import { Router } from '@angular/router';

import { Tweet} from '../model/tweet.model';
import { TweetService } from './tweet.service';

@Component({
  templateUrl: './add-tweet.component.html'
})
export class AddTweetComponent {

   tweet: Tweet = new Tweet();

  constructor(private router: Router, private userService: TweetService) {

  }

  createTweet(): void {
    this.userService.createTweet(this.tweet)
        .subscribe( data => {
          alert("Tweeted successfully.");
          this.router.navigate(['/tweets']);
        });
        console.log(this.tweet.tweet);
        console.log(this.tweet.userId);
  };

}