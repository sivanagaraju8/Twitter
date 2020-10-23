
import {Injectable} from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

import { Tweet } from '../model/tweet.model';


const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable()
export class TweetService {

  constructor(private http:HttpClient) {}

  private tweetUrl = 'http://localhost:8080/api/tweets';
  //private userUrl = '/api';

  public getTweets() {
    return this.http.get<Tweet[]>(this.tweetUrl);
  }

  getTweetById(id){
  return this.http.get<Tweet>(this.tweetUrl+"/"+id); //based on the given Tweet Id
 }
  public getTweet(userId) {
    return this.http.get<Tweet[]>(this.tweetUrl+"/"+userId); //based on the given user
  }
  public deleteTweet(Tweet) {
    return this.http.delete(this.tweetUrl + "/"+ Tweet.id);
  }

  public createTweet(tweet) {
    return this.http.post<Tweet>(this.tweetUrl, tweet);
  }
  public updateTweet(tweet) {
    return this.http.put<Tweet>(this.tweetUrl+"/"+ tweet.id, tweet);
  }

}