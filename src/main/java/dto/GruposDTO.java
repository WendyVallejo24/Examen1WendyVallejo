/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

import java.util.List;

/**
 *
 * @author wendy
 */
public class GruposDTO {
    private List<Long> claveMateria;
    private List<Long> claveAlumno;
    private String nombreGrupo;

    public List<Long> getClaveMateria() {
        return claveMateria;
    }

    public void setClaveMateria(List<Long> claveMateria) {
        this.claveMateria = claveMateria;
    }

    public List<Long> getClaveAlumno() {
        return claveAlumno;
    }

    public void setClaveAlumno(List<Long> claveAlumno) {
        this.claveAlumno = claveAlumno;
    }

    public String getNombreGrupo() {
        return nombreGrupo;
    }

    public void setNombreGrupo(String nombreGrupo) {
        this.nombreGrupo = nombreGrupo;
    }
    
    
}
