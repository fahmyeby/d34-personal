import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { User } from '../user';
import { UserService } from '../service/user.service';

@Component({
  selector: 'app-create-users',
  standalone: false,
  templateUrl: './create-users.component.html',
  styleUrl: './create-users.component.css',
})
export class CreateUsersComponent implements OnInit {
  form!: FormGroup;
  user!: User;

  constructor(private svc: UserService) {}

  ngOnInit(): void {
    this.form = new FormGroup({
      name: new FormControl(''),
      email: new FormControl(''),
      age: new FormControl(''),
    });
  }

  postUser() {
    this.user = this.form.value;
    console.log('Data passed >>> ', this.user);
    this.saveUser();
  }

  saveUser() {
    this.svc.createUser(this.user).subscribe((data) => {
      console.log('Data saved');
    });
  }
}
