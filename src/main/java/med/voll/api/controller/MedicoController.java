package med.voll.api.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("medicos")
public class MedicoController {

    @PostMapping
    public void cadastrarMedico(@RequestBody String json){
        System.out.println(json);
    }
}
