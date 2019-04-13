import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { HttpClient } from '@angular/common/http';
import { ZipcodeValidators } from './zipcode.validators';

@Component({
  selector: 'quote-form',
  templateUrl: './quote-form.component.html',
  styleUrls: ['./quote-form.component.css']
})
export class QuoteFormComponent {

  constructor(private fb: FormBuilder, private http: HttpClient) { }
  
  quoteForm = this.fb.group({
        zipcode: ['', [Validators.required, Validators.minLength(5), Validators.maxLength(5), ZipcodeValidators.outOfServiceArea]],
        class: ['', Validators.required],
        year: ['', Validators.required],
        gender: ['', Validators.required],
        age: ['', Validators.required]
      });

      onSubmit() {
        const quote = this.quoteForm.value;
        const URL = 'http://localhost:8080/project2/quote/generate';
        this.http.post(URL,quote).subscribe(response => console.log(response));
       // console.warn(this.quoteForm.value);
      }
}
