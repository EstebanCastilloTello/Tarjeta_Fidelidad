package com.fidelidad;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class FidelidadServiceTest {

    private ClienteRepository clienteRepo;
    private FidelidadService fidelidad;

    @BeforeEach
    void setUp() {
        clienteRepo = new ClienteRepository();
        fidelidad = new FidelidadService(clienteRepo);

        Cliente c = new Cliente("1", "Ana", "ana@mail.com");
        clienteRepo.agregar(c);
    }

    @Test
    void clienteBronceGana1PuntoCada100Pesos() {
        Compra compra = new Compra("c1", "1", 250.0, LocalDate.of(2025, 7, 8));
        fidelidad.registrarCompra(compra);

        Cliente c = clienteRepo.buscar("1");
        assertEquals(2, c.getPuntos()); // 250/100 = 2 (redondeo hacia abajo)
        assertEquals(NivelFidelidad.BRONCE, c.getNivel());
    }
    @Test
    void clienteRecibeBonusPor3ComprasElMismoDia() {
        LocalDate hoy = LocalDate.of(2025, 7, 8);

        fidelidad.registrarCompra(new Compra("c1", "1", 100, hoy));
        fidelidad.registrarCompra(new Compra("c2", "1", 100, hoy));
        fidelidad.registrarCompra(new Compra("c3", "1", 100, hoy)); // Esta debería activar el bonus

        Cliente c = clienteRepo.buscar("1");
        // 3 compras = 3 puntos base + 10 bonus
        assertEquals(13, c.getPuntos());
    }
}
