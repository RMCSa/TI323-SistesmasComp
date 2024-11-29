import { Router } from "express";
import { createUser } from "../controllers/createUser.controller";

const router = Router();

router.post("/users", createUser);

export default router;
