public class Compra {
    private Double valor;
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
}
