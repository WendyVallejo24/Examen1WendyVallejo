/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uv.examen1Wendy.controllers;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.uv.examen1Wendy.models.Alumnos;
import org.uv.examen1Wendy.models.Grupos;
import dto.GruposDTO;
import java.util.List;
import java.util.stream.Collectors;
import org.uv.examen1Wendy.models.Materia;
import org.uv.examen1Wendy.repository.AlumnosRepository;
import org.uv.examen1Wendy.repository.GruposRepository;
import org.uv.examen1Wendy.repository.MateriaRepository;

/**
 *
 * @author wendy
 */
@RestController
@RequestMapping("/grupos")
public class GruposController {

    private final GruposRepository grupoRepository;
    private final AlumnosRepository alumnoRepository;
    private final MateriaRepository materiaRepository;

    public GruposController(GruposRepository grupoRepository, MateriaRepository materiaRepository, AlumnosRepository alumnoRepository) {
        this.grupoRepository = grupoRepository;
        this.alumnoRepository = alumnoRepository;
        this.materiaRepository = materiaRepository;
    }

    @GetMapping
    public List<Grupos> listgrupos() {
        return grupoRepository.findAll();
    }

    @GetMapping("/{id}")
    public Grupos obtenerGrupoPorId(@PathVariable Long id) {
        return grupoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Grupo no encontrado: " + id));
    }

    @PostMapping
    public Grupos saveGrupo(@RequestBody GruposDTO grupoDTO) {
        Grupos grupo = new Grupos();
        grupo.setNombreGrupo(grupoDTO.getNombreGrupo());

        List<Materia> materias = grupoDTO.getClaveMateria().stream()
                .map(claveMateria -> materiaRepository.findById(claveMateria)
                .orElseThrow(() -> new RuntimeException("Materia no encontrada: " + claveMateria))).collect(Collectors.toList());

        List<Alumnos> alumnos = grupoDTO.getClaveAlumno().stream()
                .map(claveAlumno -> alumnoRepository.findById(claveAlumno)
                .orElseThrow(() -> new RuntimeException("Alumno no encontrado: " + claveAlumno)))
                .collect(Collectors.toList());

        grupo.setMaterias(materias);
        grupo.setAlumnos(alumnos);
        return grupoRepository.save(grupo);
    }

    @DeleteMapping("/{id}")
    public void eliminarGrupo(@PathVariable Long id) {
        grupoRepository.deleteById(id);
    }
}
