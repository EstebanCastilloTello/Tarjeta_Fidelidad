package com.fidelidad;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CompraRepositoryTest {

    private CompraRepository repo;
    private Compra compra1, compra2;

    @BeforeEach
    void setUp() {
        repo = new CompraRepository();
        compra1 = new Compra("c1", "1", 200.0, LocalDate.of(2025, 7, 1));
        compra2 = new Compra("c2", "1", 150.0, LocalDate.of(2025, 7, 2));
    }

    @Test
    void puedeAgregarYBuscarCompra() {
        repo.agregar(compra1);
        Compra resultado = repo.buscar("c1");
        assertNotNull(resultado);
        assertEquals(200.0, resultado.getMonto());
    }

    @Test
    void puedeListarCompras() {
        repo.agregar(compra1);
        repo.agregar(compra2);
        List<Compra> compras = repo.listar();
        assertEquals(2, compras.size());
    }

    @Test
    void puedeEliminarCompra() {
        repo.agregar(compra1);
        repo.eliminar("c1");
        assertNull(repo.buscar("c1"));
    }

    @Test
    void puedeFiltrarComprasPorCliente() {
        repo.agregar(compra1);
        repo.agregar(new Compra("c3", "2", 120.0, LocalDate.now()));
        List<Compra> comprasCliente1 = repo.listarPorCliente("1");
        assertEquals(1, comprasCliente1.size());
        assertEquals("c1", comprasCliente1.get(0).getIdCompra());
    }
}
