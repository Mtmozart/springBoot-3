package med.voll.api.domain.consulta.validations.validationsCancelamentoConsulta;

import med.voll.api.domain.consulta.DadosAgendamentosConsulta;
import med.voll.api.domain.consulta.DadosCancelamentoConsulta;

public interface ValidadorCancelamentoDeConsulta {
    void validar (DadosCancelamentoConsulta dados);
}
