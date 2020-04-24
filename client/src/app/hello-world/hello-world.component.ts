import {Component, OnInit} from '@angular/core';
import {Router} from '@angular/router';
import {HttpClient} from '@angular/common/http';

@Component({
  selector: 'app-hello-world',
  templateUrl: './hello-world.component.html',
  styleUrls: ['./hello-world.component.css']
})
export class HelloWorldComponent implements OnInit {

  constructor(private http: HttpClient, private router: Router) {
  }

  ngOnInit() {
    this.getMessage();
  }

  message: string;

  getMessage() {
    this.getConfigMessage().subscribe(data => this.message = data['message'])
  }

  getConfigMessage() {
    return this.http.get('http://localhost:8080/helloWorld/1');
  }
}
