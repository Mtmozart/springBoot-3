package med.voll.api.medico;

public record DadosLitagemMedico(
        String nome,
        String email,
        String crm,
        Especialidade especialidade
) {
    public DadosLitagemMedico(Medico medico) {
        this(medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getEspecialidade());
    }
}
