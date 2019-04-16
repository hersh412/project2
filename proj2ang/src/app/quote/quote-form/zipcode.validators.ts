import { AbstractControl, ValidationErrors } from '@angular/forms';

export class ZipcodeValidators {
    static outOfServiceArea(control: AbstractControl): ValidationErrors | null {
        if ((control.value as number < 32004) || (control.value as number) > 34997) {
            return { outOfServiceArea: true};
        }
        return null;
    }
}