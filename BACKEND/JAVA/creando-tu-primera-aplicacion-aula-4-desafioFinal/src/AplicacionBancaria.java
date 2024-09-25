import java.util.Scanner;

public class AplicacionBancaria {
    public static void main(String[] args) {
        // Crear una cuenta bancaria para Tony Stark con un saldo inicial de 1599.99
        CuentaBancaria cuenta = new CuentaBancaria("Tony Stark", 1599.99);

        // Crear un scanner para leer la entrada del usuario
        Scanner scanner = new Scanner(System.in);

        int opcion = 0;
        // Mostrar el menú y procesar las opciones hasta que el usuario decida salir
        while (opcion != 9) {
            // Mostrar el menú
            System.out.println("\n--- Menú de Opciones ---");
            System.out.println("1. Consultar saldo");
            System.out.println("2. Retirar");
            System.out.println("3. Depositar");
            System.out.println("9. Salir");
            System.out.print("Elige una opción: ");

            // Leer la opción elegida por el usuario
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    // Consultar saldo
                    System.out.println("Saldo disponible: $" + cuenta.getSaldo());
                    break;
                case 2:
                    // Retirar dinero
                    System.out.print("¿Cuánto deseas retirar?: $");
                    double montoRetiro = scanner.nextDouble();
                    cuenta.retirar(montoRetiro);
                    break;
                case 3:
                    // Depositar dinero
                    System.out.print("¿Cuánto deseas depositar?: $");
                    double montoDeposito = scanner.nextDouble();
                    cuenta.depositar(montoDeposito);
                    break;
                case 9:
                    // Salir del programa
                    System.out.println("Muchas gracias por usar nuestros servicios.");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, elige una opción del menú.");
                    break;
            }
        }

        // Cerrar el scanner
        scanner.close();
    }
}

// Clase que representa una cuenta bancaria
class CuentaBancaria {
    private String titular;
    private double saldo;

    // Constructor
    public CuentaBancaria(String titular, double saldoInicial) {
        this.titular = titular;
        this.saldo = saldoInicial;
    }

    // Método para obtener el saldo
    public double getSaldo() {
        return saldo;
    }

    // Método para retirar dinero
    public void retirar(double cantidad) {
        if (cantidad > saldo) {
            System.out.println("Saldo insuficiente. No se puede retirar $" + cantidad);
        } else {
            saldo -= cantidad;
            System.out.println("Retiro exitoso. Saldo restante: $" + saldo);
        }
    }

    // Método para depositar dinero
    public void depositar(double cantidad) {
        if (cantidad > 0) {
            saldo += cantidad;
            System.out.println("Depósito exitoso. Saldo actualizado: $" + saldo);
        } else {
            System.out.println("El monto a depositar debe ser positivo.");
        }
    }
}