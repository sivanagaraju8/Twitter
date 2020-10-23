
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import { Tweet } from '../model/tweet.model';
import { TweetService } from './tweet.service';

@Component({
  selector: 'app-tweet',
  templateUrl: './tweet.component.html',
  styles: []
})
export class TweetComponent implements OnInit {

  tweets: Tweet[];

  constructor(private router: Router, private tweetService: TweetService) {

  }

  ngOnInit() {
    this.tweetService.getTweets()
      .subscribe( data => {
        this.tweets = data;
      });
  };

  deleteTweet(tweet: Tweet): void {
    this.tweetService.deleteTweet(tweet)
      .subscribe( data => {
        this.tweets = this.tweets.filter(u => u !== tweet);
      })
  };

}