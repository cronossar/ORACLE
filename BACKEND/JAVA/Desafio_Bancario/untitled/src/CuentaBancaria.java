public class CuentaBancaria {

        private String titular;
        private double saldo;

        public CuentaBancaria(String titular, double saldoInicial) {
            this.titular = titular;
            this.saldo = saldoInicial;
        }

        public double getSaldo() {
            return this.saldo;
        }

        public void retirar(double cantidad) {
            if (cantidad > this.saldo) {
                System.out.println("Saldo insuficiente. No se puede retirar $" + cantidad);
            } else {
                this.saldo -= cantidad;
                System.out.println("Retiro exitoso. Saldo restante: $" + this.saldo);
            }

        }

        public void depositar(double cantidad) {
            if (cantidad > 0.0) {
                this.saldo += cantidad;
                System.out.println("Depósito exitoso. Saldo actualizado: $" + this.saldo);
            } else {
                System.out.println("El monto a depositar debe ser positivo.");
            }

        }
    }


