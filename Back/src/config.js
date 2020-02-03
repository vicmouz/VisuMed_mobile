global.ENCRYPT_KEY = "CECBD-AEA68877D2CC4-5A45692363993B5D";
global.EMAIL_TEMPLATE = "Olá <strong>#</strong> seja bem vindo";

module.exports = {
  mongo: {
    development: {
      connectionString: "mongodb://localhost:27017/VisuMed"
    },
    production: {
      connectionString:
        "postgres://nazffrfkyiwosm:bcce0998e98c84e6bd4ac8833a3f5e30820b9c135c9081056b2db18aaac9a770@ec2-52-71-122-102.compute-1.amazonaws.com:5432/dfk01fvl5484ah"
    }
  }
};
