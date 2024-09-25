public class Compra implements Comparable<Compra>{
    private double valor;
    private String descripcion;

    public Compra(Double valor, String descripcion) {
        this.valor = valor;
        this.descripcion = descripcion;
    }

    // Getters solamente

    public Double getValor() {
        return valor;
    }

    public String getDescripcion() {
        return descripcion;
    }

    @Override
    public String toString() {
        return "Compra: valor=" + valor +
                ", descripcion='" + descripcion;
    }

    @Override
    public int compareTo(Compra otraCompra){
        return Double.valueOf(this.valor).compareTo(Double.valueOf(otraCompra.getValor()));
    }
}
