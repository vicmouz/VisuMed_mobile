const mongoose = require("mongoose");
const Schema = mongoose.Schema;

const DrugSchema = new Schema({
  name: {
    type: String,
    required: true,
    trim: true
  },
  indication: {
    type: String,
    required: true
  },
  counterIndication: {
    type: String,
    required: true
  },
  dosage: {
    type: String,
    required: true
  },
  active: {
    type: Boolean,
    required: true,
    default: true
  }
});

module.exports = mongoose.model("Drug", DrugSchema);
