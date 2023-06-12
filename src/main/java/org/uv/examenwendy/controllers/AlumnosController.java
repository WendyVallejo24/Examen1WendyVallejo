/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uv.examenwendy.controllers;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.uv.examenwendy.models.Alumnos;
import dto.AlumnosDTO;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.uv.examenwendy.repository.AlumnosRepository;
/**
 *
 * @author wendy
 */
@RestController
@RequestMapping("/alumnos")
public class AlumnosController {

    private final AlumnosRepository alumnoRepository;

    public AlumnosController(AlumnosRepository alumnoRepository) {
        this.alumnoRepository = alumnoRepository;
    }

    @GetMapping
    public List<Alumnos> listarAlumnos() {
        return alumnoRepository.findAll();
    }

    @GetMapping("/{id}")
    public Alumnos obtenerAlumnoPorId(@PathVariable Long id) {
        return alumnoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Alumno no con encontrado: " + id));
    }

    @PostMapping
    public Alumnos guardarAlumno(@RequestBody AlumnosDTO alumnoDTO) {
        Alumnos alumno = new Alumnos();
        BeanUtils.copyProperties(alumnoDTO, alumno);
        return alumnoRepository.save(alumno);
    }

    @PutMapping("/{id}")
    public Alumnos actualizarAlumno(@PathVariable Long id, @RequestBody AlumnosDTO alumnoDTO) {
        Alumnos alumno = alumnoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Alumno no encontrado: " + id));
        BeanUtils.copyProperties(alumnoDTO, alumno);
        return alumnoRepository.save(alumno);
    }

    @DeleteMapping("/{id}")
    public void eliminarAlumno(@PathVariable Long id) {
        alumnoRepository.deleteById(id);
    }

}
