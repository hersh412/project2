export class Users {
    id: number;
    email: string;
    password: string;
    userconf: number;
    fName: string;
    lName: string;
    address1: string;
    address2: string;
    city: string;
    state: string;
    isMale: boolean;
    token: string;

    constructor(id: number, email: string, password: string, userconf: number, fName: string,
                lName: string, address1: string, address2: string, city: string, state: string, isMale: boolean) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.userconf = userconf;
        this.fName = fName;
        this.lName = lName;
        this.address1 = address1;
        this.address2 = address2;
        this.city = city;
        this.state = state;
        this.isMale = isMale;
    }



}
