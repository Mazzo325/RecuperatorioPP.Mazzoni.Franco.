package Entidades;

public class Pizza extends Producto implements IVendible {
    private TipoPizza sabor;
    private TamanoPizza tamano;

    public Pizza(String nombre, double precio, Fabricante fabricante, TipoPizza sabor, TamanoPizza tamano) {
        super(nombre, precio, fabricante);
        this.sabor = sabor;
        this.tamano = tamano;
    }

    @Override
    public double getPrecioTotal() {
        double precioTotal = this.precio;
        switch (this.tamano) {
            case CHICA -> precioTotal *= 1.05;
            case MEDIANA -> precioTotal *= 1.10;
            case GRANDE -> precioTotal *= 1.20;
        }
        return precioTotal;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString()).append("\n");
        sb.append("Sabor: ").append(this.sabor).append("\n");
        sb.append("Tamaño: ").append(this.tamano).append("\n");
        sb.append("Precio Total: $").append(this.getPrecioTotal());
        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) return false;
        if (!(obj instanceof Pizza)) return false;
        Pizza otro = (Pizza) obj;
        return this.sabor == otro.sabor && this.tamano == otro.tamano;
    }
}
