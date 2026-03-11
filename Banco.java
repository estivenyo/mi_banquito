import java.util.ArrayList;
import java.util.List;

class Banco {
    private final List<Cuenta> cuentas = new ArrayList<>();
    private final List<Transaccion> transacciones = new ArrayList<>();

    public void agregarCuenta(Cuenta cuenta) { cuentas.add(cuenta); }

    public Cuenta buscarCuenta(String numero) {
        return cuentas.stream()
                      .filter(c -> c.getNumero().equals(numero))
                      .findFirst()
                      .orElse(null);
    }

    public void registrarTransaccion(Transaccion t) { transacciones.add(t); }

    public boolean transferir(Cuenta origen, Cuenta destino, double monto) {
        if (origen.retirar(monto)) {
            destino.depositar(monto);
            registrarTransaccion(new Transaccion("T" + (transacciones.size() + 1), "TRANSFERENCIA", monto));
            return true;
        }
        System.out.println("Transferencia rechazada: fondos insuficientes.");
        return false;
    }

    public void mostrarTransacciones() {
        transacciones.forEach(System.out::println);
    }

    public int totalTransacciones() { return transacciones.size(); }

    public void mostrarCuentas() {
        cuentas.forEach(c -> {
            String tipo = (c instanceof CuentaAhorro) ? "Cuenta de Ahorro" : "Cuenta Corriente";
            System.out.println(tipo + " | Titular: " + c.getTitular() +
                               " | Número: " + c.getNumero() +
                               " | Saldo: " + c.getSaldo());
        });
    }
}