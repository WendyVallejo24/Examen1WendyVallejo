/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.uv.examen1Wendy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.uv.examen1Wendy.models.Alumnos;
import org.uv.examen1Wendy.models.Grupos;

/**
 *
 * @author wendy
 */
public interface GruposRepository extends JpaRepository<Grupos, Long> {
    
}
