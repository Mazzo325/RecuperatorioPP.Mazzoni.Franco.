package Entidades;

import java.util.Random;

public abstract class Producto implements Comparable<Producto> {
    protected Fabricante fabricante;
    protected String nombre;
    protected double precio;
    protected int calorias;
    protected int tiempoPreparacion;

    private static Random generadorAleatorio;

    static {
        generadorAleatorio = new Random();
    }

    public Producto(String nombre, double precio, Fabricante fabricante) {
        this.nombre = nombre;
        this.precio = precio;
        this.fabricante = fabricante;
        this.calorias = 0;
        this.tiempoPreparacion = 0;
    }

    public Producto(String nombre, double precio, String nombreFabricante, String ciudadFabricante, int antiguedadFabricante) {
        this.nombre = nombre;
        this.precio = precio;
        this.fabricante = new Fabricante(nombreFabricante, ciudadFabricante, antiguedadFabricante);
        this.calorias = 0;
        this.tiempoPreparacion = 0;
    }

    public int getCalorias() {
        if (this.calorias == 0) {
            this.calorias = generadorAleatorio.nextInt(601) + 200; // 200 a 800
        }
        return this.calorias;
    }

    public int getTiempoPreparacion() {
        if (this.tiempoPreparacion == 0) {
            this.tiempoPreparacion = generadorAleatorio.nextInt(16) + 5; // 5 a 20
        }
        return this.tiempoPreparacion;
    }

    private static String mostrar(Producto p) {
        StringBuilder sb = new StringBuilder();
        sb.append("Nombre: ").append(p.nombre).append("\n");
        sb.append("Precio: $").append(p.precio).append("\n");
        sb.append("Fabricante: ").append(p.fabricante.toString()).append("\n");
        sb.append("Calorias: ").append(p.getCalorias()).append("\n");
        sb.append("Tiempo Preparacion: ").append(p.getTiempoPreparacion()).append(" min");
        return sb.toString();
    }

    public static boolean sonIguales(Producto p1, Producto p2) {
        if (p1 == null || p2 == null) return false;
        return p1.nombre.equals(p2.nombre) && Fabricante.sonIguales(p1.fabricante, p2.fabricante);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (!(obj instanceof Producto)) return false;
        Producto otro = (Producto) obj;
        return this.nombre.equals(otro.nombre) && Fabricante.sonIguales(this.fabricante, otro.fabricante);
    }

    @Override
    public int compareTo(Producto otro) {
        return this.nombre.compareTo(otro.nombre);
    }

    @Override
    public String toString() {
        return mostrar(this);
    }
}
