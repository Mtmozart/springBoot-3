package med.voll.api.domain.consulta.validations.validationsAgendamentoConsulta;


import med.voll.api.domain.consulta.ConsultaRepository;
import med.voll.api.domain.consulta.DadosAgendamentosConsulta;
import med.voll.api.domain.consulta.ValidacaoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorMedicoComOutraConsultaNoMesmoHorario  implements ValidadorAgendamentoDeConsulta {
   @Autowired
    private ConsultaRepository consultaRepository;

    public void validar(DadosAgendamentosConsulta dados){
      var medicoPossuiOutraConsultaNoMesmoHorario = consultaRepository.existsByMedicoIdAndDataAndMotivoCancelamentoIsNull(dados.idMedico(), dados.data());
        if (medicoPossuiOutraConsultaNoMesmoHorario){
            throw new ValidacaoException("Médico indisponivél.");
        }
    }
}
