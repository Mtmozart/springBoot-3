package med.voll.api.domain.consulta.validations;

import med.voll.api.domain.consulta.DadosAgendamentosConsulta;
import med.voll.api.domain.consulta.ValidacaoException;
import org.springframework.stereotype.Component;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDateTime;
@Component
public class ValidadorHorarioAntecedencia implements ValidadorAgendamentoDeConsulta  {
    public void validar(DadosAgendamentosConsulta dados){
        var dataConsulta = dados.data();
        var agora = LocalDateTime.now();
        var diferenca = Duration.between(agora, dataConsulta).toMinutes();

        if(diferenca < 30){
            throw new ValidacaoException("A consulta deve ser atencipada com antecedência mínima de 30m.");
        }
    }
}
