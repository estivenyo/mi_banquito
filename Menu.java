import java.util.Scanner;

class Menu {
    private final Banco banco;
    private final Scanner sc;

    public Menu(Banco banco, Scanner sc) {
        this.banco = banco;
        this.sc = sc;
    }

    public void iniciar() {
        System.out.println("=== Sistema Bancario ===");
        cargarCuentasPredeterminadas();

        int opcion;
        do {
            mostrarOpciones();
            opcion = sc.nextInt();
            sc.nextLine(); // limpiar buffer
            ejecutarOpcion(opcion);
        } while (opcion != 0);
    }

    private void cargarCuentasPredeterminadas() {
        banco.agregarCuenta(new CuentaAhorro("1111111111", "Wilson Arley Ruiz Ruiz", 1200000));
        banco.agregarCuenta(new CuentaAhorro("2222222222", "Juan Jose Rosero Gonzalez", 950000));
        banco.agregarCuenta(new CuentaCorriente("3333333333", "Cristian Ivan Dorado Perez", 800000));
        banco.agregarCuenta(new CuentaCorriente("4444444444", "George Estiven Campo Ordoñez", 500000));

        System.out.println("Cuentas predeterminadas cargadas.");
    }

    private void mostrarOpciones() {
        System.out.println("\n--- Menú ---");
        System.out.println("Cuentas disponibles:");
        banco.mostrarCuentas();

        System.out.println("\n1. Depositar");
        System.out.println("2. Retirar");
        System.out.println("3. Transferir");
        System.out.println("4. Ver saldo");
        System.out.println("5. Ver transacciones");
        System.out.println("0. Salir");
        System.out.print("Seleccione opción: ");
    }

    private void ejecutarOpcion(int opcion) {
        switch (opcion) {
            case 1 -> Operaciones.depositar(banco, sc);
            case 2 -> Operaciones.retirar(banco, sc);
            case 3 -> Operaciones.transferir(banco, sc);
            case 4 -> Operaciones.verSaldo(banco, sc);
            case 5 -> banco.mostrarTransacciones();
            case 0 -> System.out.println("Saliendo del sistema...");
            default -> System.out.println("Opción inválida.");
        }
    }
}