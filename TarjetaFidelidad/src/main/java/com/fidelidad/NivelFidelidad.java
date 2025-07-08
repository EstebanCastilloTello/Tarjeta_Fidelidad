package com.fidelidad;

public enum NivelFidelidad {
    BRONCE(0, 499, 1.0),
    PLATA(500, 1499, 1.2),
    ORO(1500, 2999, 1.5),
    PLATINO(3000, Integer.MAX_VALUE, 2.0);

    private final int min;
    private final int max;
    private final double multiplicador;

    NivelFidelidad(int min, int max, double multiplicador) {
        this.min = min;
        this.max = max;
        this.multiplicador = multiplicador;
    }

    public static NivelFidelidad calcularNivel(int puntos) {
        for (NivelFidelidad n : values()) {
            if (puntos >= n.min && puntos <= n.max) return n;
        }
        return BRONCE;
    }

    public double getMultiplicador() {
        return multiplicador;
    }
}
