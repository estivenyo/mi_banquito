class CuentaCorriente extends Cuenta {
    private static final double LIMITE_SOBREGIRO = 500000;

    public CuentaCorriente(String numero, String titular, double saldoInicial) {
        super(numero, titular, saldoInicial);
    }

    @Override
    public boolean retirar(double monto) {
        if (monto <= saldo + LIMITE_SOBREGIRO) {
            saldo -= monto;
            return true;
        }
        return false;
    }
}