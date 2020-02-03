const DrugRepository = require("../repositories/drug-repository");

exports.getAll = async (request, response, next) => {
  try {
    let drugs = await DrugRepository.getAll();
    response.status(200).send(drugs);
  } catch (ex) {
    throwException(response, "Falha ao buscar lista de remédios", ex);
  }
};

exports.create = async (request, response, next) => {
  try {
    await DrugRepository.create(request.body);
    response.status(200).send("Remédio cadastrado com sucesso!");
  } catch (ex) {
    throwException(response, "Falha ao cadastrar remédio");
  }
};

/**
 * Recebe o objeto response, uma messagem de erro e a exceção gerada e devolve uma messagem
 * de erro completa para o usuário.
 *
 * @response : objeto response da requisição, usado para retornar a messagem para o usuário
 * @message : messagem de erro que será enviada para o usuário
 * @exception : exceção gerada pela tentativa de uso do banco
 */

throwException = (response, message, exception) => {
  response.status(500).send({
    message: message,
    error: {
      message: exception.message,
      type: exception.name
    }
  });
};
