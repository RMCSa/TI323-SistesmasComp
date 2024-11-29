import { Request, Response } from "express";
import { userTable } from "../database/models/user";


export const deleteUser = async (
  req: Request,
  res: Response
): Promise<void> => {
  const { id } = req.params;

  try {
    await userTable.findByIdAndDelete(id);
    res.status(204).send();
  } catch (error : any) {
    res.status(500).json({ message: error.message });
  }
};
