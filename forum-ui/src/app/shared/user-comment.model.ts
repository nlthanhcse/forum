import {UserModel} from './user.model';
import {CommentModel} from './comment.model';

export class UserCommentModel {
  constructor(private _user: UserModel,
              private _comment: CommentModel) {
  }

  get user(): UserModel {
    return this._user;
  }

  set user(value: UserModel) {
    this._user = value;
  }

  get comment(): CommentModel {
    return this._comment;
  }

  set comment(value: CommentModel) {
    this._comment = value;
  }
}
