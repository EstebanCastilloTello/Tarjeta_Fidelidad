package com.fidelidad;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ClienteRepositoryTest {

    private ClienteRepository repo;

    @BeforeEach
    void setUp() {
        repo = new ClienteRepository();
    }

    @Test
    void puedeAgregarYBuscarCliente() {
        Cliente c = new Cliente("1", "Ana", "ana@mail.com");
        repo.agregar(c);

        Cliente encontrado = repo.buscar("1");
        assertNotNull(encontrado);
        assertEquals("Ana", encontrado.getNombre());
    }

    @Test
    void puedeListarClientes() {
        repo.agregar(new Cliente("1", "Ana", "ana@mail.com"));
        repo.agregar(new Cliente("2", "Luis", "luis@mail.com"));

        List<Cliente> lista = repo.listar();
        assertEquals(2, lista.size());
    }

    @Test
    void puedeActualizarCliente() {
        Cliente c = new Cliente("1", "Ana", "ana@mail.com");
        repo.agregar(c);

        c.setPuntos(100);
        c.setNivel(NivelFidelidad.PLATA);
        repo.actualizar(c);

        Cliente actualizado = repo.buscar("1");
        assertEquals(100, actualizado.getPuntos());
        assertEquals(NivelFidelidad.PLATA, actualizado.getNivel());
    }

    @Test
    void puedeEliminarCliente() {
        repo.agregar(new Cliente("1", "Ana", "ana@mail.com"));
        repo.eliminar("1");

        assertNull(repo.buscar("1"));
    }
}
