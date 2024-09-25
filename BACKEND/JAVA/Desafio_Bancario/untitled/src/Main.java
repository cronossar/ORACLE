import java.util.Scanner;

public class Main {



    //public class AplicacionBancaria {
     //   public AplicacionBancaria() {
     //   }

        public static void main(String[] args) {
            CuentaBancaria cuenta = new CuentaBancaria("Tony Stark", 1599.99);
            Scanner scanner = new Scanner(System.in);
            int opcion = 0;

            while(opcion != 9) {
                System.out.println("\n--- Menú de Opciones ---");
                System.out.println("1. Consultar saldo");
                System.out.println("2. Retirar");
                System.out.println("3. Depositar");
                System.out.println("9. Salir");
                System.out.print("Elige una opción: ");
                opcion = scanner.nextInt();
                switch (opcion) {
                    case 1:
                        System.out.println("Saldo disponible: $" + cuenta.getSaldo());
                        break;
                    case 2:
                        System.out.print("¿Cuánto deseas retirar?: $");
                        double montoRetiro = scanner.nextDouble();
                        cuenta.retirar(montoRetiro);
                        break;
                    case 3:
                        System.out.print("¿Cuánto deseas depositar?: $");
                        double montoDeposito = scanner.nextDouble();
                        cuenta.depositar(montoDeposito);
                        break;
                    case 4:
                    case 5:
                    case 6:
                    case 7:
                    case 8:
                    default:
                        System.out.println("Opción no válida. Por favor, elige una opción del menú.");
                        break;
                    case 9:
                        System.out.println("Muchas gracias por usar nuestros servicios.");
                }
            }

            scanner.close();
        }
    }


