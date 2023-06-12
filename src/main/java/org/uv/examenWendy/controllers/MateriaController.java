/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uv.examenWendy.controllers;

import dto.MateriaDTO;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.uv.examenWendy.models.Materia;
import org.uv.examenWendy.repository.MateriaRepository;

/**
 *
 * @author wendy
 */
@RestController
@RequestMapping("/materias")
public class MateriaController {

    private final MateriaRepository materiaRepository;

    public MateriaController(MateriaRepository materiaRepository) {
        this.materiaRepository = materiaRepository;
    }

    @GetMapping
    public List<Materia> obtenerTodasLasMaterias() {
        return materiaRepository.findAll();
    }

    @GetMapping("/{id}")
    public Materia obtenerMateriaPorId(@PathVariable Long id) {
        return materiaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Materia no encontrada con ID: " + id));
    }

    @PostMapping
    public Materia crearMateria(@RequestBody MateriaDTO materiaDTO) {
        Materia materia = new Materia();
        BeanUtils.copyProperties(materiaDTO, materia);
        return materiaRepository.save(materia);
    }

    @PutMapping("/{id}")
    public Materia actualizarMateria(@PathVariable Long id, @RequestBody MateriaDTO materiaDTO) {
        Materia materiaExistente = materiaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Materia no encontrada con ID: " + id));
        BeanUtils.copyProperties(materiaDTO, materiaExistente);
        return materiaRepository.save(materiaExistente);
    }

    @DeleteMapping("/{id}")
    public void eliminarMateria(@PathVariable Long id) {
        materiaRepository.deleteById(id);
    }
}
