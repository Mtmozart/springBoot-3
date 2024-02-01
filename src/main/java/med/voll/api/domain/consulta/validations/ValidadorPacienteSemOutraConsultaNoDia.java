package med.voll.api.domain.consulta.validations;


import med.voll.api.domain.consulta.ConsultaRepository;
import med.voll.api.domain.consulta.DadosAgendamentosConsulta;
import med.voll.api.domain.consulta.ValidacaoException;

public class ValidadorPacienteSemOutraConsultaNoDia {

    private ConsultaRepository consultaRepository;
    public void validar(DadosAgendamentosConsulta dados){
    var primeiroHorario = dados.data().withHour(7);
    var ultimoHorario = dados.data().withHour(18);
    var pacientePossuiOutraConsulta  = consultaRepository
            .existsByPacienteIdAndDataBetween(dados.idPaciente(), primeiroHorario, ultimoHorario);
    if (pacientePossuiOutraConsulta){
        throw new ValidacaoException("Paciente já possui uma consulta.");
    }
    }
}
