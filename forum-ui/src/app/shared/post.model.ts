import {UserModel} from './user.model';
import {CategoryModel} from './category.model';
import {CommentModel} from './comment.model';

export class PostModel {
  constructor(private _id: number,
              private _content: string,
              private _post_date: string,
              private _liked: number,
              private _unliked: number,
              private _user: UserModel,
              private _category: CategoryModel,
              private _comments: CommentModel[]) {
  }

  get id(): number {
    return this._id;
  }

  set id(value: number) {
    this._id = value;
  }

  get content(): string {
    return this._content;
  }

  set content(value: string) {
    this._content = value;
  }

  get post_date(): string {
    return this._post_date;
  }

  set post_date(value: string) {
    this._post_date = value;
  }

  get liked(): number {
    return this._liked;
  }

  set liked(value: number) {
    this._liked = value;
  }

  get unliked(): number {
    return this._unliked;
  }

  set unliked(value: number) {
    this._unliked = value;
  }

  get user(): UserModel {
    return this._user;
  }

  set user(value: UserModel) {
    this._user = value;
  }

  get category(): CategoryModel {
    return this._category;
  }

  set category(value: CategoryModel) {
    this._category = value;
  }

  get comments(): CommentModel[] {
    return this._comments;
  }

  set comments(value: CommentModel[]) {
    this._comments = value;
  }
}
