package com.fidelidad;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class NivelFidelidadTest {

    @Test
    void calculaNivelCorrectamente() {
        assertEquals(NivelFidelidad.BRONCE, NivelFidelidad.calcularNivel(0));
        assertEquals(NivelFidelidad.PLATA, NivelFidelidad.calcularNivel(500));
        assertEquals(NivelFidelidad.ORO, NivelFidelidad.calcularNivel(2000));
        assertEquals(NivelFidelidad.PLATINO, NivelFidelidad.calcularNivel(3500));
    }

    @Test
    void multiplicadoresCorrectos() {
        assertEquals(1.0, NivelFidelidad.BRONCE.getMultiplicador());
        assertEquals(1.2, NivelFidelidad.PLATA.getMultiplicador());
        assertEquals(1.5, NivelFidelidad.ORO.getMultiplicador());
        assertEquals(2.0, NivelFidelidad.PLATINO.getMultiplicador());
    }
}
