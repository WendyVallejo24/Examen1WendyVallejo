/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uv.examen1Wendy.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author wendy
 */
@Entity
@Table(name = "Materias")
public class Materia {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long claveMateria;
    private String nombre;
    private int creditos;

    public Long getClaveMateria() {
        return claveMateria;
    }

    public void setClaveMateria(Long claveMateria) {
        this.claveMateria = claveMateria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCreditos() {
        return creditos;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }
    
    
}
