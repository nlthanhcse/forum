import {UserModel} from './user.model';
import {PostModel} from './post.model';

export class CommentModel {
  constructor(private _id: number,
              private _content: string,
              private _liked: number,
              private _unliked: number,
              private _user: UserModel,
              private _post: PostModel) {
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

  get post(): PostModel {
    return this._post;
  }

  set post(value: PostModel) {
    this._post = value;
  }
}
