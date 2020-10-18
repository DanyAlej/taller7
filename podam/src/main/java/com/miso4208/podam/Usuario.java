package com.miso4208.podam;

import com.miso4208.podam.Estrategias.NombreStrategy;

import uk.co.jemos.podam.common.PodamStrategyValue;

public class Usuario {
    @PodamStrategyValue(NombreStrategy.class)
    private String nombre;
    private String username;
    private String correo;
    private int edad;
    private String clave;
    private String claveVerificada;

    public Usuario(String nombre, String username, String correo, int edad, String clave, String claveVerificada) {
        this.nombre = nombre;
        this.username = username;
        this.correo = correo;
        this.edad = edad;
        this.clave = clave;
        this.claveVerificada = claveVerificada;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public String getClaveVerificada() {
        return claveVerificada;
    }

    public void setClaveVerificada(String claveVerificada) {
        this.claveVerificada = claveVerificada;
    }

}
