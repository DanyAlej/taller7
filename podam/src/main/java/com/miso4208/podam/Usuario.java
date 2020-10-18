package com.miso4208.podam;

import com.miso4208.podam.Estrategias.ClaveStrategy;
import com.miso4208.podam.Estrategias.CorreoStrategy;
import com.miso4208.podam.Estrategias.EdadStrategy;
import com.miso4208.podam.Estrategias.NombreStrategy;

import uk.co.jemos.podam.common.PodamStrategyValue;

public class Usuario {
    @PodamStrategyValue(NombreStrategy.class)
    private String nombre;

    @PodamStrategyValue(CorreoStrategy.class)
    private String correo;

    @PodamStrategyValue(EdadStrategy.class)
    private int edad;

    @PodamStrategyValue(ClaveStrategy.class)
    private String clave;

    public Usuario(String nombre, String correo, int edad, String clave) {
        this.nombre = nombre;
        this.correo = correo;
        this.edad = edad;
        this.clave = clave;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
}
