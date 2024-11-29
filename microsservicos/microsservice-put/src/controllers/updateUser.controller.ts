import { Request, Response } from "express";
import { IUser, userTable } from "../database/models/user";

export const updateUser = async (
  req: Request,
  res: Response
): Promise<void> => {
  const { id } = req.params;
  const { username, password } : IUser = req.body;

  if (!username || !password) {
    res.status(400).json({ message: "Please provide username and password" });
    return;
  }

  try {
    const updatedUser = await userTable.findByIdAndUpdate(
      id,
      { username, password },
      { new: true }
    );
    res.status(200).json(updatedUser);
  } catch (error: any) {
    res.status(500).json({ message: error.message });
  }
};
