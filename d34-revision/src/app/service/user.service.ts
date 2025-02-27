import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from '../user';

@Injectable({
  providedIn: 'root',
})
export class UserService {
  constructor(private httpClient: HttpClient) {}
  private baseURL = 'http://localhost:8080/api/users';

  getAll(): Observable<User[]> {
    return this.httpClient.get<User[]>(this.baseURL);
  }

  getById(id: number): Observable<User> {
    return this.httpClient.get<User>(this.baseURL + '/' + id);
  }

  createUser(user: User): Observable<Object> {
    return this.httpClient.post<User>(this.baseURL, user);
  }

  updateUserById(id: number, user: User): Observable<Object> {
    return this.httpClient.put<User>(this.baseURL + '/' + id, user);
  }

  deleteById(id: number): Observable<Object> {
    return this.httpClient.delete<User>(this.baseURL + '/' + id);
  }
}
