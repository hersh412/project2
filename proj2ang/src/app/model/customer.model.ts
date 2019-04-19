import { Users } from '../model/user.model';

export class Customer {
    id: number;
    dob: any;
    occupation: string;
    state: number;
    dlIssueDate: any;
    dlExpiryDate: any;
    user: Users;

    constructor(id: number, dob: any, occupation: string, state: number, dlIssueDate: any, dlExpiryDate: any, user: Users) {
        this.id = id;
        this.dob = dob;
        this.occupation = occupation;
        this.state = state;
        this.dlIssueDate = dlIssueDate;
        this.dlExpiryDate = dlExpiryDate;
        this.user = user;
    }



}