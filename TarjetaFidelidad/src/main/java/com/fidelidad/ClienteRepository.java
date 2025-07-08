package com.fidelidad;

import java.util.*;

public class ClienteRepository {
    private final Map<String, Cliente> clientes = new HashMap<>();

    public void agregar(Cliente cliente) {
        clientes.put(cliente.getId(), cliente);
    }

    public Cliente buscar(String id) {
        return clientes.get(id);
    }

    public List<Cliente> listar() {
        return new ArrayList<>(clientes.values());
    }

    public void eliminar(String id) {
        clientes.remove(id);
    }

    public void actualizar(Cliente cliente) {
        clientes.put(cliente.getId(), cliente);
    }
}
