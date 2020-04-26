import {Component, OnInit} from '@angular/core';
import {Router} from '@angular/router';
import {HttpClient} from '@angular/common/http';
import {version} from "package.json";

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
    this.getBackEndInfo();
  }

  message: string;
  backEndVersion: string;
  frontEndVersion: string = version

  getMessage() {
    this.getConfigMessage().subscribe(data => this.message = data['message'])
  }

  getBackEndInfo() {
    this.getConfigBackEndInfo().subscribe(data => this.backEndVersion = data['appversion']);
  }

  getConfigBackEndInfo() {
    return this.http.get('http://localhost:8080/');
  }

  getConfigMessage() {
    return this.http.get('http://localhost:8080/helloWorld/1');
  }
}
