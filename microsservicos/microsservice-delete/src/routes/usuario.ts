import { Router } from "express";
import { deleteUser } from "../controllers/deleteUser.controller";

const router = Router();

router.delete("/users/:id", deleteUser);

export default router;
