const express = require("express");
const bodyParser = require("body-parser");
const mongoose = require("mongoose");
const config = require("./config");

const app = express();

mongoose.set("debug", true);
mongoose.connect(config.localDatabase, { useNewUrlParser: true });
mongoose.connection.on("connected", () => {
  console.log(`Mongoose connected to ${config.localDatabase}`);
});
mongoose.connection.on("error", err => {
  console.log(`Mongoose connection error: ${err}`);
});
mongoose.connection.on("disconnected", () => {
  console.log("Mongoose disconnected");
});

const User = require("./models/user.js");
const Drug = require("./models/drug.js");

const userRoutes = require("./routes/user-routes");
const drugRoutes = require("./routes/drug-routes");

app.use(function(req, res, next) {
  res.header("Access-Control-Allow-Origin", "*");
  res.header(
    "Access-Control-Allow-Headers",
    "Origin, X-Requested-With, Content-Type, Accept"
  );
  next();
});

app.use(bodyParser.json());
app.use(bodyParser.urlencoded({ extended: false }));

app.use("/users", userRoutes);
app.use("/drugs", drugRoutes);

// exportando a aplicação
// toda vez que a classe for instanciada oque vai é o app

module.exports = app;
