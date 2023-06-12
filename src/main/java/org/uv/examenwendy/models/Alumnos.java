/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uv.examenwendy.models;

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
@Table(name = "Alumnos")
public class Alumnos {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long claveAlumno;
    
    private String nombre;
    
    private String direccion;
    
    private String telefono;

    public Long getClaveAlumno() {
        return claveAlumno;
    }

    public void setClaveAlumno(Long claveAlumno) {
        this.claveAlumno = claveAlumno;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }   
    
}
