package com.fidelidad;

import java.util.*;
import java.time.LocalDate;

public class FidelidadService {
    private final ClienteRepository clienteRepo;
    private final Map<String, List<Compra>> historial;

    public FidelidadService(ClienteRepository clienteRepo) {
        this.clienteRepo = clienteRepo;
        this.historial = new HashMap<>();
    }

    public void registrarCompra(Compra compra) {
        Cliente cliente = clienteRepo.buscar(compra.getIdCliente());
        if (cliente == null) throw new IllegalArgumentException("Cliente no encontrado");

        // Guardar la compra en el historial
        historial.putIfAbsent(cliente.getId(), new ArrayList<>());
        historial.get(cliente.getId()).add(compra);

        // Calcular puntos base
        int basePuntos = (int) (compra.getMonto() / 100);
        double multiplicador = cliente.getNivel().getMultiplicador();
        int puntosGanados = (int) (basePuntos * multiplicador);

        // Verificar si es la tercera compra del día para dar bonus
        List<Compra> comprasDelCliente = historial.get(cliente.getId());
        long comprasHoy = comprasDelCliente.stream()
            .filter(c -> c.getFecha().equals(compra.getFecha()))
            .count();

        if (comprasHoy == 3) {
            puntosGanados += 10;
        }

        // Actualizar puntos y nivel
        int nuevosPuntos = cliente.getPuntos() + puntosGanados;
        cliente.setPuntos(nuevosPuntos);
        cliente.setNivel(NivelFidelidad.calcularNivel(nuevosPuntos));
    }
}
