package med.voll.api.domain.consulta.validations;

import med.voll.api.domain.consulta.DadosAgendamentosConsulta;
import med.voll.api.domain.consulta.ValidacaoException;
import med.voll.api.domain.paciente.PacienteRepository;

public class ValidadorPacienteAtivo {
    private PacienteRepository pacienteRepository;
    public void validar(DadosAgendamentosConsulta dados){
        if(dados.idMedico() == null){
            return;
        }
        var pacienteAtivo = pacienteRepository.findAtivoById(dados.idMedico());
        if (!pacienteAtivo){
            throw new ValidacaoException("Consulta não pode ser agendada com este médico. Escolha outra.");
        }

    }
}
