import { Component, OnInit } from '@angular/core';
import { UserService } from '../service/user.service';
import { User } from '../user';

@Component({
  selector: 'app-list-users',
  standalone: false,
  templateUrl: './list-users.component.html',
  styleUrl: './list-users.component.css',
})
export class ListUsersComponent implements OnInit {
  users: any;

  constructor(private svc: UserService) {}

  ngOnInit(): void {
    this.getUsers();
  }

  getUsers() {
    this.svc.getAll().subscribe((data: User[]) => {
      this.users = data;
    });
  }

  deleteUser(id: any) {
    this.svc.deleteById(id).subscribe((data:any)=>{
      this.getUsers();
    })
  }
}
