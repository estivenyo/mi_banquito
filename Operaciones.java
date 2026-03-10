import java.util.Scanner;

class Operaciones {
    public static void depositar(Banco banco, Scanner sc) {
        System.out.print("Número de cuenta: ");
        String num = sc.nextLine();
        Cuenta cuenta = banco.buscarCuenta(num);
        if (cuenta != null) {
            System.out.print("Monto a depositar: ");
            double monto = sc.nextDouble();
            cuenta.depositar(monto);
            banco.registrarTransaccion(new Transaccion("T" + (banco.totalTransacciones()+1), "DEPOSITO", monto));
            System.out.println("Depósito realizado.");
        } else {
            System.out.println("Cuenta no encontrada.");
        }
    }

    public static void retirar(Banco banco, Scanner sc) {
        System.out.print("Número de cuenta: ");
        String num = sc.nextLine();
        Cuenta cuenta = banco.buscarCuenta(num);
        if (cuenta != null) {
            System.out.print("Monto a retirar: ");
            double monto = sc.nextDouble();
            if (cuenta.retirar(monto)) {
                banco.registrarTransaccion(new Transaccion("T" + (banco.totalTransacciones()+1), "RETIRO", monto));
                System.out.println("Retiro realizado.");
            } else {
                System.out.println("Fondos insuficientes.");
            }
        } else {
            System.out.println("Cuenta no encontrada.");
        }
    }

    public static void transferir(Banco banco, Scanner sc) {
        System.out.print("Cuenta origen: ");
        String numOri = sc.nextLine();
        System.out.print("Cuenta destino: ");
        String numDes = sc.nextLine();
        Cuenta origen = banco.buscarCuenta(numOri);
        Cuenta destino = banco.buscarCuenta(numDes);
        if (origen != null && destino != null) {
            System.out.print("Monto a transferir: ");
            double monto = sc.nextDouble();
            banco.transferir(origen, destino, monto);
        } else {
            System.out.println("Cuenta origen o destino no encontrada.");
        }
    }

    public static void verSaldo(Banco banco, Scanner sc) {
        System.out.print("Número de cuenta: ");
        String num = sc.nextLine();
        Cuenta cuenta = banco.buscarCuenta(num);
        if (cuenta != null) {
            System.out.println("Saldo disponible: " + cuenta.getSaldo());
        } else {
            System.out.println("Cuenta no encontrada.");
        }
    }
}

