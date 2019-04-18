export class User {
  private _id: number;
  private _email: string;
  private _password: string;
  private _userconf: number;
  private _fName: string;
  private _lName: string;
  private _address1: string;
  private _address2: string;
  private _city: string;
  private _state: string;
  private _zipcode: string;
  private _isMale: boolean;

  get zipcode(): string {
    return this._zipcode;
  }

  set zipcode(value: string) {
    this._zipcode = value;
  }

  get id(): number {
    return this._id;
  }

  set id(value: number) {
    this._id = value;
  }

  get email(): string {
    return this._email;
  }

  set email(value: string) {
    this._email = value;
  }

  get password(): string {
    return this._password;
  }

  set password(value: string) {
    this._password = value;
  }

  get userconf(): number {
    return this._userconf;
  }

  set userconf(value: number) {
    this._userconf = value;
  }

  get fName(): string {
    return this._fName;
  }

  set fName(value: string) {
    this._fName = value;
  }

  get lName(): string {
    return this._lName;
  }

  set lName(value: string) {
    this._lName = value;
  }

  get address1(): string {
    return this._address1;
  }

  set address1(value: string) {
    this._address1 = value;
  }

  get address2(): string {
    return this._address2;
  }

  set address2(value: string) {
    this._address2 = value;
  }

  get city(): string {
    return this._city;
  }

  set city(value: string) {
    this._city = value;
  }

  get state(): string {
    return this._state;
  }

  set state(value: string) {
    this._state = value;
  }

  get isMale(): boolean {
    return this._isMale;
  }

  set isMale(value: boolean) {
    this._isMale = value;
  }

  constructor() {}


}
