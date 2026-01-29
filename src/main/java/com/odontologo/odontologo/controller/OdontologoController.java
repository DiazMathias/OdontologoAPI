package com.odontologo.odontologo.controller;

import com.odontologo.odontologo.Paciente;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

@RestController
public class OdontologoController {

    private final List<Paciente> listaPacientes = new ArrayList<>(List.of(
            new Paciente(1L, 11111111, "Mathias", "Diaz", LocalDate.of(2022, 2, 12)),
            new Paciente(2L, 11111111, "Luisina", "de Paula", LocalDate.of(2021, 7, 17)),
            new Paciente(3L, 11111111, "Jose", "Nores", LocalDate.of(1984, 11, 21)),
            new Paciente(4L, 11111111, "Ezequiel", "Dratman", LocalDate.of(1985, 5, 28))
    ));

    @GetMapping("/pacientes")
    @ResponseBody
    public List<Paciente> traerPacientes() {
        return this.listaPacientes;
    }

    @GetMapping("/pacientes/menores_edad")
    @ResponseBody
    public List<Paciente> traerPacientesMenores() {
        List<Paciente> pacientesMenores = new ArrayList<>();
        for (Paciente paciente : this.listaPacientes) {
            Period period = Period.between(paciente.getFechaNac(), LocalDate.now());

            if (period.getYears() < 18) {
                pacientesMenores.add(paciente);
            }
        }

        return pacientesMenores;
    }

}
