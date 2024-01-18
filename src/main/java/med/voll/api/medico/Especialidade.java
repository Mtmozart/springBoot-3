package med.voll.api.medico;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum Especialidade {
    ORTORPEDIA("ortopedia"),
    CARDIOLOGIA("cardiologia"),
    GINECOLOGIA("ginecologia"),
    DEMARTOLOGIA("demartologia");

    private String especiliadeUtf8;

    Especialidade(String especiliadeUtf8) {
        this.especiliadeUtf8 = especiliadeUtf8;
    }
    @JsonCreator
    public static Especialidade fromString(String text){
        for(Especialidade especialidade : Especialidade.values()){
            if(especialidade.especiliadeUtf8.equals(text)){
                return especialidade;
            }
        }
        throw new IllegalArgumentException("Nenhuma categoria encontrada para a string fornecida: " + text);
    }
}
