export class AuthResponseModel<T> {
  constructor(private _error_message: string,
              private _error_code: number,
              private _response_object: T) {
  }

  get error_message(): string {
    return this._error_message;
  }

  set error_message(value: string) {
    this._error_message = value;
  }

  get error_code(): number {
    return this._error_code;
  }

  set error_code(value: number) {
    this._error_code = value;
  }

  get response_object(): T {
    return this._response_object;
  }

  set response_object(value: T) {
    this._response_object = value;
  }
}
