const config = require("../config");
const sendGrid = require("sendgrid")(config.sendGridKey);

exports.send = async (to, subject, body) => {
  sendGrid.send({
    to: to,
    from: "hello@visumed.com",
    subject: subject,
    html: body
  });
};
