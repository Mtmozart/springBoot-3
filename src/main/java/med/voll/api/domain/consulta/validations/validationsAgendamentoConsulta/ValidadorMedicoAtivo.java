package med.voll.api.domain.consulta.validations.validationsAgendamentoConsulta;

import med.voll.api.domain.consulta.DadosAgendamentosConsulta;
import med.voll.api.domain.consulta.ValidacaoException;
import med.voll.api.domain.medico.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorMedicoAtivo implements ValidadorAgendamentoDeConsulta  {
    @Autowired
    private MedicoRepository medicoRepository;

    public void validar(DadosAgendamentosConsulta dados) {
        if(dados.idMedico() == null){
            return;
        }
        var medicoAtivo = medicoRepository.findAtivoById(dados.idMedico());
        if (!medicoAtivo){
            throw new ValidacaoException("Consulta não pode ser agendada com este médico. Escolha outra.");
        }

    }
}
