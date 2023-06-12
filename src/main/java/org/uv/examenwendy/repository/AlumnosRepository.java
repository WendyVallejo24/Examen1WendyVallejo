/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.uv.examenwendy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.uv.examenwendy.models.Alumnos;

/**
 *
 * @author wendy
 */
public interface AlumnosRepository extends JpaRepository<Alumnos, Long>{
    
}
