package Entidades;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class Pizzeria implements Iterable<Producto> {
    private String nombre;
    private int capacidad;
    private ArrayList<Producto> productos;

    public Pizzeria(String nombre) {
        this.nombre = nombre;
        this.capacidad = 3;
        this.productos = new ArrayList<>();
    }

    public Pizzeria(String nombre, int capacidad) {
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.productos = new ArrayList<>();
    }

    private boolean sonIguales(Producto p) {
        for (Producto producto : this.productos) {
            if (Producto.sonIguales(producto, p)) {
                return true;
            }
        }
        return false;
    }

    public void agregar(Producto p) {
        if (this.productos.size() >= this.capacidad) {
            System.out.println("No hay capacidad para agregar mas productos");
            return;
        }
        if (this.sonIguales(p)) {
            System.out.println("El producto ya se encuentra en la pizzería");
            return;
        }
        this.productos.add(p);
        System.out.println("Producto agregado exitosamente");
    }

    private double getPrecioProductos(TipoProducto tipo) {
        return switch (tipo) {
            case PIZZAS -> getPrecioDePizzas();
            case POSTRES -> getPrecioDePostres();
            case TODOS -> getPrecioTotal();
        };
    }

    private double getPrecioDePizzas() {
        double total = 0.0;
        for (Producto producto : this.productos) {
            if (producto instanceof Pizza pizza) {
                total += pizza.getPrecioTotal();
            }
        }
        return total;
    }

    private double getPrecioDePostres() {
        double total = 0.0;
        for (Producto producto : this.productos) {
            if (producto instanceof Postre postre) {
                total += postre.getPrecioTotal();
            }
        }
        return total;
    }

    private double getPrecioTotal() {
        return getPrecioDePizzas() + getPrecioDePostres();
    }

    private void ordenarPorNombre() {
        Collections.sort(this.productos);
    }

    @Override
    public Iterator<Producto> iterator() {
        return this.productos.iterator();
    }

    @Override
    public String toString() {
        this.ordenarPorNombre();
        StringBuilder sb = new StringBuilder();
        sb.append("=== PIZZERIA: ").append(this.nombre).append(" ===\n");
        sb.append("Capacidad: ").append(this.capacidad).append("\n");
        sb.append("Cantidad de productos: ").append(this.productos.size()).append("\n\n");
        sb.append("PRODUCTOS:\n--------------------\n");
        for (Producto producto : this.productos) {
            sb.append(producto.toString()).append("\n");
            sb.append("--------------------\n");
        }
        sb.append("\nPRECIOS TOTALES:\n");
        sb.append("Pizzas: $").append(getPrecioDePizzas()).append("\n");
        sb.append("Postres: $").append(getPrecioDePostres()).append("\n");
        sb.append("TOTAL: $").append(getPrecioTotal());
        return sb.toString();
    }
}
