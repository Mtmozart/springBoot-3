package med.voll.api.domain.consulta.validations.validationsAgendamentoConsulta;

import med.voll.api.domain.consulta.DadosAgendamentosConsulta;
import med.voll.api.domain.consulta.ValidacaoException;
import med.voll.api.domain.paciente.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorPacienteAtivo implements ValidadorAgendamentoDeConsulta {
   @Autowired
    private PacienteRepository pacienteRepository;
    public void validar(DadosAgendamentosConsulta dados){
        if(dados.idMedico() == null){
            return;
        }
        var pacienteAtivo = pacienteRepository.findAtivoById(dados.idPaciente());
        if (!pacienteAtivo){
            throw new ValidacaoException("Consulta não pode ser agendada com este médico. Escolha outra.");
        }

    }
}
