const mongoose = require("mongoose");
const Drug = mongoose.model("Drug");

exports.getAll = async () => {
  return await Drug.find({
    active: true
  });
};

exports.create = async request_data => {
  let drug = new Drug(request_data);
  await drug.save();
};
