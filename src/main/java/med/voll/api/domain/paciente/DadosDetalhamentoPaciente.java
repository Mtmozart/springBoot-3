package med.voll.api.domain.paciente;

import med.voll.api.domain.endereco.Endereco;


public record DadosDetalhamentoPaciente(Long id,
                                        String nome,
                                        String Email,
                                        String cpf,
                                        String Telefone,
                                        Endereco endereco) {
    public DadosDetalhamentoPaciente (Paciente paciente) {
        this(paciente.getId(), paciente.getNome(), paciente.getEmail(), paciente.getCpf(),paciente.getTelefone(),  paciente.getEndereco());
    }


}