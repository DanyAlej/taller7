package com.miso4208.podam;

import com.miso4208.podam.Exceptions.NombreException;

public class UsuarioLogic {
    public Usuario crearUsuario(String nombre, String username, String correo, int edad, String clave,
            String claveVerificada) throws NombreException {

        if (!nombreEsValido(nombre))
            throw new NombreException();

        return new Usuario(nombre, username, correo, edad, clave, claveVerificada);
    }

    // -----------Métodos de validación----------
    /**
     * Indica si el nombre del usuario es válido.
     *
     * @param nombre Nombre del usuario
     * @return true si el nombre no es vacío y es menor a 100 caracteres, false de
     *         lo contrario.
     */
    private boolean nombreEsValido(String nombre) {
        if (nombre.isEmpty() || nombre.length() >= 100) {
            return false;
        }

        return true;
    }
}
