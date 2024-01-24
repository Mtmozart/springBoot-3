package med.voll.api.paciente;

import med.voll.api.medico.Especialidade;
import med.voll.api.medico.Medico;

public record DadosListagemPacientes(
        Long id,
        String nome,
        String email

) {
    public DadosListagemPacientes(Paciente paciente) {
        this(paciente.getId(), paciente.getNome(), paciente.getEmail());
    }
}
