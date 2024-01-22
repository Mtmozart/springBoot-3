package med.voll.api.medico;

public record DadosLitagemMedico(
        Long id,
        String nome,
        String email,
        String crm,
        Especialidade especialidade
) {
    public DadosLitagemMedico(Medico medico) {
        this(medico.getId(), medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getEspecialidade());
    }
}
