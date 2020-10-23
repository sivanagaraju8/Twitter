
import { Component, OnInit, Optional } from '@angular/core';
import {ActivatedRoute, Router } from '@angular/router';

import { Tweet } from '../model/tweet.model';
import { TweetService } from './tweet.service';

@Component({
  templateUrl: './update-tweet.component.html'
})

export class UpdateTweetComponent  implements OnInit {
  id:any;
   tweets=new Tweet();
   tweet : Tweet;

   constructor(private route: ActivatedRoute,private router: Router, private tweetService: TweetService) {

  }
   ngOnInit() {
    
  
    this.id = this.route.snapshot.params['id'];
    console.log(this.id);
    this.tweetService.getTweetById(this.id)
      .subscribe(data => {
        console.log( data)
        this.tweet = data;
        console.log(`Tweet ${this.tweet.tweet}`)
      }, error => console.log(error));
  }

   
   
  updateTweet(): void {
    this.tweetService.updateTweet(this.tweet)
        .subscribe( data => {
          alert("User Updated successfully.");
          this.router.navigate(['/tweets']);
        });
        //console.log(this.user);
        //console.log(this.tweet.username);
  };

}