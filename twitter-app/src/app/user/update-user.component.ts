
import { Component, OnInit, Optional } from '@angular/core';
import {ActivatedRoute, Router } from '@angular/router';

import { User } from '../model/user.model';
import { UserService } from './user.service';

@Component({
  templateUrl: './update-user.component.html'
})

export class UpdateUserComponent  implements OnInit {
  id:number;
   users=new User();
   user : User;

   constructor(private route: ActivatedRoute,private router: Router, private userService: UserService) {

  }
   ngOnInit() {
    
  
    this.id = this.route.snapshot.params['id'];
    console.log(this.id);
    this.userService.getUser(this.id)
      .subscribe(data => {
        console.log( data)
        this.user = data;
        console.log(`users ${this.user.username}`)
        console.log(`users ${this.user.firstName}`)
      }, error => console.log(error));
  }

   
   
  updateUser(): void {
    this.userService.updateUser(this.user)
        .subscribe( data => {
          alert("User Updated successfully.");
          this.router.navigate(['/users']);
        });
        //console.log(this.user);
        //console.log(this.users.username);
  };

}