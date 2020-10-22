
import { Component, OnInit, Optional } from '@angular/core';
import {ActivatedRoute, Router } from '@angular/router';

import { User } from '../model/user.model';
import { UserService } from './user.service';

@Component({
  templateUrl: './update-user.component.html'
})

export class UpdateUserComponent  implements OnInit {
  id:number;
   users: User[]
   user:User;

   constructor(private route: ActivatedRoute,private router: Router, private userService: UserService) {

  }
   ngOnInit() {
    this.user = new User();
  
    this.id = this.route.snapshot.params['id'];
    
    this.userService.getUser(this.id)
      .subscribe(data => {
        console.log(`data${data}`)
        this.users = data;
      }, error => console.log(error));
  }

   
   
  updateUser(): void {
    this.userService.updateUser(this.user)
        .subscribe( data => {
          alert("User Updated successfully.");
        });
        console.log(this.user);
        console.log(this.user.username);
  };

}