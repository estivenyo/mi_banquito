import java.util.Date;

class Transaccion {
    private final String id;
    private final String tipo;
    private final double monto;
    private final Date fecha;

    public Transaccion(String id, String tipo, double monto) {
        if (monto <= 0) {
            throw new IllegalArgumentException("El monto de la transacción debe ser positivo.");
        }
        this.id = id;
        this.tipo = tipo;
        this.monto = monto;

        Date hoy = new Date();
        // Nunca permitir fechas futuras
        this.fecha = hoy.after(new Date()) ? new Date() : hoy;
    }

    @Override
    public String toString() {
        return "Transacción " + id + " [" + tipo + "] Monto: " + monto + " Fecha: " + fecha;
    }
}