package med.voll.api.domain.consulta.validations;

import med.voll.api.domain.consulta.DadosAgendamentosConsulta;
import med.voll.api.domain.consulta.ValidacaoException;
import org.springframework.stereotype.Component;

import java.time.DayOfWeek;
@Component
public class ValidadorHorarioFuncionamento implements ValidadorAgendamentoDeConsulta  {

    public void validar(DadosAgendamentosConsulta dados){
        var dataConsulta = dados.data();
        var domingo = dataConsulta.getDayOfWeek().equals(DayOfWeek.SUNDAY);
        var antesDaAberturaDaClinica = dataConsulta.getHour() < 7;
        var depoisDoEncerramentoDaClinica = dataConsulta.getHour() > 18;

        if(domingo || antesDaAberturaDaClinica || depoisDoEncerramentoDaClinica){
            throw new ValidacaoException("Consulta fora do expediente.  ");
        }
    }
}
