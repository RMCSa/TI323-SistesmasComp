import { Request, Response } from "express";
import { IUser, userTable } from "../database/models/Usuario";


export const getUser = async (req: Request, res: Response): Promise<void> => {
  try {
    const users : IUser[] = await userTable.find();
    res.status(200).json(users);
  } catch (error : any) {
    res.status(500).json({ message: error.message });
  }
};
