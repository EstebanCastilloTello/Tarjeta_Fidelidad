package com.fidelidad;

import java.util.*;
import java.util.stream.Collectors;

public class CompraRepository {
    private final Map<String, Compra> compras = new HashMap<>();

    public void agregar(Compra compra) {
        compras.put(compra.getIdCompra(), compra);
    }

    public Compra buscar(String idCompra) {
        return compras.get(idCompra);
    }

    public List<Compra> listar() {
        return new ArrayList<>(compras.values());
    }

    public List<Compra> listarPorCliente(String idCliente) {
        return compras.values().stream()
                .filter(c -> c.getIdCliente().equals(idCliente))
                .collect(Collectors.toList());
    }

    public void eliminar(String idCompra) {
        compras.remove(idCompra);
    }
}
