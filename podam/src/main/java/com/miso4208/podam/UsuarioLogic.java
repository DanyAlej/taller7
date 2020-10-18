package com.miso4208.podam;

import java.util.regex.Pattern;

import com.miso4208.podam.Exceptions.ClaveException;
import com.miso4208.podam.Exceptions.CorreoException;
import com.miso4208.podam.Exceptions.EdadException;
import com.miso4208.podam.Exceptions.NombreException;

public class UsuarioLogic {
    public Usuario crearUsuario(String nombre, String correo, int edad, String clave)
            throws NombreException, CorreoException, EdadException, ClaveException {

        if (!nombreEsValido(nombre))
            throw new NombreException();

        if (!correoEsValido(correo))
            throw new CorreoException();

        if (!edadEsValido(edad))
            throw new EdadException();

        if (!claveEsValida(clave))
            throw new ClaveException();

        return new Usuario(nombre, correo, edad, clave);
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

    private boolean correoEsValido(String correo) {
        if (!correo.isEmpty() && Pattern.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$", correo)) {
            return true;
        }

        return false;
    }

    private boolean edadEsValido(int edad) {
        return edad > 0;
    }

    private boolean claveEsValida(String clave) {
        return clave.length() >= 6;
    }
}
