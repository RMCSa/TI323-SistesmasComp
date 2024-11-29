import { Schema, model } from "mongoose";

export interface IUser {
  username: string;
  password: string;
}

const usuarioSchema = new Schema<IUser>({
  username: { type: String, required: true, unique: true },
  password: { type: String, required: true },
});

export const userTable = model<IUser>("users", usuarioSchema);
