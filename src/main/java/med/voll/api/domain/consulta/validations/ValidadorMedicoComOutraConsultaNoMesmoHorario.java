package med.voll.api.domain.consulta.validations;


import med.voll.api.domain.consulta.ConsultaRepository;
import med.voll.api.domain.consulta.DadosAgendamentosConsulta;
import med.voll.api.domain.consulta.ValidacaoException;

public class ValidadorMedicoComOutraConsultaNoMesmoHorario {
    private ConsultaRepository consultaRepository;

    public void validar(DadosAgendamentosConsulta dados){
      var medicoPossuiOutraConsultaNoMesmoHorario = consultaRepository.existsByMedicoIdAndData(dados.idMedico(), dados.data());
        if (medicoPossuiOutraConsultaNoMesmoHorario){
            throw new ValidacaoException("Médico indisponivél.");
        }
    }
}
