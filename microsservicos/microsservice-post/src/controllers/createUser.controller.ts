import { Request, Response } from "express";
import { IUser, userTable } from "../database/models/user";

export const createUser = async (
  req: Request,
  res: Response
): Promise<void> => {
  const { username, password } = req.body;

  if (!username || !password) {
    res.status(400).json({ message: "Missing required fields" });
    return;
  }

  const newUser = new userTable({ username, password } as IUser);

  try {
    await newUser.save();
    res.status(201).json(newUser);
  } catch (error: any) {
    res.status(500).json({ message: error.message });
  }
};
