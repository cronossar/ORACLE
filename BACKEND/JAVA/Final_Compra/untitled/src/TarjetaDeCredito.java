import java.util.ArrayList;
import java.util.List;

public class TarjetaDeCredito {
    private Double limite;
    private Double saldo;
    private List<Compra> listaDeCompras;

    //Constructores

    public TarjetaDeCredito(Double limite) {
        this.limite = limite;
        this.saldo = limite;
        this.listaDeCompras = new ArrayList<>();
    }

    public boolean lanzarCompra(Compra compra){
        if (this.saldo >= compra.getValor()){
            this.saldo -= compra.getValor();
            this.listaDeCompras.add(compra);
            return true;
        }
        return false;
    }

    //Getters nomas pq no vamos a modificar ni el limite ni el saldo


    public Double getLimite() {
        return limite;
    }

    public Double getSaldo() {
        return saldo;
    }

    public List<Compra> getListaDeCompras() {
        return listaDeCompras;
    }
}
