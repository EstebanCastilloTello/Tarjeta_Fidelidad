package com.fidelidad;

public class Cliente {
    private final String id;
    private String nombre;
    private String correo;
    private int puntos;
    private NivelFidelidad nivel;
    private int streakDias;

    public Cliente(String id, String nombre, String correo) {
        if (!correo.contains("@")) {
            throw new IllegalArgumentException("Correo inválido");
        }
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.puntos = 0;
        this.nivel = NivelFidelidad.BRONCE;
        this.streakDias = 0;
    }

    public String getId() { return id; }
    public String getNombre() { return nombre; }
    public String getCorreo() { return correo; }
    public int getPuntos() { return puntos; }
    public NivelFidelidad getNivel() { return nivel; }
    public int getStreakDias() { return streakDias; }

    public void setPuntos(int puntos) { this.puntos = puntos; }
    public void setNivel(NivelFidelidad nivel) { this.nivel = nivel; }
    public void setStreakDias(int streak) { this.streakDias = streak; }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCorreo(String correo) {
        if (!correo.contains("@")) {
            throw new IllegalArgumentException("Correo inválido");
        }
        this.correo = correo;
    }
}
