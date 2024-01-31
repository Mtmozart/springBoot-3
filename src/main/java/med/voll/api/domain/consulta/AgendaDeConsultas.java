package med.voll.api.domain.consulta;

import med.voll.api.domain.medico.Medico;
import med.voll.api.domain.medico.MedicoRepository;
import med.voll.api.domain.paciente.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AgendaDeConsultas {
    @Autowired
    private ConsultaRepository consultaRepository;
    @Autowired
    MedicoRepository medicoRepository;
    @Autowired
    PacienteRepository pacienteRepository;

    public void agendar(DadosAgendamentosConsulta dados){
        if (!pacienteRepository.existsById(dados.idPaciente())){
            throw new ValidacaoException("O paciente informado não existe.");
        }
        if (dados.idMedico() != null && !medicoRepository.existsById(dados.idPaciente())){
            throw new ValidacaoException("O médico informado não existe.");
        }
        var paciente = pacienteRepository.findById(dados.idPaciente()).get();

        var medico = escolherMedico(dados);



        var consulta = new Consulta(null, medico, paciente, dados.data(), null);
        consultaRepository.save(consulta);
    }

    private Medico escolherMedico(DadosAgendamentosConsulta dados) {
        if (dados.idMedico() != null) {
            return medicoRepository.getReferenceById(dados.idMedico());
        }
        if (dados.especialidade() == null) {
            throw new ValidacaoException("Especialidade é obrigatória quando médico não for escolhido!");
        }

        return medicoRepository.escolherMedicoAleatorioLivreNaData(dados.especialidade(), dados.data());
    }

    public void cancelar(DadosCancelamentoConsulta dados) {
        if (!consultaRepository.existsById(dados.idConsulta())) {
            throw new ValidacaoException("Id da consulta informado não existe!");
        }

        var consulta = consultaRepository.getReferenceById(dados.idConsulta());
        consulta.cancelar(dados.motivo());
    }
}
