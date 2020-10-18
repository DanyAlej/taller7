package com.miso4208.podam;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;

import javax.validation.constraints.AssertFalse;

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
            System.out.println(usuario.getNombre().length());

            if (usuario.getNombre().isEmpty() || usuario.getNombre().length() >= 100) {
                assertThrows(NombreException.class, () -> {
                    usuarioLogic.crearUsuario(usuario.getNombre(), usuario.getUsername(), usuario.getCorreo(),
                            usuario.getEdad(), usuario.getClave(), usuario.getClaveVerificada());
                }, "Debería generar una excepción.");
            } else {
                try {
                    assertNotNull(
                            usuarioLogic.crearUsuario(usuario.getNombre(), usuario.getUsername(), usuario.getCorreo(),
                                    usuario.getEdad(), usuario.getClave(), usuario.getClaveVerificada()),
                            "Debería retornar el objeto usuario");
                } catch (Exception e) {
                    assertFalse(true, "No debería lanzar excepciones.");
                }
            }
        }

    }
}
