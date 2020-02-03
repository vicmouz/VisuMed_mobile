const express = require("express");
const router = express.Router();
const drugController = require("../controllers/drug-controller");

router.get("/", drugController.getAll);
router.post("/new", drugController.create);

module.exports = router;
