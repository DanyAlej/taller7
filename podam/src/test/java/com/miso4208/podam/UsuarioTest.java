package com.miso4208.podam;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.regex.Pattern;

import com.miso4208.podam.Exceptions.ClaveException;
import com.miso4208.podam.Exceptions.CorreoException;
import com.miso4208.podam.Exceptions.EdadException;
import com.miso4208.podam.Exceptions.NombreException;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

@TestInstance(Lifecycle.PER_CLASS)
public class UsuarioTest {
    UsuarioLogic usuarioLogic;

    @BeforeAll
    void crearUsuarioLogic() {
        usuarioLogic = new UsuarioLogic();
    }

    @Test
    void nombreUsuarioTest() {
        PodamFactory factory = new PodamFactoryImpl();

        for (int i = 0; i < 50; i++) {
            Usuario usuario = factory.manufacturePojo(Usuario.class);
            usuario.setEdad(10);
            usuario.setCorreo("correo@email.com");
            usuario.setClave("123456");

            if (usuario.getNombre().isEmpty() || usuario.getNombre().length() >= 100) {
                assertThrows(NombreException.class, () -> {
                    usuarioLogic.crearUsuario(usuario.getNombre(), usuario.getCorreo(), usuario.getEdad(),
                            usuario.getClave());
                }, "Debería generar una excepción.");
            } else {
                try {
                    assertNotNull(usuarioLogic.crearUsuario(usuario.getNombre(), usuario.getCorreo(), usuario.getEdad(),
                            usuario.getClave()), "Debería retornar el objeto usuario");
                } catch (Exception e) {
                    assertFalse(true, "No debería lanzar excepciones.");
                }
            }
        }

    }

    @Test
    void edadUsuarioTest() {
        PodamFactory factory = new PodamFactoryImpl();

        for (int i = 0; i < 50; i++) {
            Usuario usuario = factory.manufacturePojo(Usuario.class);
            usuario.setNombre("jawjkdkw");
            usuario.setCorreo("correo@email.com");
            usuario.setClave("123456");

            if (usuario.getEdad() <= 0) {
                assertThrows(EdadException.class, () -> {
                    usuarioLogic.crearUsuario(usuario.getNombre(), usuario.getCorreo(), usuario.getEdad(),
                            usuario.getClave());
                }, "Debería generar una excepción.");
            } else {
                try {
                    assertNotNull(usuarioLogic.crearUsuario(usuario.getNombre(), usuario.getCorreo(), usuario.getEdad(),
                            usuario.getClave()), "Debería retornar el objeto usuario");
                } catch (Exception e) {
                    assertFalse(true, "No debería lanzar excepciones.");
                }
            }
        }
    }

    @Test
    void claveUsuarioTest() {
        PodamFactory factory = new PodamFactoryImpl();

        for (int i = 0; i < 50; i++) {
            Usuario usuario = factory.manufacturePojo(Usuario.class);
            usuario.setNombre("jawjkdkw");
            usuario.setCorreo("correo@email.com");
            usuario.setEdad(10);

            if (usuario.getClave().length() < 6) {
                assertThrows(ClaveException.class, () -> {
                    usuarioLogic.crearUsuario(usuario.getNombre(), usuario.getCorreo(), usuario.getEdad(),
                            usuario.getClave());
                }, "Debería generar una excepción.");
            } else {
                try {
                    assertNotNull(usuarioLogic.crearUsuario(usuario.getNombre(), usuario.getCorreo(), usuario.getEdad(),
                            usuario.getClave()), "Debería retornar el objeto usuario");
                } catch (Exception e) {
                    assertFalse(true, "No debería lanzar excepciones.");
                }
            }
        }
    }

    @Test
    void correoUsuarioTest() {
        PodamFactory factory = new PodamFactoryImpl();

        for (int i = 0; i < 50; i++) {
            Usuario usuario = factory.manufacturePojo(Usuario.class);
            usuario.setNombre("jawjkdkw");
            usuario.setEdad(10);
            usuario.setClave("123456");

            if (usuario.getCorreo().isEmpty()
                    || !Pattern.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$", usuario.getCorreo())) {
                assertThrows(CorreoException.class, () -> {
                    usuarioLogic.crearUsuario(usuario.getNombre(), usuario.getCorreo(), usuario.getEdad(),
                            usuario.getClave());
                }, "Debería generar una excepción.");
            } else {
                try {
                    assertNotNull(usuarioLogic.crearUsuario(usuario.getNombre(), usuario.getCorreo(), usuario.getEdad(),
                            usuario.getClave()), "Debería retornar el objeto usuario");
                } catch (Exception e) {
                    assertFalse(true, "No debería lanzar excepciones.");
                }
            }
        }
    }
}
