import { Component, OnInit } from '@angular/core';
import {FormArray, FormBuilder, FormGroup} from '@angular/forms';

@Component({
  selector: 'app-add-vehicle',
  templateUrl: './add-vehicle.component.html',
  styleUrls: ['./add-vehicle.component.css']
})
export class AddVehicleComponent implements OnInit {
  vehicleForm: FormGroup;

  constructor(private fb: FormBuilder) { }

  ngOnInit() {
    this.vehicleForm = this.fb.group({
      vehicles: this.fb.array([
        this.initVehicle(),
      ]),
    });
  }

  initVehicle() {
    return this.fb.group({
      year: [''],
      make: [''],
      model: [''],
      vin: [''],
      coverageType: [''],
    });
  }

  addVehicle() {
    const control = this.vehicleForm.get('vehicles') as FormArray;
    control.push(this.initVehicle());
  }

  getVehicles(form) {
    return form.controls.vehicles.controls;
  }

  removeVehicle(i) {
    const control = this.vehicleForm.get('vehicles') as FormArray;
    control.removeAt(i);
  }

  onSubmit(form) {
    console.log(this.vehicleForm.value);
  }

}