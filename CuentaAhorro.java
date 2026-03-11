class CuentaAhorro extends Cuenta {
    private static final double INTERES_ANUAL = 0.02;

    public CuentaAhorro(String numero, String titular, double saldoInicial) {
        super(numero, titular, saldoInicial);
    }

    @Override
    public boolean retirar(double monto) {
        if (monto <= 0) {
            System.out.println("El monto a retirar debe ser positivo.");
            return false;
        }
        if (monto <= saldo) {
            saldo -= monto;
            return true;
        }
        System.out.println("Fondos insuficientes en cuenta de ahorro.");
        return false;
    }

    public void aplicarInteres() {
        saldo += saldo * INTERES_ANUAL;
    }
}
