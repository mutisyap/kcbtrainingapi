import { Component, OnInit } from '@angular/core';
import { style, state, animate, transition, trigger, query, stagger } from '@angular/animations';

import { ApiService } from "../services/api.service";

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss'],
  animations: [
    trigger('fadeIn', [
      transition(':enter', [   // :enter is alias to 'void => *'
        style({ opacity: 0 }),
        animate(500, style({ opacity: 1 }))
      ])
    ]),
    trigger('fadeInGrow', [
      transition(':enter', [
        query(':enter', [
          style({ opacity: 0, marginTop: 30 }),
          stagger('80ms', [
            animate('400ms ease', style({ opacity: 1, marginTop: 0 }))
          ])
        ], { optional: true })
      ])
    ])
  ]
})
export class HomeComponent implements OnInit {

  cats: any[] = [];
  showForm = false;
  createCatSucess = false;
  createCatFail = false;
  cat = {
    name: '',
    age: 1,
    gender: 'Male',
    color: ''
  }

  constructor(
    private apiService: ApiService
  ) { }

  ngOnInit(): void {
    this.getCats();
  }

  getCats(): void {
    this.apiService.getAllCats().subscribe(
      (res: any) => {
        // console.log(res);
        this.cats = res;

      },
      (error: any) => {

      }
    )
  }

  toggleForm(): void {
    this.showForm = !this.showForm;
  }

  createCat(): void {
    // console.log(this.cat);

    this.apiService.createCat(this.cat).subscribe(
      (res: any) => {
        this.createCatSucess = true;
        this.createCatFail = false;


      },
      (error: any) => {
        this.createCatSucess = false;
        this.createCatFail = true;
      },
      () => {
        this.getCats();

        setTimeout(() => {
          this.createCatSucess = false;
          this.createCatFail = false;
        }, 4000);
      }
    )
  }



}
