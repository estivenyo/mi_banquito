class CuentaCorriente extends Cuenta {
    private static final double LIMITE_SOBREGIRO = 500000;

    public CuentaCorriente(String numero, String titular, double saldoInicial) {
        super(numero, titular, saldoInicial);
    }

    @Override
    public boolean retirar(double monto) {
        if (monto <= 0) {
            System.out.println("El monto a retirar debe ser positivo.");
            return false;
        }
        if (monto <= saldo + LIMITE_SOBREGIRO) {
            saldo -= monto;
            return true;
        }
        System.out.println("Fondos insuficientes incluso con sobregiro.");
        return false;
    }
}
