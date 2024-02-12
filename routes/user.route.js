import express from "express";
import { save,getUserByEmail, userList } from "../constroller/user.controller.js";
const router = express.Router();
import { body} from "express-validator";

// http://localhost:3000/user/save
router.post("/save", body("email", "Invalid Email Id").isEmail(), body("password", "Password Is required").isEmpty(), save);
router.get("/list",userList);
router.post("/byEmail",getUserByEmail);

export default router;