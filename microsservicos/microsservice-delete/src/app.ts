import express from "express";
import mongoose from "mongoose";
import usuarioRoutes from "./routes/usuario";
import dotenv from "dotenv";

dotenv.config();

const app = express();
const port = process.env.PORT || 3000;

mongoose
  .connect(process.env.MONGO_URI!, {dbName: process.env.DB_NAME})
  .then(() => console.log("MongoDB connected"))
  .catch((err) => console.log(err));

app.use(express.json());
app.use("/api", usuarioRoutes);

app.listen(port, () => {
  console.log(`Server running on port ${port}`);
});


