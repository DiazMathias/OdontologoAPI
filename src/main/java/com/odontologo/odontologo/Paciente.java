package com.odontologo.odontologo;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter @Setter
public class Paciente {

    private Long id;
    private int dni;
    private String nombre;
    private String apellido;
    private LocalDate fechaNac;

    public Paciente() {}

    public Paciente(Long id, int dni, String nombre, String apellido, LocalDate fechaNac) {
        this.id = id;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNac = fechaNac;
    }

}
