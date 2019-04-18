import {AbstractControl, ValidationErrors} from '@angular/forms';
export class PasswordValidators {

  static matchPassword(AC: AbstractControl, AC1: AbstractControl): ValidationErrors | null {
    if (AC.value !== AC1.value) {
      return {matchPassword: true};
    }
    return null;
  }
}
