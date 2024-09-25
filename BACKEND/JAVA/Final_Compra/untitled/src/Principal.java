import java.util.Collections;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner lectura = new Scanner(System.in);
        System.out.println("Ingrese el valor para el límite de la tarjeta: ");
        double limite = lectura.nextDouble();
        TarjetaDeCredito tarjeta = new TarjetaDeCredito(limite);

        int salir = 1;
        while (salir != 0) {
            System.out.println("Descripción de la compra: ");
            String descripcion = lectura.next();

            System.out.println("Escriba el valor de la compra: ");
            double valor = Double.valueOf(lectura.next());

            Compra compra = new Compra(valor, descripcion);
            boolean compraRealizada = tarjeta.lanzarCompra(compra);

            if (compraRealizada) {
                System.out.println("Compra realizada");
                System.out.println("----------------");
                System.out.println("Escriba 0 para Salir o 1 para continuar");
                salir = lectura.nextInt();
            } else {
                System.out.println("SALDO INSUFICIENTE!!!");
                salir = 0;
            }
        }
            System.out.println("#################");
            System.out.println("COMPRAS REALIZADAS:\n");
            Collections.sort(tarjeta.getListaDeCompras());
            for (Compra compra : tarjeta.getListaDeCompras()){
                System.out.println(compra.getDescripcion() + "--" +compra.getValor());
            }
            System.out.println("######################");
            System.out.println("\n saldo de la tarjeta: " + tarjeta.getSaldo());
        }
    }
