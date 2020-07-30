import {UserModel} from './user.model';
import {PostModel} from './post.model';

export class UserPostModel {
  constructor(private _user: UserModel,
              private _post: PostModel) {
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
