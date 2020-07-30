import {PostModel} from './post.model';
import {CommentModel} from './comment.model';

export class UserModel {
  constructor(private _id: number,
              private _name: string,
              private _username: string,
              private _password: string,
              private _image: string,
              private _posts: PostModel[],
              private _comments: CommentModel[]) {
  }

  get id(): number {
    return this._id;
  }

  set id(value: number) {
    this._id = value;
  }

  get name(): string {
    return this._name;
  }

  set name(value: string) {
    this._name = value;
  }

  get username(): string {
    return this._username;
  }

  set username(value: string) {
    this._username = value;
  }

  get password(): string {
    return this._password;
  }

  set password(value: string) {
    this._password = value;
  }

  get image(): string {
    return this._image;
  }

  set image(value: string) {
    this._image = value;
  }

  get posts(): PostModel[] {
    return this._posts;
  }

  set posts(value: PostModel[]) {
    this._posts = value;
  }

  get comments(): CommentModel[] {
    return this._comments;
  }

  set comments(value: CommentModel[]) {
    this._comments = value;
  }
}
