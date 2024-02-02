package med.voll.api.domain.consulta.validations.validationsCancelamentoConsulta;

import med.voll.api.domain.consulta.DadosAgendamentosConsulta;
import med.voll.api.domain.consulta.DadosCancelamentoConsulta;
import med.voll.api.domain.consulta.ValidacaoException;
import org.springframework.stereotype.Component;

import java.time.Duration;

@Component
public class ValidadorMotivoIsNotNull implements ValidadorCancelamentoDeConsulta {
    @Override
    public void validar(DadosCancelamentoConsulta dados) {
        var motivo = dados.motivo();
        if (motivo == null){
            throw new ValidacaoException("É obrigatório dá o motivo do cancelamento.");
        }
    }
}
