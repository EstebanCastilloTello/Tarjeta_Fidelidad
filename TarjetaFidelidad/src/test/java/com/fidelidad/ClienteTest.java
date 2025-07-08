package com.fidelidad;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ClienteTest {

    @Test
    void clienteSeCreaCorrectamente() {
        Cliente c = new Cliente("1", "Ana", "ana@mail.com");
        assertEquals("Ana", c.getNombre());
        assertEquals("ana@mail.com", c.getCorreo());
        assertEquals(0, c.getPuntos());
        assertEquals(NivelFidelidad.BRONCE, c.getNivel());
        assertEquals(0, c.getStreakDias());
    }

    @Test
    void correoInvalidoLanzaExcepcion() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Cliente("2", "Luis", "correo_invalido");
        });
    }
}
